package com.kun.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import static org.hibernate.cfg.Environment.*;

import java.util.Properties;

public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean localBean = new LocalSessionFactoryBean();

        Properties properties = new Properties();

        //JDBC properties
        properties.put(DRIVER,environment.getProperty("jdbc.driver"));
        properties.put(URL, environment.getProperty("jdbc.url"));
        properties.put(USER, environment.getProperty("jdbc.username"));
        properties.put(PASS, environment.getProperty("jdbc.password"));

        //Hibernate Properties
        properties.put( DIALECT, environment.getProperty("hibernate.dialect"));
        properties.put( SHOW_SQL, environment.getProperty("hibernate.show_sql"));
        properties.put( FORMAT_SQL, environment.getProperty("hibernate.format_sql"));
        properties.put(HBM2DDL_AUTO, environment.getProperty("hibernate.hbm2ddl.auto"));
        properties.put(ENABLE_LAZY_LOAD_NO_TRANS, environment.getProperty("hibernate.enabled"));

        localBean.setHibernateProperties(properties);
        localBean.setPackagesToScan("com.kun");
        return localBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
}
