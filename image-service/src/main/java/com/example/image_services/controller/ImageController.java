package com.example.image_services.controller;

import com.example.image_services.model.*;
import com.example.image_services.serivce.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private DockerService dockerService;

    @GetMapping
    public List<DockerImage> getAllImages() {
        return imageService.findAll();
    }

    @GetMapping("/{id}")
    public DockerImage getImageById(@PathVariable Long id) {
        return imageService.findById(id);
    }

    @PostMapping
    public DockerImage createImage(@RequestBody DockerImage image) {
        return imageService.save(image);
    }

    @PutMapping("/{id}")
    public DockerImage updateImage(@PathVariable Long id, @RequestBody DockerImage image) {
        DockerImage existingImage = imageService.findById(id);
        if (existingImage != null) {
            existingImage.setName(image.getName());
            existingImage.setTag(image.getTag());
            existingImage.setRepository(image.getRepository());
            return imageService.save(existingImage);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable Long id) {
        imageService.delete(id);
    }

    @GetMapping("/start/{id}")
    public String startImage(@PathVariable Long id) {
        DockerImage image = imageService.findById(id);
        if (image != null) {
            int hostPort = 8080; // Example port
            int containerPort = 80; // Example port
            return dockerService.startDockerContainer(image.getName(), image.getTag(), hostPort, containerPort);
        }
        return "Image not found";
    }

    @GetMapping("/stop/{name}")
    public String stopImage(@PathVariable String name) {
        return dockerService.stopDockerContainer(name);
    }
}
