package com.example.projetomvc.jdbc.condominio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Proprietario {
    private int id;
    private String nome;
    private String telefone;
}
