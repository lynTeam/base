package com.xingkong.lyn.model.web;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by lyn on 2017/6/13.
 */
@Entity
@Data
@Table(name = "web_catagory")
public class Catagory implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private Long parentId;

    private String name;

    private Date createTime;

    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)//级联保存、更新、删除、刷新;延迟加载
    @JoinColumn(name = "catagoryId")
    private List<Product> products;

    @OneToMany(cascade=CascadeType.ALL)
    @MapKey(name = "pk")
    private List<Catagory> subCatagories;
}
