package com.cyp.pojo;

import lombok.Data;

import java.util.Date;


@Data
public class Blog {

    private String id;
    private String title;
    private String author;
    private Date CreateTime;
    private int views;

}
