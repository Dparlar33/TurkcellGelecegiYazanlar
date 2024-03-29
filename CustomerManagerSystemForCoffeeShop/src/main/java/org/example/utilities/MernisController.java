package org.example.utilities;

import org.example.entities.Customer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


// Bu kısımda Mernis sitemi kullanılarak dogrulama yapılmıstır.
// Ilk olarak Mernis dogrulamasını https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx?op=TCKimlikNoDogrula
// adresini inceledigimiz zaman bizlere bir kaç önemli bilgi vermektedir.
// Ilk olarak bizden SOAP web servis standartını kullanarak XML formatında bir isteği POST olarak verilen
// Host'a göndermemizi ve bu istek sonucunda içerisinde boolean sonuç döndüren bir XML formatı elde ettiğimizi söylüyor.
// Burada yazılan kod içerisinde ilk olarak Customer nesnesi içerisindeki fieldlar istenilen XML formatına dönüştürülüyor.
// Bu dönüştürme işlemi CustomerToXML ile yapılıyor. Bu method içerisinde Customer nesnesi fieldlarıyla bir XML formatına
// dönüştürülüyor. Daha sonra elde edilen XML yapısı içeren String createSoap methodu ile POST isteğiyle
// Istenilen adrese istek gönderiyor. Gönderilen istek sonucunda elde edilen XML formatlı yapıyı ise tekrardan
// responseToXml ile XML yapısına çeviriyoruz. Bize geri dönderilen XML içerisindeki boolean ifadeye erişip
// Bu boolean ifadeyi return edip doğrulama kısmını tamamlamış oluyoruz.
public class MernisController implements ICustomerChecker {
    @Override
    public boolean isValid(Customer customer) throws IOException, ParserConfigurationException, SAXException {
        return createSoap(customer);
    }

    public boolean createSoap(Customer customer) throws IOException, ParserConfigurationException, SAXException {

        String soapXml = CustomerToXml(customer);
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL("https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
            connection.setDoOutput(true);

            try (OutputStream outputStream = connection.getOutputStream()) {
                byte[] soapBytes = soapXml.getBytes("UTF-8");
                outputStream.write(soapBytes, 0, soapBytes.length);
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseToXml(response.toString());
    }

    public boolean responseToXml(String response) throws IOException, SAXException, ParserConfigurationException {
        String resultValue="";
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(response)));

             resultValue= doc.getElementsByTagName("TCKimlikNoDogrulaResult").item(0).getTextContent();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.parseBoolean(resultValue);
    }

    public String CustomerToXml(Customer customer){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();


            Element envelope = doc.createElement("soap:Envelope");
            envelope.setAttribute("xmlns:soap", "http://schemas.xmlsoap.org/soap/envelope/");
            envelope.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            envelope.setAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");

            Element body = doc.createElement("soap:Body");

            Element tckimlikNoDogrula = doc.createElement("TCKimlikNoDogrula");
            tckimlikNoDogrula.setAttribute("xmlns", "http://tckimlik.nvi.gov.tr/WS");


            Element tcKimlikNo = doc.createElement("TCKimlikNo");
            tcKimlikNo.setTextContent(customer.getIdentityNumber());
            tckimlikNoDogrula.appendChild(tcKimlikNo);


            Element ad = doc.createElement("Ad");
            ad.setTextContent(customer.getName());
            tckimlikNoDogrula.appendChild(ad);


            Element soyad = doc.createElement("Soyad");
            soyad.setTextContent(customer.getSurname());
            tckimlikNoDogrula.appendChild(soyad);


            Element dogumYili = doc.createElement("DogumYili");
            dogumYili.setTextContent(String.valueOf(customer.getDateOfBirth().getYear()));
            tckimlikNoDogrula.appendChild(dogumYili);

            body.appendChild(tckimlikNoDogrula);
            envelope.appendChild(body);
            doc.appendChild(envelope);
            return documentToString(doc);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String documentToString(Document doc) {
        try {
            javax.xml.transform.TransformerFactory transformerFactory = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
            java.io.StringWriter writer = new java.io.StringWriter();
            javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(writer);
            transformer.transform(source, result);
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
