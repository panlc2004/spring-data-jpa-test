package com.plc.springjpa.test.repository;

import com.plc.springjpa.test.entity.AuthUser;
import com.plc.springjpa.test.util.SqlGenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by 003914[panlc] on 2017-08-04.
 */

@Repository
public interface UserRepository extends JpaRepository<AuthUser, Long> {

//    AuthUser findByName(String name);

//    AuthUser findByNameAndAge(String name, Integer age);

//    @Query("from AuthUser u where u.name=:name")
//    AuthUser findUser(@Param("name") String name);

    Page<AuthUser> findAll(Pageable pageable);

    AuthUser findFirstByOrderByIdDesc();

    List<AuthUser> findByAgeGreaterThanEqual(int age);

    List<AuthUser> findByUserFirstName(String userFirstName);

    @Query(value = SqlGenUtil.sql, nativeQuery = true)
    List<AuthUser> findAllUser();

}
