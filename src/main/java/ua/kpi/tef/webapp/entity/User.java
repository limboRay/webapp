package ua.kpi.tef.webapp.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table( name="user",
		uniqueConstraints={@UniqueConstraint(columnNames={"login", "email"})})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private Long id;
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "first_name_cyr", nullable = false)
	private String firstNameCyr;
	@Column(name = "last_name", nullable = false)
	private String lastName;
	@Column(name = "last_name_cyr", nullable = false)
	private String lastNameCyr;
	@Column(nullable = false)
	private String login;
	@Column(nullable = false)
	private String email;
	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private RoleType role;
}

