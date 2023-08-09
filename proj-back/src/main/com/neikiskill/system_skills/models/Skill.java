package com.neikiskill.system_skills.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Skill implements java.io.Serializable {

	@Id
    @SequenceGenerator(name = "skill_seq", sequenceName = "skill_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill_seq")
    @Column(name = "skill_id", updatable = false)
	private int skillId;

	@Column(name = "name_skill")
	private String nameSkill;

	public Skill() {
	}

	public Skill(int skillId, String nameSkill) {
		this.skillId = skillId;
		this.nameSkill = nameSkill;
	}

	public int getSkillId() {
		return this.skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getNameSkill() {
		return this.nameSkill;
	}

	public void setNameSkill(String nameSkill) {
		this.nameSkill = nameSkill;
	}
}
