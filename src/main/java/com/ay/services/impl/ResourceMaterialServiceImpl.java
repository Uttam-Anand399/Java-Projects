package com.ay.services.impl;

import com.ay.entity.ResourceMaterial;
import com.ay.repository.ResourceMaterialRepository;
import com.ay.services.ResourceMaterialService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceMaterialServiceImpl implements ResourceMaterialService {

    private final ResourceMaterialRepository repository;

    public ResourceMaterialServiceImpl(ResourceMaterialRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResourceMaterial addResource(ResourceMaterial material) {
        return repository.save(material);
    }

    @Override
    public List<ResourceMaterial> getAllResources() {
        return repository.findAll();
    }

    @Override
    public void deleteResource(Long id) {
        repository.deleteById(id);
    }
}
