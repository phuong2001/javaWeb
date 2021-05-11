package com.demo.dao;

import com.demo.entity.PhoneEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PhoneDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();

    public List<PhoneEntity> getAllPhone() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<PhoneEntity> list = em.createQuery("select c from PhoneEntity c", PhoneEntity.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }
    public void insertPhone(PhoneEntity phoneEntity) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(phoneEntity);
        em.getTransaction().commit();
        em.close();
    }
    public void updatePhone(PhoneEntity phoneEntity) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        PhoneEntity c = em.find(PhoneEntity.class, phoneEntity.getId());
        if (c != null) {
            c.setName(phoneEntity.getName());
            c.setBrand(phoneEntity.getBrand());
            c.setPrice(phoneEntity.getPrice());
            c.setDescription(phoneEntity.getDescription());
            em.getTransaction().commit();
        }
        em.close();
    }

    public void deletePhone(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        PhoneEntity c = em.find(PhoneEntity.class, id);
        if (c != null) {
            em.remove(c);
            em.getTransaction().commit();
        }
        em.close();
    }
}
