package io.malinowski.michal.give_thing.domain.repository;

import io.malinowski.michal.give_thing.domain.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionRepository extends JpaRepository<Institution,Long> {
}