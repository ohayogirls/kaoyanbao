package com.tenth.junior.service;

import com.tenth.junior.bean.YearlyData;
import com.tenth.junior.bean.YearlyDataPK;
import com.tenth.junior.repository.YearlyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class YearlyDataServiceImpl implements YearlyDataService{
    @Autowired
    private YearlyDataRepository yearlyDataRepository;

    @Override
    public List<YearlyData> findAllYearlyData() {
        return yearlyDataRepository.findAll();
    }

    @Override
    public YearlyData addYearlyData(YearlyData yearlyData) {
        return yearlyDataRepository.save(yearlyData);
    }

    @Override
    public YearlyData updateYearlyData(YearlyData yearlyData) {
        return yearlyDataRepository.save(yearlyData);
    }

    @Override
    public Optional<YearlyData> findByID(YearlyDataPK pk) {
        return yearlyDataRepository.findById(pk);
    }

    @Override
    public void deleteYearlyData(YearlyDataPK pk) {
        yearlyDataRepository.deleteById(pk);
    }

    @Override
    public List<YearlyData> findBySchoolID(Integer id){
        return null;//yearlyDataRepository.queryBySchoolID(id);
    }

}
