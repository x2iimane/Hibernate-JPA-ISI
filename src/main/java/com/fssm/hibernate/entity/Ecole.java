package com.fssm.hibernate.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ecole")
public class Ecole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEcole")
	private int idEcole;

	@Column(name = "intitule")
	private String intitule;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ecole")
	private List<Student> students;

	public int getId() {
		return idEcole;
	}

	public void setId(int id) {
		this.idEcole = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Ecole [id=" + idEcole + ", intitule=" + intitule + ", students=" + students + "]";
	}
	
	

}
