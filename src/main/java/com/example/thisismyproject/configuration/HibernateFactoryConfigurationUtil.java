package com.example.thisismyproject.configuration;

import com.example.thisismyproject.model.Apartment;
import com.example.thisismyproject.model.RentApartment;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateFactoryConfigurationUtil { //Hibernate service
    private static SessionFactory sessionFactory;
    public HibernateFactoryConfigurationUtil() {
    }
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Apartment.class);
                configuration.addAnnotatedClass(RentApartment.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Исключение!");
            }
        }
        return sessionFactory;
    }
}
