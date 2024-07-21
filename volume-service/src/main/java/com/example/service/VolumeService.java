package com.example.service;

import com.example.repository.*;
import com.example.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolumeService {
    @Autowired
    private VolumeRepository volumeRepository;

    public List<Volume> getAllVolumes() {
        return volumeRepository.findAll();
    }

    public Volume getVolumeById(Integer id) {
        return volumeRepository.findById(id).orElse(null);
    }

    public Volume createVolume(Volume volume) {
        return volumeRepository.save(volume);
    }

    public Volume updateVolume(Integer id, Volume volumeDetails) {
        Volume volume = volumeRepository.findById(id).orElse(null);
        if (volume != null) {
            volume.setSha(volumeDetails.getSha());
            volume.setStatus(volumeDetails.getStatus());
            volume.setCreated(volumeDetails.getCreated());
            volume.setSize(volumeDetails.getSize());
            return volumeRepository.save(volume);
        }
        return null;
    }

    public void deleteVolume(Integer id) {
        volumeRepository.deleteById(id);
    }
}

