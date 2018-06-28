package com.tenth.junior.service;


import com.tenth.junior.bean.School;
import com.tenth.junior.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService{
    @Autowired
    private SchoolRepository repository;


    //增

    @Override
    public School addASchool(School school) {
        repository.save(school);//判断是否已经存在的问题，方法内部会处理吗？
        return school;
    }

    @Override
    public void addSchoolList(List<School> list) {
        repository.saveAll(list);
    }


    //改

    @Override
    public School updateSchool(School school) {
        repository.save(school);
        return school;
    }


    //删

    @Override
    public boolean deleteSchool(School school) {
        repository.delete(school);
        return true;
    }

    @Override
    public void deleteSchoolList(List<School> list) {
        repository.deleteAll(list);
    }

    @Override
    public void deleteAllSchool() {
        repository.deleteAll();
    }


    //查

    @Override
    public List<School> findAllSchool() {
        return repository.findAll();
    }

    @Override
    public School findSchoolByName(String name) {
        List<School> list= repository.queryBySchoolName(name);
        if (list==null||list.size()==0){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<School> findSchoolByArea(List<School> aimList, String area) {
        List<School> list=new ArrayList<>();
        for (int i=0;i<aimList.size();i++){
            if (aimList.get(i).getArea().equals(area)){
                list.add(aimList.get(i));
            }
        }
        return list;
    }

    @Override
    public List<School> findSchoolByProvince(List<School> aimList, String province) {
        List<School> list=new ArrayList<>();
        for (int i=0;i<aimList.size();i++){
            if (aimList.get(i).getProvince().equals(province)){
                list.add(aimList.get(i));
            }
        }
        return list;
    }

    @Override
    public List<School> findSchoolBy985(List<School> aimList,Boolean is985) {
        List<School> list=new ArrayList<>();
        for (int i=0;i<aimList.size();i++){
            if (aimList.get(i).getIs985().equals(is985)){
                list.add(aimList.get(i));
            }
        }
        return list;
    }

    @Override
    public List<School> findSchoolBy211(List<School> aimList,Boolean is211) {
        List<School> list=new ArrayList<>();
        for (int i=0;i<aimList.size();i++){
            if (aimList.get(i).getIs211().equals(is211)){
                list.add(aimList.get(i));
            }
        }
        return list;
    }

    @Override
    public List<School> findSchool(List<School> aimList, String area, String province, Boolean is985, Boolean is211) {
        List<School> list=findSchoolByArea(aimList,area);
        list=findSchoolByProvince(list,province);
        list=findSchoolBy985(list,is985);
        list=findSchoolBy211(list,is211);
        return list;
    }
}
