package com.plc.springjpa.test.repository;

import com.plc.springjpa.test.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 003914[panlc] on 2017-08-04.
 */
public interface BaseRepository extends CrudRepository<AuthUser, Long>, JpaSpecificationExecutor {


}
