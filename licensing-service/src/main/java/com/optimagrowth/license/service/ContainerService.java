package com.optimagrowth.license.service;

import java.util.UUID;

import com.optimagrowth.license.model.Container;
import com.optimagrowth.license.repository.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.optimagrowth.license.config.ServiceConfig;
import com.optimagrowth.license.model.License;
import com.optimagrowth.license.repository.LicenseRepository;

@Service
public class ContainerService {

    @Autowired
    MessageSource messages;

    @Autowired
    private ContainerRepository c;

    @Autowired
    ServiceConfig config;


    public Container getContainer(String containerId){
        Container cc = c.findByContainerId(containerId);
        if (null == cc) {
            throw new IllegalArgumentException(String.format(messages.getMessage("license.search.error.message", null, null),containerId));
        }
        return cc;
    }

    public Container createContainer(Container container){
        container.setContainerId(UUID.randomUUID().toString());
        System.out.println(container);
//        license.setComment(config.getProperty());
        c.save(container);

        return container;
    }

    public Container updateContainer(Container container){
//        license.setComment(config.getProperty());
        c.save(container);
        return container;
    }

    public String deleteContainer(String containerId){
        String responseMessage = null;
        c.deleteByContainerId(containerId);
        responseMessage = String.format(messages.getMessage("license.delete.message", null, null),containerId);
        return responseMessage;

    }


}
