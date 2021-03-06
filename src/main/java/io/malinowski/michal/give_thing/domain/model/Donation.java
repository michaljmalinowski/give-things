package io.malinowski.michal.give_thing.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "donations")
@Getter
@Setter
@ToString(callSuper = true, exclude = {"categories", "institution"})
public class Donation extends ParentEntity {
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
    @DateTimeFormat(pattern = "gg:mm:ss")
    private LocalTime pickUpTime;

    private String pickUpComment;
}