package com.example.projetomvc.predio.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class Proprietario {
    private int id;
    @NotEmpty(message = "O campo nome é obrigatório")
    @Size(min = 1, max = 50, message = "O nome deve ter entre 1 e 50 caracteres")
    private String nome;
    @NotEmpty(message = "O campo telefone é obrigatório")
    @Size(min = 1, max = 20, message = "O telefone deve ter entre 1 e 20 caracteres")
    private String telefone;
}
