/**
 * ------------------------------------------------------------
 * Company     : Software Bakery Inc.
 * Author      : Sung Hyun Back
 * ------------------------------------------------------------
 *
 * © 2026 Software Bakery Inc. All rights reserved.
 */

package com.thesoftwarebakery.dining_qr_service.data;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "dining_order")
public class Order {

    @Id
    @GeneratedValue
    private UUID id;
    
    @Column(name = "ordered_date_time", nullable = false)
    private LocalDateTime orderedDateTime;

    public Order() {}

    public Order(LocalDateTime orderDateTime) {
        this.orderedDateTime = orderDateTime;
    }
}
