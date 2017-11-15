package com.plc.spring.data.jpa.demo.dao;

import com.plc.spring.data.jpa.demo.DemoApplication;
import com.plc.spring.data.jpa.demo.entity.StuClass;
import com.plc.spring.data.jpa.demo.entity.StuStudent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.*;
import java.util.List;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class StuClassDaoTest {

    @Autowired
    private StuClassDao stuClassDao;

    @Test
    public void testInsert() {
        StuClass stuClass = new StuClass();
        stuClass.setAddress("address1");
        stuClass.setCode("code1");
        stuClass.setMemo("memo1");
        stuClass.setName("name1");
        StuClass save = stuClassDao.save(stuClass);
        Assert.assertNotNull(save.getId());
    }

    @Test
    public void testFind() {
        List<StuClass> all = stuClassDao.findAll();
        StuClass byId = stuClassDao.findById(1);
        List<StuClass> byNameOrAddress = stuClassDao.findByNameOrAddress("1","2");
        List<StuClass> byIdBetween = stuClassDao.findByIdBetween(2, 2);
        System.out.println(all);
        System.out.println(byId);
        System.out.println(byNameOrAddress);
        System.out.println(byIdBetween);
    }

    @Test
    public void testComplexFind() {
        Page<StuClass> all = stuClassDao.findAll(new Specification<StuClass>() {
            @Override
            public Predicate toPredicate(Root<StuClass> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//                Join<StuClass, StuStudent> companyJoin = root.join("id", JoinType.LEFT);
//                Predicate id = cb.equal(companyJoin.get("classId"), 1);
//                query.where(id);
                return cb.and(cb.lessThan(root.<Long>get("id"), 2L));
            }
        }, new PageRequest(0, 10, new Sort(Sort.Direction.DESC, "id")));
        System.out.println(all);
    }
}