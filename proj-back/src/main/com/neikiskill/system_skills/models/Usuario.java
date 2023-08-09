package com.neikiskill.system_skills.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Usuario implements java.io.Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_sequence")
    @SequenceGenerator(name = "usuario_id_sequence", sequenceName = "usuario_seq", allocationSize = 1)
    @Column(name = "usuario_id", updatable = false)
	private int usuarioId;
	
	private String username;
	
	@JsonIgnore
	private String password;

	@OneToMany(mappedBy = "usuario", fetch=FetchType.EAGER)
	private List<UsuarioSkill> usuarioSkills = new ArrayList<>();

	public Usuario() {
	}

	public Usuario(int usuarioId, String username, String password, List<UsuarioSkill> usuarioSkills) {
		this.usuarioId = usuarioId;
		this.username = username;
		this.password = password;
		this.usuarioSkills = usuarioSkills;
	}

	public int getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UsuarioSkill> getUsuarioSkills() {
		return this.usuarioSkills;
	}

	public void setUsuarioSkills(List<UsuarioSkill> usuarioSkills) {
		this.usuarioSkills = usuarioSkills;
	}

}
