package ru.kototeam.users_service.Users;

import jakarta.persistence.*;
import lombok.*;
import ru.kototeam.users_service.Roles.RolesModel;
import ru.kototeam.users_service.Users.dto.UsersModelDtoGet;
import ru.kototeam.users_service.Users.dto.UsersModelDtoPost;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersModel {
	@Id
	public Integer id;
	private String username;
	private String email;
	private int age;
	@ManyToOne()
	private RolesModel role;
	
	
	public static UsersModelDtoGet toDtoGet(UsersModel user) {
		return new UsersModelDtoGet(user.getId(),user.getUsername(), user.getRole().getName(), user.getAge());
	}
	
	public static UsersModel fromDtoPost(UsersModelDtoPost post) {
		return new UsersModel(0,post.username(),post.email(), post.age(),null);
	}
}