package com.karolk.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "foods_nutrients")
public class FoodsNutrients implements Serializable {

    private static final long serialVersionUID = 42L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foods_nutrients_id")
    private Long id;

    @ManyToOne
    @Column(name = "food_id")
    private Foods foods;

    @ManyToOne
    @Column(name = "nutrient_id")
    private Nutrients nutrients;
}
