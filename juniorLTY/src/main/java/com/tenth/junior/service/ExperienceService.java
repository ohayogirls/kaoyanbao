package com.tenth.junior.service;

import com.tenth.junior.bean.Experience;
import com.tenth.junior.bean.Material;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ExperienceService {
    List<Experience> getAllExperience();

    Experience addExperience(Experience experience);

    Optional<Experience> findByID(Integer ID);

    Experience UpdateExperience(Experience experience);

    void deleteExperience(Experience experience);
    List<Experience> findBySchoolID(Integer ID);
    List<Experience> findByType(String type);

    List<Experience> getAllExp();

    List<Experience> queryByExperienceType(String type);

}
