package com.example.service;

import com.example.model.*;
import com.example.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public Image getImageById(Integer id) {
        return imageRepository.findById(id).orElse(null);
    }

    public Image createImage(Image image) {
        return imageRepository.save(image);
    }

    public Image updateImage(Integer id, Image imageDetails) {
        Image image = imageRepository.findById(id).orElse(null);
        if (image != null) {
            image.setName(imageDetails.getName());
            image.setTag(imageDetails.getTag());
            image.setStatus(imageDetails.getStatus());
            image.setCreated(imageDetails.getCreated());
            image.setSize(imageDetails.getSize());
            image.setUserId(imageDetails.getUserId());
            return imageRepository.save(image);
        }
        return null;
    }

    public void deleteImage(Integer id) {
        imageRepository.deleteById(id);
    }
}
