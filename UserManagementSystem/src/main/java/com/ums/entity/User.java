package com.ums.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.ums.enums.UserStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 30)
	@NotBlank(message = "User name must not be blank")
	private String name;

	@Column(length = 30)
	@NotBlank(message = "Email must not be blank")
	private String email;

	@NotNull(message = "Customer mobile must not be null")
	@Column(length = 10)
	private long mobileNo;

	@Enumerated(EnumType.STRING) // stores "ACTIVE" in DB, not 0/1/2
	private UserStatus status = UserStatus.ACTIVE; // default on creation

	// Metadata Properties
	@CreationTimestamp
	@Column(insertable = true, updatable = false)
	private LocalDateTime registeredOn;
	@UpdateTimestamp
	@Column(insertable = false, updatable = true)
	private LocalDateTime updatedOn;
	@Version
	private Integer updateCount;

}
