package io.malinowski.michal.give_thing.domain.repository;

import io.malinowski.michal.give_thing.domain.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DonationRepository extends JpaRepository<Donation, Long> {
    long count();

    @Query("SELECT SUM (d.quantity) FROM Donation d")
    long countSack();
}
