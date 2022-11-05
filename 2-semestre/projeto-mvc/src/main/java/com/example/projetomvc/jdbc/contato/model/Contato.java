package com.example.projetomvc.jdbc.contato.model;

import lombok.Data;

@Data
public class Contato {
    private int id;
    private String nome;
    private String telefone;
    private String endereco;
    private Tipo tipo;
}
