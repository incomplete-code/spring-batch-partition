package de.incompleteco.spring.batch.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="base_entity")
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private int baseValue;
	
	@Column
	private Double endValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBaseValue() {
		return baseValue;
	}

	public void setBaseValue(int baseValue) {
		this.baseValue = baseValue;
	}

	public Double getEndValue() {
		return endValue;
	}

	public void setEndValue(Double endValue) {
		this.endValue = endValue;
	}

	@Transient
	public String toString() {
		return "BaseEntity [id=" + id + ", baseValue=" + baseValue
				+ ", endValue=" + endValue + "]";
	}
	
	
	
}
