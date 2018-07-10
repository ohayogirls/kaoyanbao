package com.tenth.junior.service;

import com.tenth.junior.bean.Experience;
import com.tenth.junior.bean.Material;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ExperienceService {
    /**
     * 得到所有经验
     * @return aimlist
     */
    List<Experience> getAllExperience();

    /**
     * 添加加经验
     * @param experience
     * @return 添加的经验
     */
    Experience addExperience(Experience experience);

    /**
     * 通过id找到经验
     * @param ID
     * @return 目标经验
     */
    Optional<Experience> findByID(Integer ID);

    /**
     * 修改经验
     * @param experience
     * @return
     */
    Experience UpdateExperience(Experience experience);

    /**
     * 输出经验
     * @param experience
     */
    void deleteExperience(Experience experience);

    /**
     * 通过学校的id找到对应的经验
     * @param ID 学校id
     * @return aimlist
     */
    List<Experience> findBySchoolID(Integer ID);

    /**
     * 通过类型找到对应经验
     * @param type 经验类型
     * @return aimlist
     */
    List<Experience> findByType(String type);


}
