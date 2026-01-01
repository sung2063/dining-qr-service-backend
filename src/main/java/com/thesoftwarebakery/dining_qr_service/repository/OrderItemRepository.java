/**
 * ------------------------------------------------------------
 * Company     : Software Bakery Inc.
 * Author      : Sung Hyun Back
 * ------------------------------------------------------------
 *
 * © 2026 Software Bakery Inc. All rights reserved.
 */

package com.thesoftwarebakery.dining_qr_service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thesoftwarebakery.dining_qr_service.data.OrderItem;
import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {

    List<OrderItem> findByOrderId(UUID orderId);
    
}
