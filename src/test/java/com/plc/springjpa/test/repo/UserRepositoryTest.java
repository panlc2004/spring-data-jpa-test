package com.plc.springjpa.test.repo;

import com.plc.springjpa.App;
import com.plc.springjpa.test.IUser;
import com.plc.springjpa.test.entity.AuthUser;
import com.plc.springjpa.test.repository.BaseRepository;
import com.plc.springjpa.test.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by 003914[panlc] on 2017-08-04.
 */
@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IUser iUser;

//    @org.junit.Test
//    public void findByName() throws Exception {
//        AuthUser test = userRepository.findByName("AAA");
//        System.out.println(test);
//    }
//
//    @org.junit.Test
//    public void findByNameAndAge() throws Exception {
//        AuthUser test = userRepository.findByNameAndAge("AAA", 12);
//        System.out.println(test);
//
//    }
//
//    @org.junit.Test
//    public void findUser() throws Exception {
//        AuthUser test = userRepository.findUser("AAA");
//        System.out.println(test);
//    }

    @Test
    public void testSave() {
        AuthUser aaa = new AuthUser();
        aaa.setAge(7);
        aaa.setUserFirstName("AAA");
        userRepository.save(aaa);
    }

    @Test
    public void testFindByPage() {
        Sort sort = new Sort(Sort.Direction.DESC, "id").and(new Sort(Sort.Direction.ASC,"age"));
        Pageable p = new PageRequest(0, 10, sort);
        Page<AuthUser> page = userRepository.findAll(p);
        System.out.println(page);
        List<AuthUser> content = page.getContent();
        System.out.println(content);
    }

    @Test
    public void findFirstByOrderByIdAsc() {
        AuthUser page = userRepository.findFirstByOrderByIdDesc();
        System.out.println(page);
    }
//
//    @Test
//    public void findByAgeGreaterThanEqual() {
//        List<AuthUser> byAgeGreaterThanEqual = userRepository.findByAgeGreaterThanEqual(11);
//        System.out.println(byAgeGreaterThanEqual);
//    }

//    @Test
//    public void findByNameEndingWith() {
//        List<AuthUser> byAgeGreaterThanEqual = userRepository.findByUserFirstName("B");
//        System.out.println(byAgeGreaterThanEqual);
//    }


    @Autowired
    private BaseRepository baseRepository;

    @Test
    public void testComplexQuery() {
        Specification spe = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.select(root.get("userFirstName"));
                List<Predicate> predicates = new ArrayList<Predicate>();
//                predicates.add(criteriaBuilder.greaterThan(root.get("createdDt"), new Date()));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        List all = baseRepository.findAll(spe);
        System.out.println(all);
    }


    @Test
    public void testQuery2() {
        List<AuthUser> allUser = userRepository.findAllUser();
        System.out.println(allUser);
    }

    @Test
    public void testQuery3() {
        List<AuthUser> allUser = iUser.findAll();
        System.out.println(allUser);
    }

    @Test
    public void testQuery4() {
        List<AuthUser> allUser = iUser.listBySQL("select * from auth_user");
        System.out.println(allUser);
    }

    @Test
    public void testQuery5() {
        AuthUser authUser = new AuthUser();
        authUser.setCreatedDt(new Date());
        List<AuthUser> allUser = iUser.findAll2(authUser);
        System.out.println(allUser);
    }
}