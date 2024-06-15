package com.example.metadataService.service;

import com.example.metadataService.model.ImageMetadata;
import com.example.metadataService.repository.MetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetadataService {

    @Autowired
    private MetadataRepository repository;

    public List<ImageMetadata> findAll() {
        return repository.findAll();
    }

    public ImageMetadata findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ImageMetadata save(ImageMetadata metadata) {
        return repository.save(metadata);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
