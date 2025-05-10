package com.ay.services;

import com.ay.entity.ResourceMaterial;

import java.util.List;

public interface ResourceMaterialService {
    ResourceMaterial addResource(ResourceMaterial material);
    List<ResourceMaterial> getAllResources();
    void deleteResource(Long id);
}
