package ru.kototeam.users_service.Users;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import ru.kototeam.users_service.Users.dto.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsersController {
	private final UsersService userService;
	
	@PostMapping("/auth")
	public ResponseEntity<UsersModelDtoGet> auth(@RequestBody UsersModelDtoAuth auth) {
		return null;
	}
	@GetMapping("/ad/{id}")
	public ResponseEntity<UsersModelDtoGet> findById(@PathVariable int id) {
		return null;
	}  
	@GetMapping("/ad/")
	public ResponseEntity<UsersModelDtoGet> findAll() {
		return null;
	}
	@PostMapping("/ad/")
	public ResponseEntity<Void> create(@RequestBody UsersModelDtoGet users) {
		return null;
	}
}
