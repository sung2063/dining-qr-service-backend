/**
 * ------------------------------------------------------------
 * Company     : Software Bakery Inc.
 * Author      : Sung Hyun Back
 * ------------------------------------------------------------
 *
 * © 2026 Software Bakery Inc. All rights reserved.
 */

package com.thesoftwarebakery.dining_qr_service.constant;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum MenuItemTag {
    SPICY,
    VEGETARIAN,
    HALAL,
    KOSHER,
    SEAFOOD,
    SUGAR_FREE,
    LACTOSE_FREE,
    GLUTEN_FREE,
    PEANUT_FREE;

    @JsonCreator
    public static MenuItemTag fromString(String value) {
        return MenuItemTag.valueOf(value.toUpperCase());
    }
}
