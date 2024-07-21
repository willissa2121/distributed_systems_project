package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Container;
import com.example.service.ContainerService;

@RestController
@RequestMapping("/containers")
public class ContainerController {
    @Autowired
    private ContainerService containerService;

    @GetMapping
    public List<Container> getAllContainers() {
        return containerService.getAllContainers();
    }

    @GetMapping("/{id}")
    public Container getContainerById(@PathVariable Integer id) {
        return containerService.getContainerById(id);
    }

    @PostMapping
    public Container createContainer(@RequestBody Container container) {
        return containerService.createContainer(container);
    }

    @PutMapping("/{id}")
    public Container updateContainer(@PathVariable Integer id, @RequestBody Container containerDetails) {
        return containerService.updateContainer(id, containerDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteContainer(@PathVariable Integer id) {
        containerService.deleteContainer(id);
    }
}

