package com.plc.spring.data.jpa.demo.dao;

import com.plc.spring.data.jpa.demo.entity.StuStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StuStudentDao extends JpaRepository<StuStudent, Long> {
    
}
