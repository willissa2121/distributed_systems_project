package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Container;
import com.example.repository.ContainerRepository;

@Service
public class ContainerService {
    @Autowired
    private ContainerRepository containerRepository;

    public List<Container> getAllContainers() {
        return containerRepository.findAll();
    }

    public Container getContainerById(Integer id) {
        return containerRepository.findById(id).orElse(null);
    }

    public Container createContainer(Container container) {
        return containerRepository.save(container);
    }

    public Container updateContainer(Integer id, Container containerDetails) {
        Container container = containerRepository.findById(id).orElse(null);
        if (container != null) {
            container.setName(containerDetails.getName());
            container.setImageId(containerDetails.getImageId());
            container.setVolumeId(containerDetails.getVolumeId());
            container.setStatus(containerDetails.getStatus());
            container.setPorts(containerDetails.getPorts());
            container.setLastStarted(containerDetails.getLastStarted());
            container.setUserId(containerDetails.getUserId());
            return containerRepository.save(container);
        }
        return null;
    }

    public void deleteContainer(Integer id) {
        containerRepository.deleteById(id);
    }
}

