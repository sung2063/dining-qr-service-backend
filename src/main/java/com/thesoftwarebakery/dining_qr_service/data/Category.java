/**
 * ------------------------------------------------------------
 * Company     : Software Bakery Inc.
 * Author      : Sung Hyun Back
 * ------------------------------------------------------------
 *
 * © 2026 Software Bakery Inc. All rights reserved.
 */

package com.thesoftwarebakery.dining_qr_service.data;

import java.util.UUID;

import com.thesoftwarebakery.dining_qr_service.constant.MenuItemType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "category")
public class Category {
    
    @Id
    @GeneratedValue
    private UUID id;
    
    @NotBlank(message = "Name must not be blank")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;
    
    @NotBlank(message = "Type must not be blank")
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private MenuItemType type;

    public Category() {}

    public Category(String name, String description, MenuItemType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

}
