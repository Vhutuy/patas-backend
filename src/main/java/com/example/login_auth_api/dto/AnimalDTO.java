package com.example.login_auth_api.dto;

import com.example.login_auth_api.domain.animal.Especie;
import com.example.login_auth_api.domain.animal.RacaCachorro;
import com.example.login_auth_api.domain.animal.Sexo;
import com.example.login_auth_api.domain.animal.Tamanho;
import lombok.Data;

@Data
public class AnimalDTO {
    private String nome;
    private Especie especie;
    private RacaCachorro raca; // Opcional, só se especie for CACHORRO
    private String cor;
    private Tamanho tamanho;
    private Sexo sexo;
    private Integer idade;
    private String descricao;
    private String userId; // Adicionado para vincular o animal ao usuário
}
