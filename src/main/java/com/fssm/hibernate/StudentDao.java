package com.fssm.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.fssm.hibernate.entity.Student;
import com.fssm.hibernate.util.JPAUtil;

public class StudentDao {
	
	private EntityManager getEntityManager() {
		return JPAUtil.getEntityManagerFactory().createEntityManager();
	}
	
    public int insertStudent(Student student) {
    	
        EntityManager entityManager = getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
        return student.getId();
    }

    public void findStudent(int id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, id);
        System.out.println("student id :: " + student.getId());
        System.out.println("student firstname :: " + student.getFirstName());
        System.out.println("student lastname :: " + student.getLastName());
        System.out.println("student email :: " + student.getEmail());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateStudent(Student student) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        //student = entityManager.find(Student.class, student.getId());
        System.out.println("student id :: " + student.getId());
        System.out.println("student firstname :: " + student.getFirstName());
        System.out.println("student lastname :: " + student.getLastName());
        System.out.println("student email :: " + student.getEmail());

        entityManager.merge(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeStudent(Student student) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        student = entityManager.find(Student.class, student.getId());
        System.out.println("student id :: " + student.getId());
        System.out.println("student firstname :: " + student.getFirstName());
        System.out.println("student lastname :: " + student.getLastName());
        System.out.println("student email :: " + student.getEmail());
        entityManager.remove(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
