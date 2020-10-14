package com.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String name;
	@Column
	private boolean active;

	public Student() {
	}

	public Student(Builder builder) {

		this.id = builder.id;
		this.name = builder.name;
		this.active = builder.active;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isActive() {
		return active;
	}

	public static class Builder {

		private long id;

		private String name;

		private boolean active;

		public Builder setId(long id) {
			this.id = id;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setActive(boolean active) {
			this.active = active;
			return this;
		}

		public Student build() {
			return new Student(this);
		}

	}

}
