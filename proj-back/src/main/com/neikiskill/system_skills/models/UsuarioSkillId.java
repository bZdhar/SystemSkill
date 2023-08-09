package com.neikiskill.system_skills.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Embeddable
public class UsuarioSkillId implements java.io.Serializable {

	
	@Column(name = "skill_id")
	private int skillId;
	@Column(name = "usuario_id")
	private int usuarioId;

	public UsuarioSkillId() {
	}

	public UsuarioSkillId(int skillId, int usuarioId) {
		this.skillId = skillId;
		this.usuarioId = usuarioId;
	}

	public int getSkillId() {
		return this.skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public int getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UsuarioSkillId))
			return false;
		UsuarioSkillId castOther = (UsuarioSkillId) other;

		return (this.getSkillId() == castOther.getSkillId()) && (this.getUsuarioId() == castOther.getUsuarioId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getSkillId();
		result = 37 * result + this.getUsuarioId();
		return result;
	}

}
