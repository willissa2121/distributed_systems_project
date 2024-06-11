package com.optimagrowth.license.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.optimagrowth.license.model.Container;
import com.optimagrowth.license.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.optimagrowth.license.model.License;
import com.optimagrowth.license.service.LicenseService;

@RestController
@RequestMapping(value="v1/container")
public class ContainerController {

    @Autowired
    private ContainerService containerService;

    @RequestMapping(value="/{containerId}",method = RequestMethod.GET)
    public ResponseEntity<Container> getContainer( @PathVariable("containerId") String containerId){

        Container c = containerService.getContainer(containerId);
        c.add(
                linkTo(methodOn(ContainerController.class).getContainer(containerId)).withSelfRel(),
                linkTo(methodOn(ContainerController.class).createContainer(c)).withRel("createContainer"),
                linkTo(methodOn(ContainerController.class).updateContainer(c)).withRel("updateContainer"),
                linkTo(methodOn(ContainerController.class).deleteContainer(c.getContainerId())).withRel("deleteContainer")
        );

        return ResponseEntity.ok(c);
    }

    @PutMapping
    public ResponseEntity<Container> updateContainer(@RequestBody Container request) {
        return ResponseEntity.ok(containerService.updateContainer(request));
    }

    @PostMapping
    public ResponseEntity<Container> createContainer(@RequestBody Container request) {
        return ResponseEntity.ok(containerService.createContainer(request));
    }

    @DeleteMapping(value="/{licenseId}")
    public ResponseEntity<String> deleteContainer(@PathVariable("containerId") String containerId) {
        return ResponseEntity.ok(containerService.deleteContainer(containerId));
    }
}
