package com.example.login_auth_api.repositories;

import com.example.login_auth_api.domain.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, String> {
    Optional<Pessoa> findByUserId(String userId); // Busca Pessoa por userId
}
