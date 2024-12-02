package com.example.login_auth_api.domain.user;

import com.example.login_auth_api.domain.animal.Animal;
import com.example.login_auth_api.domain.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private  String id;
    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Animal> animais; // Lista de animais associados ao usuário

    @OneToOne(mappedBy = "user")
    private Pessoa pessoa; // Relacionamento com a Pessoa

}
