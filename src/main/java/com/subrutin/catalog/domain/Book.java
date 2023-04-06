package com.subrutin.catalog.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book extends AbstractBaseEntity {
	
	@Serial
	private static final long serialVersionUID = -493967282312085855L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "description", nullable = true, columnDefinition = "TEXT")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publisher_id", nullable = false)
	@ToString.Exclude
	private Publisher publisher;
	
	@ManyToMany
	@JoinTable(name = "book_author", joinColumns = {
			@JoinColumn(name="book_id", referencedColumnName = "id")},
	inverseJoinColumns = {
			@JoinColumn(name="author_id",referencedColumnName = "id")
	})
	@ToString.Exclude
	private List<Author> authors;
	
	@ManyToMany
	@JoinTable(name = "book_category", joinColumns = {
			@JoinColumn(name="book_id", referencedColumnName = "id")},
	inverseJoinColumns = {
			@JoinColumn(name="category_code", referencedColumnName = "code")
	})
	@ToString.Exclude
	private List<Category> categories;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Book book = (Book) o;
		return getId() != null && Objects.equals(getId(), book.getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}