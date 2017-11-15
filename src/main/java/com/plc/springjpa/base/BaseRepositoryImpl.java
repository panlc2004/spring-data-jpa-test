package com.plc.springjpa.base;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class BaseRepositoryImpl <T, ID extends Serializable> extends SimpleJpaRepository<T,ID>
        implements BaseRepository<T,ID> {

    private final EntityManager entityManager;

    private final Class<T> domainClass;

    //父类没有不带参数的构造方法，这里手动构造父类
    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
        this.domainClass = domainClass;
    }

    //通过EntityManager来完成查询
    @Override
    public List listBySQL(String sql) {
        return entityManager.createNativeQuery(sql).getResultList();
    }

    //通过EntityManager来完成查询
    @Override
    public List list2BySQL(String hql) {
        return entityManager.createQuery(hql).getResultList();
    }

}