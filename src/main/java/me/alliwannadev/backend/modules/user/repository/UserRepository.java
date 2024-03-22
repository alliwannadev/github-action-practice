package me.alliwannadev.backend.modules.user.repository;

import me.alliwannadev.backend.modules.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByEmail(String email);

}
