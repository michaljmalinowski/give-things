package io.malinowski.michal.give_thing.service;

import io.malinowski.michal.give_thing.domain.model.Institution;
import io.malinowski.michal.give_thing.domain.repository.InstitutionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutionService {
    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }
}
