package com.subrutin.catalog.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "category")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
	
	@Serial
	private static final long serialVersionUID = -7125859384844185149L;

	@Id
	@Column(name = "code", nullable = false)
	private String code;
	
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description")
	private String description;
	
	@ManyToMany(mappedBy = "categories")
	@ToString.Exclude
	private List<Book> books;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Category category = (Category) o;
		return getCode() != null && Objects.equals(getCode(), category.getCode());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}