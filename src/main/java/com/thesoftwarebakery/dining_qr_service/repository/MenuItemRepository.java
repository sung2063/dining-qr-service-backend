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

import com.thesoftwarebakery.dining_qr_service.data.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, UUID> {
    
}
