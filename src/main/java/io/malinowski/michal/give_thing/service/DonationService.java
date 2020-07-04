package io.malinowski.michal.give_thing.service;

import io.malinowski.michal.give_thing.domain.repository.DonationRepository;
import org.springframework.stereotype.Service;

@Service
public class DonationService {
    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public Long countDonation() {
        return donationRepository.count();
    }

    public Long countSack() {
        return donationRepository.countSack();
    }
}
