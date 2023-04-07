package com.subrutin.catalog.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "publisher")
public class Publisher extends AbstractBaseEntity {

	@Serial
	private static final long serialVersionUID = -3729325249054365078L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_generator")
	@SequenceGenerator(name = "publisher_generator", sequenceName = "publisher_id_seq", allocationSize = 1, initialValue = 1)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "company_name", nullable=false)
	private String companyName;
	
	@Column(name = "address")
	private String address;
	
	@OneToMany(mappedBy = "publisher")
	@ToString.Exclude
	private List<Book> books;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Publisher publisher = (Publisher) o;
		return getId() != null && Objects.equals(getId(), publisher.getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
