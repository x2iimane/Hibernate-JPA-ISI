package com.fssm.hibernate;

import java.util.ArrayList;

import com.fssm.hibernate.entity.Ecole;
import com.fssm.hibernate.entity.Student;

public class App {

	public static void main(String[] args) {
		
		  StudentDao studentDao = new StudentDao();
		  EcoleDao ecoleDao = new EcoleDao();
		  
		  Ecole ecole = new Ecole();
		  ecole.setIntitule("FSSM");
		  ecole.setStudents(new ArrayList<>());
		  
		  Student student = new Student();
		  student.setLastName("Rafiq");
		  student.setFirstName("Imane");
		  student.setEmail("rafiq@gmail.com");
		  
		  student.setEcole(ecole);
		  
		  // Inserer une ecole
		  int ecoleId = ecoleDao.insertEcole(ecole);
		  // affecter un etudiant a une ecole
		  int studentId = studentDao.insertStudent(student);
		  System.out.println(ecoleId);
		  System.out.println(studentId);
		  
		  // updater une ecole
		  ecole.setIntitule("FSSM-ISI");
		  ecole.setId(ecoleId);
		  ecoleDao.updateEcole(ecole);
		// updater un etudiant
		  student.setLastName("RafiqUpdated");
		  student.setId(studentId);
		  studentDao.updateStudent(student);

		  // supprimer etudiant 
		  studentDao.removeStudent(student);
		  // supprimer ecole 
		  ecoleDao.removeEcole(ecole);
		  
		  
	}

}
