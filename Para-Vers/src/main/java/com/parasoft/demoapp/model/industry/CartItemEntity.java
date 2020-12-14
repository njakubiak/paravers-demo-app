package com.parasoft.demoapp.model.industry;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="tbl_cart")
//@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class CartItemEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "item_id")
    private Long itemId;

    private String name;

    private String description;

    private String image;

    @Transient
    private Integer realInStock;

    private Integer quantity;
    
    public CartItemEntity() {
    }

    public CartItemEntity(Long userId, ItemEntity item, Integer quantity) {
        this.userId = userId;
        this.itemId = item.getId();
        this.name = item.getName();
        this.description = item.getDescription();
        this.image = item.getImage();
        this.quantity = quantity;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getRealInStock() {
		return realInStock;
	}

	public void setRealInStock(Integer realInStock) {
		this.realInStock = realInStock;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


}
