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
import lombok.Data;

@Entity
@Data
@Table(name = "dining_order_item")
public class OrderItem {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "order_id", nullable = false)
    private UUID orderId;

    @Column(name = "menu_item_id", nullable = false)
    private UUID menuItemId;

    @Column(name = "menu_item_name", nullable = false)
    private String menuItemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "menu_item_type")
    private MenuItemType menuItemType;

    @Column(name = "category_id", nullable = false)
    private UUID categoryId;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @Column(name = "sub_total", nullable = false)
    private float subTotal;

    @Column(name = "tax")
    private float tax;

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
