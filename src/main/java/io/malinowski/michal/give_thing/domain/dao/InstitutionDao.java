package io.malinowski.michal.give_thing.domain.dao;

import io.malinowski.michal.give_thing.domain.model.Institution;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class InstitutionDao {
    @PersistenceContext
    private EntityManager entityManager;

    public Institution getById(Long id) {
        return entityManager.find(Institution.class, id);
    }

    @Transactional
    public void save(Institution entity) {
        entityManager.persist(entity);
    }

    @Transactional
    public void update(Institution entity) {
        entityManager.merge(entity);
    }

    @Transactional
    public Institution updateAndReturn(Institution entity) {
        return entityManager.merge(entity);
    }

    @Transactional
    public void remove(Institution entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public List<Institution> findAll() {
        return entityManager.createQuery("SELECT i FROM Institution i", Institution.class).getResultList();
    }
}
