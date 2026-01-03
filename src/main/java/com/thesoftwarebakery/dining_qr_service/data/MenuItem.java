/**
 * ------------------------------------------------------------
 * Company     : Software Bakery Inc.
 * Author      : Sung Hyun Back
 * ------------------------------------------------------------
 *
 * © 2026 Software Bakery Inc. All rights reserved.
 */

package com.thesoftwarebakery.dining_qr_service.data;

import java.util.List;
import java.util.UUID;

import com.thesoftwarebakery.dining_qr_service.constant.MenuItemTag;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "menu_item")
public class MenuItem {

    @jakarta.persistence.Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "Name must not be blank.")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @NotBlank(message = "Category id must not be blank.")
    @Column(name = "category_id")
    private UUID categoryId;

    @Column(name = "main_image")
    private String mainImage;

    @NotBlank(message = "Original price must not be blank.")
    @Column(name = "original_price", nullable = false)
    private float originalPrice;

    @ElementCollection(targetClass = MenuItemTag.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "menu_item_tag", joinColumns = @JoinColumn(name = "menu_item_id"))
    @Column(name = "tags")
    private List<MenuItemTag> tags;

    public MenuItem() {
    }

    public MenuItem(String name, String description, UUID categoryId, String mainImage,
            float originalPrice, List<MenuItemTag> tags) {
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.mainImage = mainImage;
        this.originalPrice = originalPrice;
        this.tags = tags;
    }

}
