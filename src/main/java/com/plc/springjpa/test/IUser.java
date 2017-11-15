package com.plc.springjpa.test;

import com.plc.springjpa.base.BaseRepository;
import com.plc.springjpa.test.entity.AuthUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IUser extends BaseRepository<AuthUser, Long> {
    List<AuthUser> findAll();
    @Query("select age from AuthUser where createdDt > :#{#authUser.createdDt}")
    List<AuthUser> findAll2(@Param("authUser") AuthUser authUser);
}
