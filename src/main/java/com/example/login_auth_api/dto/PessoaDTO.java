package com.example.login_auth_api.dto;

import com.example.login_auth_api.domain.pessoa.Endereco;
import lombok.Data;

@Data
public class PessoaDTO {

    private String nomeCompleto;
    private String dataNascimento;
    private String cpf;
    private Endereco endereco;  // Usando a classe Endereco
    private String telefone;
    private String email;
    private String tipoAnimalDesejado;
    private String experienciaComAnimais;
    private String userId;  // Relacionado ao id do usuário

}
