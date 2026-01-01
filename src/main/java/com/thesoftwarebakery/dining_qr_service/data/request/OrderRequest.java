/**
 * ------------------------------------------------------------
 * Company     : Software Bakery Inc.
 * Author      : Sung Hyun Back
 * ------------------------------------------------------------
 *
 * © 2026 Software Bakery Inc. All rights reserved.
 */

package com.thesoftwarebakery.dining_qr_service.data.request;

import java.util.List;

import com.thesoftwarebakery.dining_qr_service.data.OrderItem;

import lombok.Data;

@Data
public class OrderRequest {
    private List<OrderItem> items;
}
