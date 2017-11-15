package com.plc.springjpa;

import com.plc.springjpa.base.BaseRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by 003914[panlc] on 2017-08-04.
 */
@EnableJpaRepositories(
        basePackages = {"com.plc.springjpa.test"},
        repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class//指定自己的工厂类
)
@SpringBootApplication
//@ComponentScan(basePackages = {""})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
