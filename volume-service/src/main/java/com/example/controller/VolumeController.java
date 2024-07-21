package com.example.controller;

import com.example.model.*;
import com.example.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volumes")
public class VolumeController {
    @Autowired
    private VolumeService volumeService;

    @GetMapping
    public List<Volume> getAllVolumes() {
        return volumeService.getAllVolumes();
    }

    @GetMapping("/{id}")
    public Volume getVolumeById(@PathVariable Integer id) {
        return volumeService.getVolumeById(id);
    }

    @PostMapping
    public Volume createVolume(@RequestBody Volume volume) {
        return volumeService.createVolume(volume);
    }

    @PutMapping("/{id}")
    public Volume updateVolume(@PathVariable Integer id, @RequestBody Volume volumeDetails) {
        return volumeService.updateVolume(id, volumeDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteVolume(@PathVariable Integer id) {
        volumeService.deleteVolume(id);
    }
}

