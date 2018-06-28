package com.tenth.junior.service;

import com.tenth.junior.bean.Teacher;
import com.tenth.junior.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository repository;

    @Autowired
    private SchoolServiceImpl schoolService;


    //增

    @Override
    public Teacher addATeacher(Teacher teacher) {
        repository.save(teacher);
        return teacher;
        // TODO: 2018/6/27 这里应该查找teacher之后再返回，因为参数中的teacher是没有主键信息的
    }

    @Override
    public void addTeacherList(List<Teacher> list) {
        repository.saveAll(list);
    }


    //改

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        repository.save(teacher);
        return teacher;
        // TODO: 2018/6/27 这里应该查找teacher之后再返回，因为参数中的teacher是没有主键信息的
    }


    //删

    @Override
    public Teacher deleteTeacher(Teacher teacher) {
        // TODO: 2018/6/27 这里应该查找teacher之后暂存这个对象，删除之后返回这个对象
        repository.delete(teacher);
        return teacher;
    }

    @Override
    public void deleteacherList(List<Teacher> list) {
        repository.deleteAll(list);
    }

    @Override
    public void deleteAllTeacher() {
        repository.deleteAll();
    }

    @Override
    public void deleteTeacherByID(Integer id) {
        repository.deleteById(id);
    }

    //查

    @Override
    public List<Teacher> findAllTeacher() {
        return repository.findAll();
    }

    @Override
    public List<Teacher> findTeacherByName(List<Teacher> aimList, String name) {
        List<Teacher> list=new ArrayList<>();
        for (int i=0;i<aimList.size();i++){
            if (aimList.get(i).getName().equals(name)){
                list.add(aimList.get(i));
            }
        }
        return list;
    }

    @Override
    public List<Teacher> findTeacherBySchool(List<Teacher> aimList, String schoolName) {
        List<Teacher> list=new ArrayList<>();
        //通过schoolName获取schoolID
        Integer schoolID=schoolService.findSchoolByName(schoolName).getSchoolID();
        for (int i=0;i<aimList.size();i++){
            if (aimList.get(i).getSchoolID()==schoolID){
                list.add(aimList.get(i));
            }
        }
        return list;
    }
}
