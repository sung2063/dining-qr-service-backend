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

public enum MenuItemType {
    APPETIZER,
    MAIN,
    SIDE,
    DESSERT,
    BEVERAGE,
    ALCOHOLIC_BEVERAGE;

    @JsonCreator
    public static MenuItemType fromString(String value) {
        return MenuItemType.valueOf(value.toUpperCase());
    }
}
