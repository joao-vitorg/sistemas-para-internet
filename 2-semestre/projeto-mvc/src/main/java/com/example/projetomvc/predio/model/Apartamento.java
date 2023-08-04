package com.example.projetomvc.predio.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class Apartamento {
    private int id;
    @NotNull(message = "O campo andar é obrigatório")
    @Positive(message = "O numero deve ser maior que zero")
    private int numero;
    @NotNull(message = "O campo quartos é obrigatório")
    @Positive(message = "O quartos deve ser maior que zero")
    private int quartos;
    @NotEmpty(message = "O campo tipo é obrigatório")
    private String tipo;
    @NotNull(message = "O campo proprietario é obrigatório")
    private Proprietario proprietario;
}
