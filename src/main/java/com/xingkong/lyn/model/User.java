package com.xingkong.lyn.model;

import lombok.Data;

import java.io.Serializable;


@Data
public class User implements Serializable{
    private static final long serialVersionUID = -7234373561336246605L;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbggenerated Tue Apr 25 14:32:44 CST 2017
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.name
     *
     * @mbggenerated Tue Apr 25 14:32:44 CST 2017
     */
    private String name;
}