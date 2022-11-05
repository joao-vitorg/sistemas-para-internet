package com.example.projetomvc.jdbc.condominio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Apartamento {
    private int id;
    private int numero;
    private int quartos;
    private String tipo;
    private Proprietario proprietario;
}
