/**
 * ------------------------------------------------------------
 * Company     : Software Bakery Inc.
 * Author      : Sung Hyun Back
 * ------------------------------------------------------------
 *
 * © 2026 Software Bakery Inc. All rights reserved.
 */

package com.thesoftwarebakery.dining_qr_service.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thesoftwarebakery.dining_qr_service.data.Order;
import com.thesoftwarebakery.dining_qr_service.data.OrderItem;
import com.thesoftwarebakery.dining_qr_service.data.request.OrderRequest;
import com.thesoftwarebakery.dining_qr_service.data.response.OrderResponse;
import com.thesoftwarebakery.dining_qr_service.repository.OrderItemRepository;
import com.thesoftwarebakery.dining_qr_service.repository.OrderRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Order", description = "Operations related to orders.")
@RestController
@RequestMapping("v1/order")
public class OrderController {

    private final OrderItemRepository orderItemRepository;

    private final OrderRepository diningOrderRepository;

    public OrderController(OrderRepository diningOrderRepository, OrderItemRepository orderItemRepository) {
        this.diningOrderRepository = diningOrderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Operation(summary = "Create an order.")
    @PostMapping
    public OrderResponse createDiningOrder(@RequestBody OrderRequest orderRequest) {
        OrderResponse response = new OrderResponse();
        LocalDateTime currentDateTime = LocalDateTime.now();
        Order order = diningOrderRepository.save(new Order(currentDateTime));
        UUID orderId = order.getId();
        response.setId(orderId);
        response.setDateTime(currentDateTime);
        response.setItems(new ArrayList<>());
        orderRequest.getItems().forEach(cartItem -> {
            OrderItem orderItem = new OrderItem(orderId, cartItem.getMenuItemId(), cartItem.getMenuItemName(),
                    cartItem.getMenuItemType(), cartItem.getCategoryId(), cartItem.getCategoryName(),
                    cartItem.getSubTotal(), cartItem.getTax(), cartItem.getTotal());
            response.getItems().add(orderItemRepository.save(orderItem));
        });
        return response;
    }

    @Operation(summary = "Return all order data.")
    @GetMapping
    public List<OrderResponse> getAllDiningOrder() {
        List<OrderResponse> ordersResponse = new ArrayList<>();
        diningOrderRepository.findAll().forEach(diningOrder -> {
            OrderResponse orderReposponse = new OrderResponse();
            orderReposponse.setId(diningOrder.getId());
            orderReposponse.setItems(orderItemRepository.findByOrderId(diningOrder.getId()));
            orderReposponse.setDateTime(diningOrder.getOrderedDateTime());
            ordersResponse.add(orderReposponse);
        });
        return ordersResponse;
    }

    @Operation(summary = "Return the order data for the specified order ID.")
    @GetMapping("/{orderId}")
    public OrderResponse getDiningOrderByOrderId(@PathVariable String orderId) {
        return diningOrderRepository.findById(UUID.fromString(orderId)).map(diningOrder -> {
            OrderResponse orderReposponse = new OrderResponse();
            orderReposponse.setId(diningOrder.getId());
            orderReposponse.setItems(orderItemRepository.findByOrderId(diningOrder.getId()));
            orderReposponse.setDateTime(diningOrder.getOrderedDateTime());
            return orderReposponse;
        }).orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
