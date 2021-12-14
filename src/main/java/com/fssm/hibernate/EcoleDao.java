package com.fssm.hibernate;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.fssm.hibernate.entity.Ecole;
import com.fssm.hibernate.entity.Student;
import com.fssm.hibernate.util.JPAUtil;

public class EcoleDao {
	//classe generique
	private StudentDao studentDao = new StudentDao();
	
	private EntityManager getEntityManager() {
		return JPAUtil.getEntityManagerFactory().createEntityManager();
	}
	
    public int insertEcole(Ecole ecole) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(ecole);
        entityManager.getTransaction().commit();
        entityManager.close();
        return ecole.getId();
    }

    public void findEcole(int id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Ecole ecole = entityManager.find(Ecole.class, id);
        System.out.println("ecole id :: " + ecole.getId());
        System.out.println("ecole  :: " + ecole.getIntitule());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateEcole(Ecole ecole) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        System.out.println("ecole id :: " + ecole.getId());
        System.out.println("ecole  :: " + ecole.getIntitule());

        entityManager.merge(ecole);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeEcole(Ecole ecole) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        ecole = entityManager.find(Ecole.class, ecole.getId());
        ecole.getStudents().forEach(student -> {
        	studentDao.removeStudent(student);
        });
        entityManager.remove(ecole);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
