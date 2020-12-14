package com.parasoft.demoapp.model.industry;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="tbl_item")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ItemEntity {
    @Id
    @Setter
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String name;

    @Setter
    private String description;

    @Setter
    @Column(name = "in_stock")
    private Integer inStock;

    @Setter
    private String image;

    @Setter
    @Enumerated(EnumType.STRING)
    private RegionType region;

    @Setter
    @Column(name = "last_accessed_date")
    private Date lastAccessedDate;

    @Setter
    @Column(name = "category_id")
    private Long categoryId;

    public ItemEntity(String name, String description, Long categoryId, Integer inStock,
                      String image, RegionType region, Date lastAccessedDate) {
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.image = image;
        this.inStock = inStock;
        this.region = region;
        this.lastAccessedDate = lastAccessedDate;
    }

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Integer getInStock() {
		return inStock;
	}

	public String getImage() {
		return image;
	}

	public RegionType getRegion() {
		return region;
	}

	public Date getLastAccessedDate() {
		return lastAccessedDate;
	}

	public Long getCategoryId() {
		return categoryId;
	}


}
