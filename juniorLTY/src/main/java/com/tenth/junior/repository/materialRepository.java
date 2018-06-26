package com.tenth.junior.repository;

import com.tenth.junior.bean.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface materialRepository extends JpaRepository<Material,Integer> {
}
