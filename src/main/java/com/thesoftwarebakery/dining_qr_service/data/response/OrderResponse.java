/**
 * ------------------------------------------------------------
 * Company     : Software Bakery Inc.
 * Author      : Sung Hyun Back
 * ------------------------------------------------------------
 *
 * © 2026 Software Bakery Inc. All rights reserved.
 */

package com.thesoftwarebakery.dining_qr_service.data.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.thesoftwarebakery.dining_qr_service.data.OrderItem;

import lombok.Data;

@Data
public class OrderResponse {
    private UUID id;
    private List<OrderItem> items;
    private LocalDateTime dateTime;
}
