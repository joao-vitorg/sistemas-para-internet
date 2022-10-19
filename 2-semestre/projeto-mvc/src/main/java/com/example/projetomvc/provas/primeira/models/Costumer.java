package com.example.projetomvc.provas.primeira.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Costumer {
    private String firstName, lastName, gender, payment;
    private double balance;
}
