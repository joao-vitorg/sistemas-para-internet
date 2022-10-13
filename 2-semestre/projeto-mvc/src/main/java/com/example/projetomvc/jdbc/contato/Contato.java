package com.example.projetomvc.jdbc.contato;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contato {
    private Long id;
    private String nome;
    private String telefone;
    private String endereco;
}
