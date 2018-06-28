package com.tenth.junior.service;

import com.tenth.junior.bean.Teacher;
import java.util.List;

public interface TeacherService {

    //增

    /**
     * 添加一个老师
     * @param teacher 新增老师对象
     * @return 新增的老师对象
     */
    Teacher addATeacher(Teacher teacher);

    /**
     * 添加多个老师
     * @param list 目标list
     */
    void addTeacherList(List<Teacher> list);

    //改

    /**
     * 修改一个老师的信息
     * @param teacher 新信息
     * @return 修改后的老师的信息
     */
    Teacher updateTeacher(Teacher teacher);

    //删

    /**
     * 删除一个老师
     * @param teacher 目标
     * @return 被删除的老师对象
     */
    Teacher deleteTeacher(Teacher teacher);

    /**
     * 删除多个老师，需要返回list吗？会不会占用内存？暂时不返回
     * @param list 目标
     */
    void deleteacherList(List<Teacher> list);

    /**
     * 删除所有老师信息
     */
    void deleteAllTeacher();

    //查

    /**
     * 获取所有的老师信息
     */
    List<Teacher> findAllTeacher();

    /**
     * 通过姓名查找老师
     * @param aimList 目标list
     * @param name 姓名
     * @return aimList
     */
    List<Teacher> findTeacherByName(List<Teacher> aimList,String name);

    /**
     * 查找某学校的所有老师----这个接口是不是在SchoolService里面也要有？？？
     * @param aimList 目标list
     * @param schoolName 学校名
     * @return aimList
     */
    List<Teacher> findTeacherBySchool(List<Teacher> aimList,String schoolName);

}
