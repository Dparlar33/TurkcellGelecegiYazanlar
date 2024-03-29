package com.turkcell.rentacar.adapter;

import com.turkcell.rentacar.adapter.result.FindexResult;

public interface FindexService {
    FindexResult getFindexScoreofCustomer(int customerId);
}
