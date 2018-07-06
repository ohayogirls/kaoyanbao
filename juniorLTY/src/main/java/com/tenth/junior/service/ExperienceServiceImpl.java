package com.tenth.junior.service;


import com.tenth.junior.bean.Experience;
import com.tenth.junior.repository.ExperienceRepository;
import com.tenth.junior.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExperienceServiceImpl implements  ExperienceService{

    @Autowired
    private ExperienceRepository experiencerepository;

    @Override
    public List<Experience> getAllExperience() {
        return experiencerepository.findAll();
    }

    @Override
    public Experience addExperience(Experience experience) {
        return experiencerepository.save(experience);
    }

    @Override
    public Optional<Experience> findByID(Integer ID) {
        return experiencerepository.findById(ID);
    }

    @Override
    public Experience UpdateExperience(Experience experience) {
        return experiencerepository.save(experience);
    }

    @Override
    public void deleteExperience(Experience experience) {
        experiencerepository.delete(experience);
    }

    @Override
    public List<Experience> getAllExp() {
        return null;
    }

    @Override
    public List<Experience> queryByExperienceType(String type) {
        return experiencerepository.queryByType(type);
    }

    @Override
    public List<Experience> findBySchoolID(Integer ID) {
        List<Experience> list=new ArrayList<>();
        List<Experience> aimList=new ArrayList<>(experiencerepository.findAll());
        for (int i=0;i<aimList.size();i++){
            if (aimList.get(i).getSchoolID().equals(ID)){
                list.add(aimList.get(i));
            }
        }
        return list;
    }

    @Override
    public List<Experience> findByType(String type) {
        List<Experience> list=new ArrayList<>();
        List<Experience> aimList=new ArrayList<>(experiencerepository.findAll());
        for (int i=0;i<aimList.size();i++){
            if (aimList.get(i).getType().equals(type)){
                list.add(aimList.get(i));
            }
        }
        return list;
    }
}
