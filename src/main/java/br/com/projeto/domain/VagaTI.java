package br.com.projeto.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VagaTI {
	
	@Id 
	private Integer id;
	private String cargo;
	private String requisitos;
	private String salario;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	
	

}
