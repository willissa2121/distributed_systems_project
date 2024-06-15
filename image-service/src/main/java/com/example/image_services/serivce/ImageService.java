package com.example.image_services.serivce;

import com.example.image_services.model.DockerImage;
import com.example.image_services.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository repository;

    public List<DockerImage> findAll() {
        return repository.findAll();
    }

    public DockerImage findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public DockerImage save(DockerImage image) {
        return repository.save(image);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
