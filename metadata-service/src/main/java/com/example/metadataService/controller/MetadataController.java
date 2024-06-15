package com.example.metadataService.controller;

import com.example.metadataService.model.ImageMetadata;
import com.example.metadataService.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metadata")
public class MetadataController {

    @Autowired
    private MetadataService metadataService;

    @GetMapping
    public List<ImageMetadata> getAllMetadata() {
        return metadataService.findAll();
    }

    @GetMapping("/{id}")
    public ImageMetadata getMetadataById(@PathVariable Long id) {
        return metadataService.findById(id);
    }

    @PostMapping
    public ImageMetadata createMetadata(@RequestBody ImageMetadata metadata) {
        return metadataService.save(metadata);
    }

    @PutMapping("/{id}")
    public ImageMetadata updateMetadata(@PathVariable Long id, @RequestBody ImageMetadata metadata) {
        ImageMetadata existingMetadata = metadataService.findById(id);
        if (existingMetadata != null) {
            existingMetadata.setDescription(metadata.getDescription());
            existingMetadata.setAuthor(metadata.getAuthor());
            existingMetadata.setCreatedDate(metadata.getCreatedDate());
            return metadataService.save(existingMetadata);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteMetadata(@PathVariable Long id) {
        metadataService.delete(id);
    }
}
