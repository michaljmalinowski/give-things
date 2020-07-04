package io.malinowski.michal.give_thing.domain.repository;

import io.malinowski.michal.give_thing.domain.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstitutionRepository extends JpaRepository<Institution,Long> {
    List<Institution> findAll();
}