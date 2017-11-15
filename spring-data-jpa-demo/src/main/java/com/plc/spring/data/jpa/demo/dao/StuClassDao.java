package com.plc.spring.data.jpa.demo.dao;

import com.plc.spring.data.jpa.demo.entity.StuClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StuClassDao extends JpaRepository<StuClass, Long>,JpaSpecificationExecutor {

    StuClass findById(long id);

    List<StuClass> findByNameOrAddress(String name, String address1);

    List<StuClass> findByIdBetween(long start, long end);

}
