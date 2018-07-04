package com.tenth.junior.service;

import com.tenth.junior.bean.Material;
import com.tenth.junior.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<Material> findByCategory(List<Material> aimList, String category) {
        List<Material> list = new ArrayList<>();
        for (int i=0;i<aimList.size();i++){
            if (aimList.get(i).getCategory().equals(category)){
                list.add(aimList.get(i));
            }
        }
        return list;
    }

    @Override
    public List<Material> findByType(List<Material> aimList, String type) {
        List<Material> list = new ArrayList<>();
        for (int i=0;i<aimList.size();i++){
            if (aimList.get(i).getType().equals(type)){
                list.add(aimList.get(i));
            }
        }
        return list;
    }
}
