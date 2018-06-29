package com.tenth.junior.service;

import com.tenth.junior.bean.Material;
import com.tenth.junior.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MaterialServiceImpl implements  MaterialService{
    @Autowired
    private MaterialRepository materialrepository;

    @Override
    public List<Material> getAllMaterial(){
        return materialrepository.findAll();
    }
    @Override
    public Material addMaterial(Material material) {
        return materialrepository.save(material);
    }

    @Override
    public Optional<Material> findByID(Integer ID) {
        return materialrepository.findById(ID);
    }

    @Override
    public Material UpdateMaterial(Material material) {
        return materialrepository.save(material);
    }

    @Override
    public void deleteMaterial(Material material) {
        materialrepository.delete(material);
    }

    @Override
    public List<Material> getAllMat() {
        return materialrepository.findAll();
    }

    @Override
    public List<Material> queryByMaterialType(String type) {
        return materialrepository.queryByType(type);
    }


}
