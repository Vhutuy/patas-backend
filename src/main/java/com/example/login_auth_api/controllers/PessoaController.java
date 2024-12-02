package com.example.login_auth_api.controllers;

import com.example.login_auth_api.domain.pessoa.Pessoa;
import com.example.login_auth_api.domain.user.User;
import com.example.login_auth_api.dto.PessoaDTO;
import com.example.login_auth_api.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private com.example.login_auth_api.repositories.PessoaRepository pessoaRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        // Validar se o usuário existe
        User user = userRepository.findById(pessoaDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + pessoaDTO.getUserId()));

        // Criar a nova pessoa e associá-la ao usuário
        Pessoa pessoa = new Pessoa();
        pessoa.setNomeCompleto(pessoaDTO.getNomeCompleto());
        pessoa.setDataNascimento(pessoaDTO.getDataNascimento());
        pessoa.setCpf(pessoaDTO.getCpf());
        pessoa.setEndereco(pessoaDTO.getEndereco());
        pessoa.setTelefone(pessoaDTO.getTelefone());
        pessoa.setEmail(pessoaDTO.getEmail());
        pessoa.setTipoAnimalDesejado(pessoaDTO.getTipoAnimalDesejado());
        pessoa.setExperienciaComAnimais(pessoaDTO.getExperienciaComAnimais());
        pessoa.setUser(user);  // Associando a pessoa ao usuário

        // Salvar a pessoa no banco de dados
        Pessoa savedPessoa = pessoaRepository.save(pessoa);

        return ResponseEntity.ok(savedPessoa);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Pessoa> obterPessoaPorUserId(@PathVariable String userId) {
        Pessoa pessoa = pessoaRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada para o usuário com id: " + userId));

        return ResponseEntity.ok(pessoa);
    }
}
