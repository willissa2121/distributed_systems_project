package com.example.image_services.config;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DockerClientConfig {

    @Bean
    public DockerClient dockerClient() {
        // Check if DOCKER_HOST environment variable is set
        String dockerHost = System.getenv("DOCKER_HOST");
        if (dockerHost == null || dockerHost.isEmpty()) {
            dockerHost = "tcp://localhost:2375"; // Default to localhost if DOCKER_HOST is not set
        }

        DefaultDockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
                .withDockerHost(dockerHost)
                .build();
        
        return DockerClientBuilder.getInstance(config).build();
    }
}
