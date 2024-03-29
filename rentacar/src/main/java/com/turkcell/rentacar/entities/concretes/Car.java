package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
    @Column(name = "findex_score")
    private int findexScore;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "plate")
    private String plate;

    @Column(name = "state")
    private State state;

    @Column(name = "daily_price")
    private int dailyPrice;

    @ManyToOne()
    @JoinColumn(name = "model_id")
    private Model model;

    @OneToMany(mappedBy = "car")
    private List<Maintenance> maintenances;

    @OneToMany(mappedBy = "car")
    private List<Rental> rentals;

    @Getter
    public enum State {
        Available(1),
        Rented(2),
        Under_Maintenance(3);
        private final int value;

        State(int value) {
            this.value = value;
        }

    }
}
