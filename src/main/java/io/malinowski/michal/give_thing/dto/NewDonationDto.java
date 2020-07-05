package io.malinowski.michal.give_thing.dto;

import io.malinowski.michal.give_thing.domain.model.Category;
import io.malinowski.michal.give_thing.domain.model.Institution;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true, exclude = {"categories", "institution"})
public class NewDonationDto {
    @NotNull
    private Integer quantity;
    @ManyToMany
    private List<Category> categories;

    @ManyToOne
    private Institution institution;

    private String street;
    @NotNull
    private String city;
    @NotNull
    private String zipCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;

    private String pickUpComment;

    private String phone;
    @Email
    private String email;
}