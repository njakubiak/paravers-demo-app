package com.parasoft.demoapp.model.industry;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@Table(name="tbl_category")
@NoArgsConstructor
@EqualsAndHashCode
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String name;

    @Setter
    private String description;

    @Setter
    private String image;

    public CategoryEntity(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }
}
