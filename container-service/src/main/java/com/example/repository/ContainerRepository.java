package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Container;

public interface ContainerRepository extends JpaRepository<Container, Integer> {
}

