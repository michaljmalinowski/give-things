package io.malinowski.michal.give_thing.service;

import io.malinowski.michal.give_thing.domain.model.Donation;
import io.malinowski.michal.give_thing.domain.repository.DonationRepository;
import io.malinowski.michal.give_thing.dto.NewDonationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DonationService {
    private static final Logger log = LoggerFactory.getLogger(DonationService.class);
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

    @Transactional
    public void saveNewDonation(NewDonationDto newDonationDto) {
        log.debug("Przygotowanie do zapisu:{}", newDonationDto);
        Donation donation = new Donation();
        donation.setQuantity(newDonationDto.getQuantity());
        donation.setCategories(newDonationDto.getCategories());
        donation.setInstitution(newDonationDto.getInstitution());
        donation.setStreet(newDonationDto.getStreet());
        donation.setCity(newDonationDto.getCity());
        donation.setZipCode(newDonationDto.getZipCode());
        donation.setPickUpDate(newDonationDto.getPickUpDate());
        donation.setPickUpTime(newDonationDto.getPickUpTime());
        donation.setPickUpComment(newDonationDto.getPickUpComment());
        donationRepository.save(donation);
        log.debug("Zapisano w bazie:{}", donation);
    }
}
