package com.example.metadataService.repository;

import com.example.metadataService.model.ImageMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetadataRepository extends JpaRepository<ImageMetadata, Long> {
}
