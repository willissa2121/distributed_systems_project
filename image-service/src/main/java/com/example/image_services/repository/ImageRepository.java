package com.example.image_services.repository;

import com.example.image_services.model.DockerImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<DockerImage, Long> {
}
