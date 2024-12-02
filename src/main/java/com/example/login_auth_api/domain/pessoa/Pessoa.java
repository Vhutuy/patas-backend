package com.example.login_auth_api.domain.pessoa;

import com.example.login_auth_api.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pessoas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nomeCompleto;
    private String dataNascimento;
    private String cpf;

    @Embedded
    private Endereco endereco;

    private String telefone;
    private String email;
    private String tipoAnimalDesejado;
    private String experienciaComAnimais;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;  // Relacionamento com User

    public Pessoa(String nomeCompleto, String dataNascimento, String cpf, Endereco endereco,
                  String telefone, String email, String tipoAnimalDesejado, String experienciaComAnimais, User user) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.tipoAnimalDesejado = tipoAnimalDesejado;
        this.experienciaComAnimais = experienciaComAnimais;
        this.user = user;
    }
}
