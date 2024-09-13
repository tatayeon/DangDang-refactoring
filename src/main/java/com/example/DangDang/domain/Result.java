package com.example.DangDang.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Result {

    @Id
    @GeneratedValue
    private long id;

    private int rank;

    private String species;

    private double probability;

}
