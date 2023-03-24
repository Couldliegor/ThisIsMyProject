package com.example.thisismyproject.service.impl;

import com.example.thisismyproject.configuration.HibernateFactoryConfigurationUtil;
import com.example.thisismyproject.model.Apartment;
import com.example.thisismyproject.service.ApartmentsDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentsDAOImpl implements ApartmentsDAO {

    @Autowired
    public ApartmentsDAOImpl() {
    }

    @Override
    public long addApartment(Apartment apartment) {
        try (Session session = HibernateFactoryConfigurationUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(apartment);
            transaction.commit();
            return 2;
        }
    }
    @Override
    public Apartment getApartmentById(long id) {
        return HibernateFactoryConfigurationUtil.getSessionFactory().openSession().get(Apartment.class, id);
    }

    @Override
    public List<Apartment> getAllApartments() {
        List<Apartment> list = (List<Apartment>)HibernateFactoryConfigurationUtil.getSessionFactory().openSession().createQuery("From Apartment").list();
        return list;
    }

    @Override
    public Apartment editApartment(long id, Apartment apartment) {
        try (Session session = HibernateFactoryConfigurationUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(getApartmentById(id));
            apartment.setId(id);
            session.saveOrUpdate(apartment);
            return apartment;
        }
    }



    @Override
    public void deleteApartment(long id) {
        try (Session session = HibernateFactoryConfigurationUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(getApartmentById(id));
            transaction.commit();
        }
    }
}
