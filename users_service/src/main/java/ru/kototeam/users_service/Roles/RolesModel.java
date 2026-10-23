package ru.kototeam.users_service.Roles;

import jakarta.persistence.*;
import lombok.*;
import ru.kototeam.users_service.Users.UsersModel;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolesModel {
	@Id
	private String name;
	private int right;
	@OneToMany(mappedBy="role")
	private List<UsersModel> users;
}