package com.example.thisismyproject.service.impl;

import com.example.thisismyproject.configuration.HibernateFactoryConfigurationUtil;
import com.example.thisismyproject.model.RentApartment;
import com.example.thisismyproject.service.RentApartmentsDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentApartmentsDAOImpl implements RentApartmentsDAO {
    @Autowired
    public RentApartmentsDAOImpl() {
    }

    @Override
    public long addRentApartment(RentApartment rentApartment) {
        try (Session session = HibernateFactoryConfigurationUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(rentApartment);
            transaction.commit();
            return rentApartment.getId();
        }
    }
    @Override
    public RentApartment getRentApartmentById(long id) {
        return HibernateFactoryConfigurationUtil.getSessionFactory().openSession().get(RentApartment.class, id);
    }

    @Override
    public List<RentApartment> getAllRentApartments() {
        List<RentApartment> list =
        (List<RentApartment>) HibernateFactoryConfigurationUtil.getSessionFactory().openSession().createQuery("From RentApartment").list();
        return list;
    }
    @Override
    public RentApartment editRentApartment(long id, RentApartment rentApartment) {
        try (Session session = HibernateFactoryConfigurationUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(getRentApartmentById(id));
            rentApartment.setId(id);
            session.saveOrUpdate(rentApartment);
            transaction.commit();
            return rentApartment;
        }
    }
    @Override
    public void deleteRentApartment(long id) {
        try (Session session = HibernateFactoryConfigurationUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(getRentApartmentById(id));
            transaction.commit();
        }
    }
}
