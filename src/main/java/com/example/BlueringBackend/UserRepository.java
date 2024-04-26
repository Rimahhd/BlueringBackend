package com.example.BlueringBackend;

import com.example.BlueringBackend.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}