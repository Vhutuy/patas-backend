package com.example.login_auth_api.repositories;

import com.example.login_auth_api.domain.animal.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnimalRepository extends JpaRepository<Animal, String> {

}
