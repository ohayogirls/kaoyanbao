package com.tenth.junior.repository;


import com.tenth.junior.bean.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material,Integer> {
    @Query("select a from Material a where a.Type like ?1")
    List<Material> queryByType(String type);


}
