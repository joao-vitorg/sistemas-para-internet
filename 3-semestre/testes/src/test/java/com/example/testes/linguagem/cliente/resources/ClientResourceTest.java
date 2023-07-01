package com.example.testes.linguagem.cliente.resources;

import com.example.testes.linguagem.cliente.dto.ClientDTO;
import com.example.testes.linguagem.cliente.entities.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.Instant;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ClientResourceTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void insertShouldReturnClientDTOCreated() throws Exception {
        ClientDTO cliente = new ClientDTO(new Client(null, "Jose Saramago", "10239254871", 5000.0, Instant.parse("1996-12-23T07:00:00Z"), 0));
        String json = objectMapper.writeValueAsString(cliente);

        ResultActions result = mockMvc.perform(post("/clients")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(cliente.getName()))
                .andExpect(jsonPath("$.cpf").value(cliente.getCpf()));
    }

    @Test
    public void deleteIdShouldExists() throws Exception {
        long id = 1L;

        ResultActions result = mockMvc.perform(delete("/clients/{id}", id));

        result.andExpect(status().isNoContent());
    }

    @Test
    public void deleteIdShouldNotExists() throws Exception {
        long id = -1L;

        ResultActions result = mockMvc.perform(delete("/clients/{id}", id));

        result.andExpect(status().isNotFound());
    }

    @Test
    public void findByIncomeExists() throws Exception {
        String income = "1500";

        ResultActions result = mockMvc.perform(get("/clients/income").param("income", income));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content[?(@.id == '%s')]", 10L).exists())
                .andExpect(jsonPath("$.content[?(@.id == '%s')]", 1L).exists())
                .andExpect(jsonPath("$.content[?(@.id == '%s')]", 9L).exists());
    }

    @Test
    public void updateExists() throws Exception {
        ClientDTO cliente = new ClientDTO(new Client(1L, "Conceição Evaristo", "999999", 1500D, Instant.parse("2020-07-13T20:50:00Z"), 2));
        String json = objectMapper.writeValueAsString(cliente);

        ResultActions result = mockMvc.perform(put("/clients/{id}", cliente.getId())
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(cliente.getName()))
                .andExpect(jsonPath("$.cpf").value(cliente.getCpf()));
    }
}

