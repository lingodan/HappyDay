package com.lingodan.happy.javaschool.model;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class Book {

    private String name;

    private String author;

    private BigDecimal price;

    private String publisher;

    private String publishedTime;

}
