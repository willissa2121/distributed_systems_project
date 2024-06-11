package com.optimagrowth.license.repository;

import java.util.List;

import com.optimagrowth.license.model.Container;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.optimagrowth.license.model.License;

@Repository
public interface ContainerRepository extends CrudRepository<Container,String>  {
    public Container findByContainerId(String containerId);

    public void deleteByContainerId(String containerId);
}
