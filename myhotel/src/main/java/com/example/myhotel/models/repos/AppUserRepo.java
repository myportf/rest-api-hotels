package com.example.myhotel.models.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myhotel.models.entity.AppUser;

public interface AppUserRepo extends JpaRepository<AppUser, Long>  {
    Optional<AppUser> findByEmail(String email);
}
