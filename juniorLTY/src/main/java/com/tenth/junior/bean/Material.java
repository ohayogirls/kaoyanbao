package com.tenth.junior.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Material {
    /**学习资料的实体类
     * @author Li Bo Han
     */
    //定义私有属性
    @Id
    @GeneratedValue
    private Integer MaterialID;
    private String  Category;
    private String  Type;
    private String  Link;
    private String  Title;

    //getter and setter
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Integer getMaterialID() {
        return MaterialID;
    }

    public void setMaterialID(Integer materialID) {
        MaterialID = materialID;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    //无参构造函数
    public Material() {

    }
}
