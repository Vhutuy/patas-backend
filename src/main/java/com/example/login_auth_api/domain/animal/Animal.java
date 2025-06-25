package com.example.login_auth_api.domain.animal;

import com.example.login_auth_api.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name="animais")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String Nome;

    @Enumerated(EnumType.STRING)
    private Especie especie;

    @Enumerated(EnumType.STRING)
    private RacaCachorro raca;

    private String cor;

    @Enumerated(EnumType.STRING)
    private Tamanho tamanho;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private Integer idade;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "user_id") // Foreign key para a tabela 'users'
    @JsonIgnore
    private User user;

}
