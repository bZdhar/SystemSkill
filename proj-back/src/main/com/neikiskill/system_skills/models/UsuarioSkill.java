package com.neikiskill.system_skills.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class UsuarioSkill implements java.io.Serializable {

	@EmbeddedId
	@JsonIgnore
	private UsuarioSkillId id;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	@JsonBackReference
	@MapsId("usuarioId")
	private Usuario usuario;

	@OneToOne
	@JoinColumn(name = "nivel_id")
	// @MapsId("nivelId")
	private Nivel nivel;

	@OneToOne
	@JoinColumn(name = "skill_id")
	
	@MapsId("skillId")
	private Skill skill;

	public UsuarioSkill() {
	}

	public UsuarioSkill(UsuarioSkillId id, Nivel nivel, Usuario usuario, Skill skill) {
		this.id = id;
		this.nivel = nivel;
		this.usuario = usuario;
		this.skill = skill;
	}

	public UsuarioSkillId getId() {
		return this.id;
	}

	public void setId(UsuarioSkillId id) {
		this.id = id;
	}

	public Nivel getNivel() {
		return this.nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Skill getSkill() {
		return this.skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}
