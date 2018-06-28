package com.tenth.junior.service;

import com.tenth.junior.bean.School;

import java.util.List;
import java.util.Optional;

public interface SchoolService {
    //增

    /**
     * 向数据库中新增一个学校的信息，两种方式
     * @return 返回新增的学校对象
     */
    School addASchool(School school);
    /*School addASchool(String name, String area, String province, String outline, Date cutTime,
                     String catalogLink,String referrenceBook,Boolean is985,Boolean is211);*/

    /**
     * 添加多个School
     * @param list 目标list
     */
    void addSchoolList(List<School> list);

    //改

    /**
     * 修改学校信息
     * @param school 修改后的信息
     * @return 修改后的学校对象
     */
    School updateSchool(School school);

    //删

    /**
     * 删除一个学校的信息
     * @param school 学校
     * @return 成功返回true
     */
    boolean deleteSchool(School school);

    /**
     * 删除多个学校
     * @param list 目标list
     */
    void deleteSchoolList(List<School> list);

    /**
     * 删除所有学校信息
     */
    void deleteAllSchool();

    //查

    /**
     * 获取所有的学校信息
     */
    List<School> findAllSchool();

    /**
     * 通过学校名字查询学校
     * @param name 名字
     * @return 对象
     */
    School findSchoolByName(String name);

    /**
     * 查询aimList中属于area地区的学校
     * @param aimList 要查询的学校列表
     * @param area 地区
     * @return 筛选后的学校列表
     */
    List<School> findSchoolByArea(List<School> aimList,String area);

    /**
     * 查询aimList中属于province省份的学校
     * @param aimList 要查询的学校列表
     * @param province 省份
     * @return 筛选后的学校列表
     */
    List<School> findSchoolByProvince(List<School> aimList,String province);

    /**
     * 查询aimList中属于985的学校
     * @param aimList 要查询的学校列表
     * @return 筛选后的学校列表
     */
    List<School> findSchoolBy985(List<School> aimList,Boolean is985);

    /**
     * 查询aimList中属于211的学校
     * @param aimList 要查询的学校列表
     * @return 筛选后的学校列表
     */
    List<School> findSchoolBy211(List<School> aimList,Boolean is211);

    /**
     * 通过四个限制条件从aimlist中筛选学校
     * @param aimList 目标list，为null表示从数据库中所有学校中查询
     * @param area 地区
     * @param province 省份
     * @param is985 是不是985
     * @param is211 是不是211
     * @return 查询到的学校列表
     */
    List<School> findSchool(List<School> aimList, String area, String province, Boolean is985, Boolean is211);

    Optional<School> GetSchoolByID(Integer ID);
}
