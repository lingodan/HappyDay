package com.lingodan.happy.javaschool.model;

import com.lingodan.happy.javaschool.model.property.PropertyIndex;
import com.lingodan.happy.javaschool.model.util.PropertyIndexUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class BookIndexTest {

    private List<Book> bookList = new ArrayList<>();

    @BeforeEach
    void initial() {
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setName("Hello Book");
            book.setPrice(new BigDecimal(i));
            System.out.println(book);
            bookList.add(book);
        }
        for (int i = 10; i < 20; i++) {
            Book book = new Book();
            book.setName("Hello Book1");
            book.setPrice(new BigDecimal(i));
            System.out.println(book);
            bookList.add(book);
        }
        for (int i = 20; i < 30; i++) {
            MathBook book = new MathBook();
            book.setName("Math Book");
            book.setPrice(new BigDecimal(i));
            System.out.println(book);
            bookList.add(book);
        }
    }


    @Test
    void name() {
        PropertyIndex propertyIndex = PropertyIndexUtil.fetchIndex(bookList, "name");
        for (String property : propertyIndex.getAllProperties()) {
            System.out.println(property);
            System.out.println(propertyIndex.getIndexByValue(property));
        }
    }
}