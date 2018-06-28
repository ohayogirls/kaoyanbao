package com.tenth.junior.service;

import com.tenth.junior.bean.YearlyData;
import com.tenth.junior.bean.YearlyDataPK;

import java.util.List;
import java.util.Optional;

public interface YearlyDataService {
    List<YearlyData> findAllYearlyData();
    YearlyData addYearlyData(YearlyData yearlyData);
    YearlyData updateYearlyData(YearlyData yearlyData);
    Optional<YearlyData> findByID(YearlyDataPK pk);
    void deleteYearlyData(YearlyDataPK pk);
    List<YearlyData> findBySchoolID(Integer id);
}
