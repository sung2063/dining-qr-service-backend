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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thesoftwarebakery.dining_qr_service.common.error.ResourceNotFoundException;
import com.thesoftwarebakery.dining_qr_service.data.MenuItem;
import com.thesoftwarebakery.dining_qr_service.repository.MenuItemRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Menu Item", description = "Operations related to menu items.")
@RestController
@RequestMapping("v1/menu-item")
public class MenuItemController {

    private final MenuItemRepository menuItemRepository;

    public MenuItemController(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Operation(summary = "Create a menu item.")
    @PostMapping
    public MenuItem createMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @Operation(summary = "Return menu items filtered by category ID when provided. Throw an error if no items are found.")
    @GetMapping
    public List<MenuItem> getMenuItems(@RequestParam(required = false) String categoryId) {
        List<MenuItem> menuItems = (categoryId != null)
                ? menuItemRepository.findByCategoryId(UUID.fromString(categoryId))
                : menuItemRepository.findAll();

        if (menuItems.isEmpty()) {
            String message = (categoryId != null)
                    ? "No menu items found for category: " + categoryId
                    : "No menu items found";
            throw new ResourceNotFoundException(message);
        }
        return menuItems;
    }

}
