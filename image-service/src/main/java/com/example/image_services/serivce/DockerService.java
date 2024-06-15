package com.example.image_services.serivce;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.PullImageResultCallback;
import com.github.dockerjava.api.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DockerService {

    private static final Logger logger = LoggerFactory.getLogger(DockerService.class);

    @Autowired
    private DockerClient dockerClient;

    public String startDockerContainer(String imageName, String tag, int hostPort, int containerPort) {
        String image = imageName + ":" + tag;

        try {
            dockerClient.pullImageCmd(image)
                    .exec(new PullImageResultCallback())
                    .awaitCompletion();

            ExposedPort tcpContainerPort = ExposedPort.tcp(containerPort);
            Ports portBindings = new Ports();
            portBindings.bind(tcpContainerPort, Ports.Binding.bindPort(hostPort));

            CreateContainerResponse container = dockerClient.createContainerCmd(image)
                    .withExposedPorts(tcpContainerPort)
                    .withHostConfig(
                            new HostConfig()
                                    .withPortBindings(new PortBinding(Ports.Binding.bindPort(hostPort), tcpContainerPort))
                    )
                    .exec();

            dockerClient.startContainerCmd(container.getId()).exec();

            return "Container started with ID: " + container.getId();
        } catch (Exception e) {
            logger.error("Error starting Docker container for image {}:{}", imageName, tag, e);
            return "Error starting Docker container: " + e.getMessage();
        }
    }

    public String stopDockerContainer(String containerName) {
        try {
            List<Container> containers = dockerClient.listContainersCmd()
                    .withNameFilter(Collections.singletonList(containerName))
                    .exec();

            if (containers.isEmpty()) {
                return "Container not found";
            }

            Container container = containers.get(0);
            dockerClient.stopContainerCmd(container.getId()).exec();
            return "Container stopped: " + container.getId();
        } catch (Exception e) {
            logger.error("Error stopping Docker container {}: {}", containerName, e);
            return "Error stopping Docker container: " + e.getMessage();
        }
    }

    
}


