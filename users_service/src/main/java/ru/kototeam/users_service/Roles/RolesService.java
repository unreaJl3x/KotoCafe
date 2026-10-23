package ru.kototeam.users_service.Roles;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
@Service
@RequiredArgsConstructor
@Slf4j
public class RolesService {
	private final RolesRepository rolesRepo;
	
	public List<?> findAll() {
		log.info("");
		return null;
	}
	public Optional<?> findById(String id) {
		log.info("");
		return null;
	}
	public Object create() {
		log.info("");
		return null;
	}
}
