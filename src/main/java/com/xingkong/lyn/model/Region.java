package com.xingkong.lyn.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by lyn on 2017/5/26.
 */
@Entity
@Data
@Table(name = "sys_region")
public class Region implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String code;

    private String name;
}
