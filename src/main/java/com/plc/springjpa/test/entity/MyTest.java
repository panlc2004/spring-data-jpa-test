package com.plc.springjpa.test.entity;

import com.plc.springjpa.test.util.SqlGenUtil;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by 003914[panlc] on 2017-08-04.
 */
public class MyTest {

    final String a = "";

    private String name;

    public MyTest(String name) {
        this.name = name;
    }

    @Query(a)
    public String getName() {
        return name;
    }
}
