package io.malinowski.michal.give_thing.domain.repository;

import io.malinowski.michal.give_thing.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
