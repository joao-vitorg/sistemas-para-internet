package com.example.projetomvc.predio.model;

import lombok.Data;

@Data
public class Apartamento {
    private int id;
    private int numero;
    private int quartos;
    private String tipo;
    private Proprietario proprietario;
}
