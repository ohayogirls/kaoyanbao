package com.tenth.junior.service;

import com.tenth.junior.bean.Material;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface MaterialService {
    List<Material> getAllMaterial();

    Material addMaterial(Material material);

    Optional<Material> findByID(Integer ID);

    Material UpdateMaterial(Material material);

    void deleteMaterial(Material material);

    List<Material> getAllMat();

    List<Material> queryByMaterialType(String type);

}
