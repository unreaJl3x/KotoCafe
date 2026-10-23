package ru.kototeam.users_service.Users;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.kototeam.users_service.Roles.RolesService;
import ru.kototeam.users_service.Users.dto.*;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsersService {
	private final UsersRepository repo;

	public UsersModelDtoGet register(UsersModelDtoPost user) {
		log.info("");
		return null;
	}
	public UsersModelDtoGet auth(UsersModelDtoAuth user) {
		log.info("");
		return null;
	}
}