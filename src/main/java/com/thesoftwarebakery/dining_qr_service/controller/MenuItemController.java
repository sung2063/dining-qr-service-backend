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

import com.thesoftwarebakery.dining_qr_service.data.MenuItem;
import com.thesoftwarebakery.dining_qr_service.repository.MenuItemRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("v1/menu-item")
public class MenuItemController {

    private final MenuItemRepository menuItemRepository;

    public MenuItemController(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @GetMapping
    public List<MenuItem> getMenuItems(@RequestParam(required = false) String categoryId) {
        if (categoryId != null) {
            return menuItemRepository.findByCategoryId(UUID.fromString(categoryId));
        }
        return menuItemRepository.findAll();
    }

}
