package com.neikiskill.system_skills.models;
// Generated Aug 7, 2023, 5:15:34 PM by Hibernate Tools 6.2.5.Final


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Nivel implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nivel_id_sequence")
	@SequenceGenerator(name = "nivel_id_sequence", sequenceName = "usuario_seq", allocationSize = 1)
	private int nivelId;
	
	@Column(name="name_nivel")
	private String nameNivel;

	public Nivel() {
	}

	public Nivel(int nivelId, String nameNivel) {
		this.nivelId = nivelId;
		this.nameNivel = nameNivel;
	}

	public int getNivelId() {
		return this.nivelId;
	}

	public void setNivelId(int nivelId) {
		this.nivelId = nivelId;
	}

	public String getNameNivel() {
		return this.nameNivel;
	}

	public void setNameNivel(String nameNivel) {
		this.nameNivel = nameNivel;
	}
}
