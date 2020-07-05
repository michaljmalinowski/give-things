package io.malinowski.michal.give_thing.domain.repository;

import io.malinowski.michal.give_thing.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
