package com.tenth.junior.service;

import com.tenth.junior.bean.Teacher;
import com.tenth.junior.bean.YearlyData;
import com.tenth.junior.bean.YearlyDataPK;
import com.tenth.junior.repository.YearlyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        List<YearlyData> list=new ArrayList<>();
        List<YearlyData> aimList=new ArrayList<>(yearlyDataRepository.findAll());
       if(aimList!=null){
           for (int i=0;i<aimList.size();i++){
               if (aimList.get(i).getSchoolID().equals(id)){
                   list.add(aimList.get(i));
               }
           }
       }
        Collections.sort(list, new Comparator<YearlyData>() {
            @Override
            public int compare(YearlyData t1, YearlyData t2) {
                    int i = t2.getYear() - t1.getYear();
                    return i;
            }
        });
       return list;
    }

}

































