package com.example.thisismyproject.configuration;

import com.example.thisismyproject.model.Apartment;
import com.example.thisismyproject.model.RentApartment;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateFactoryConfigurationUtil {
    private static SessionFactory sessionFactory;
    private static SessionFactory sessionRentFactory;
    public HibernateFactoryConfigurationUtil() {
    }
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Apartment.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Исключение!");
            }
        }
        return sessionFactory;
    }
    public static SessionFactory getRentSessionFactory() {
        if (sessionRentFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(RentApartment.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionRentFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Исключение!");
            }
        }
        return sessionRentFactory;
    }
}
