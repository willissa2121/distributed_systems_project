package com.example.controller;

import com.example.model.*;
import com.example.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }

    @GetMapping("/{id}")
    public Image getImageById(@PathVariable Integer id) {
        return imageService.getImageById(id);
    }

    @PostMapping
    public Image createImage(@RequestBody Image image) {
        return imageService.createImage(image);
    }

    @PutMapping("/{id}")
    public Image updateImage(@PathVariable Integer id, @RequestBody Image imageDetails) {
        return imageService.updateImage(id, imageDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable Integer id) {
        imageService.deleteImage(id);
    }
}

