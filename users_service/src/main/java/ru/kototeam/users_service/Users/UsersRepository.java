package ru.kototeam.users_service.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.*;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersModel, Integer> {
	public Page<UsersModel> findAll(Pageable page);
	public Optional<UsersModel> findById(int id);
}