package com.example.login_auth_api.controllers;

import com.example.login_auth_api.domain.animal.Animal;
import com.example.login_auth_api.domain.animal.Especie;
import com.example.login_auth_api.domain.user.User;
import com.example.login_auth_api.dto.AnimalDTO;
import com.example.login_auth_api.repositories.AnimalRepository;
import com.example.login_auth_api.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/animais")
public class AnimalController {
    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Animal> listarTodos() {
        return animalRepository.findAll();
    }

@GetMapping("/{id}")
public ResponseEntity<Animal> getAnimalById(@PathVariable UUID id) {
    return animalRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElseThrow(() -> new EntityNotFoundException("Animal não encontrado com o ID: " + id));
}



    @PostMapping
    public Animal salvar(@RequestBody AnimalDTO animalDTO) {
        validarAnimal(animalDTO);

        // Encontrar o usuário pelo ID
        User user = userRepository.findById(animalDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + animalDTO.getUserId()));

        // Criar o animal e vinculá-lo ao usuário
        Animal animal = new Animal();
        animal.setNome(animalDTO.getNome());
        animal.setEspecie(animalDTO.getEspecie());
        animal.setRaca(animalDTO.getRaca());
        animal.setCor(animalDTO.getCor());
        animal.setTamanho(animalDTO.getTamanho());
        animal.setSexo(animalDTO.getSexo());
        animal.setIdade(animalDTO.getIdade());
        animal.setDescricao(animalDTO.getDescricao());
        animal.setUser(user);

        return animalRepository.save(animal);
    }

    private void validarAnimal(AnimalDTO animalDTO) {
        if (animalDTO.getEspecie() == null) {
            throw new IllegalArgumentException("A espécie é obrigatória.");
        }

        if (animalDTO.getEspecie() == Especie.CACHORRO && animalDTO.getRaca() == null) {
            throw new IllegalArgumentException("A raça é obrigatória para cachorros.");
        }

        if (animalDTO.getNome() == null || animalDTO.getNome().isBlank()) {
            animalDTO.setNome(String.valueOf(animalDTO.getEspecie()));
        }
    }
    }
