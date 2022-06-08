package com.idat.microservicioidat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "Profesor")
@Entity
public class Profesor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProfesor;
	private String profesor;
	
	@ManyToMany
	@JoinTable(name="profesor_curso", joinColumns = 
			@JoinColumn(name="id_profesor", nullable = false, unique = true, 
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_profesor) references Profesor(id_profesor")
			),
			inverseJoinColumns = @JoinColumn(name="id_curso", nullable = false, unique = true, 
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_curso) references Profesor(id_curso")
			)	
	)
	private List<Curso> curso = new ArrayList<>();
	

	
	public Integer getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	public List<Curso> getCurso() {
		return curso;
	}
	public void setCurso(List<Curso> curso) {
		this.curso = curso;
	}


	
}
