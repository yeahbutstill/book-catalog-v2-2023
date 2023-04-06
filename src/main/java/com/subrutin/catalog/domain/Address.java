package com.subrutin.catalog.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "address")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

	@Serial
	private static final long serialVersionUID = 7035215162449455935L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "street_name", nullable = false)
	private String streetName;
	
	@Column(name = "city_name", nullable = false)
	private String cityName;
	
	@Column(name = "zipcode", nullable = false)
	private String zipCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id", nullable = false)
	@ToString.Exclude
	private Author author;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Address address = (Address) o;
		return getId() != null && Objects.equals(getId(), address.getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
