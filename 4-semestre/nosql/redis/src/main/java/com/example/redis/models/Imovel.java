package com.example.redis.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Imovel {
    @Id
    @PrimaryKey
    private UUID id;

    @Column
    private String endereco;

    @Column
    private String tipo_imovel;

    @Column
    private Double area;

    @Column
    private Double preco;
}
