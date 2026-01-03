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
@Table(name = "dining_order_item")
public class OrderItem {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "Order id must not be blank.")
    @Column(name = "order_id", nullable = false)
    private UUID orderId;

    @NotBlank(message = "Menu item id must not be blank.")
    @Column(name = "menu_item_id", nullable = false)
    private UUID menuItemId;

    @NotBlank(message = "Menu item name must not be blank.")
    @Column(name = "menu_item_name", nullable = false)
    private String menuItemName;

    @NotBlank(message = "Menu item type must not be blank.")
    @Enumerated(EnumType.STRING)
    @Column(name = "menu_item_type")
    private MenuItemType menuItemType;

    @NotBlank(message = "Category id must not be blank.")
    @Column(name = "category_id", nullable = false)
    private UUID categoryId;

    @NotBlank(message = "Category name must not be blank.")
    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @NotBlank(message = "Subtotal must not be blank.")
    @Column(name = "sub_total", nullable = false)
    private float subTotal;

    @NotBlank(message = "Tax must not be blank.")
    @Column(name = "tax")
    private float tax;

    @NotBlank(message = "Total must not be blank.")
    @Column(name = "total", nullable = false)
    private float total;

    public OrderItem() {
    }

    public OrderItem(UUID orderId, UUID menuItemId, String menuItemName, MenuItemType menuItemType, UUID categoryId,
            String categoryName, float subTotal, float tax, float total) {
                this.orderId = orderId;
                this.menuItemId = menuItemId;
                this.menuItemName = menuItemName;
                this.menuItemType = menuItemType;
                this.categoryId = categoryId;
                this.categoryName = categoryName;
                this.subTotal = subTotal;
                this.tax = tax;
                this.total = total;
    }

}
