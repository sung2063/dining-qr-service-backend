/**
 * ------------------------------------------------------------
 * Company     : Software Bakery Inc.
 * Author      : Sung Hyun Back
 * ------------------------------------------------------------
 *
 * © 2026 Software Bakery Inc. All rights reserved.
 */

package com.thesoftwarebakery.dining_qr_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thesoftwarebakery.dining_qr_service.data.OrderItem;
import com.thesoftwarebakery.dining_qr_service.repository.OrderItemRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("v1/order-item")
public class OrderItemController {

    private final OrderItemRepository diningOrderItemRepository;

    public OrderItemController(OrderItemRepository diningOrderItemRepository) {
        this.diningOrderItemRepository = diningOrderItemRepository;
    }

    @GetMapping
    public List<OrderItem> getAllDiningOrderItem() {
        return diningOrderItemRepository.findAll();
    }
}
