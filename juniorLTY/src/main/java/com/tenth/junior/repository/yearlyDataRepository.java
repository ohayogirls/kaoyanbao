package com.tenth.junior.repository;

import com.tenth.junior.bean.YearlyData;
import com.tenth.junior.bean.YearlyDataPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface yearlyDataRepository extends JpaRepository<YearlyData,YearlyDataPK>{
}
