package io.malinowski.michal.give_thing.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "institutions")
@Getter
@Setter
@ToString(callSuper = true)
public class Institution extends ParentEntity {
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String description;
}