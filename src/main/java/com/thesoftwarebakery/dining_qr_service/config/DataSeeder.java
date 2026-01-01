/**
 * ------------------------------------------------------------
 * Company     : Software Bakery Inc.
 * Author      : Sung Hyun Back
 * ------------------------------------------------------------
 *
 * © 2026 Software Bakery Inc. All rights reserved.
 */

package com.thesoftwarebakery.dining_qr_service.config;

import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.thesoftwarebakery.dining_qr_service.constant.MenuItemTag;
import com.thesoftwarebakery.dining_qr_service.constant.MenuItemType;
import com.thesoftwarebakery.dining_qr_service.data.Category;
import com.thesoftwarebakery.dining_qr_service.data.MenuItem;
import com.thesoftwarebakery.dining_qr_service.repository.CategoryRepository;
import com.thesoftwarebakery.dining_qr_service.repository.MenuItemRepository;

@Component
public class DataSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    private final MenuItemRepository menuItemRepository;

    public DataSeeder(CategoryRepository categoryRepository,
            MenuItemRepository menuItemRepository) {
        this.categoryRepository = categoryRepository;
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Import pre-built data
        if (categoryRepository.count() == 0) {
            Category category1 = categoryRepository.save(
                    new Category("Starter", "Light, flavorful bites to begin your meal.", MenuItemType.APPETIZER));
            UUID category1Id = category1.getId();
            menuItemRepository.save(new MenuItem("Garlic Parmesan Fries",
                    "Crispy fries tossed in garlic butter and parmesan.", category1Id,
                    "https://res.cloudinary.com/dhj7turyv/image/upload/v1767075294/garlic_parmesan_fries_xnspec.jpg", 7.99f,
                    List.of(MenuItemTag.VEGETARIAN)));
            menuItemRepository.save(new MenuItem("Bruschetta Toast",
                    "Grilled bread topped with tomatoes, basil, and olive oil.", category1Id,
                    "https://res.cloudinary.com/dhj7turyv/image/upload/v1767075300/bruschetta_toast_wpwgs1.jpg", 8.99f,
                    List.of(MenuItemTag.VEGETARIAN)));
            menuItemRepository.save(
                    new MenuItem("Crispy Calamari", "Lightly fried squid served with lemon and aioli.", category1Id,
                            "https://res.cloudinary.com/dhj7turyv/image/upload/v1767075294/crispy_calamari_lu5vtz.jpg",
                            12.99f, List.of(MenuItemTag.SEAFOOD)));
            menuItemRepository.save(new MenuItem("Chicken Bites",
                    "Tender fried chicken pieces with a tangy dipping sauce.", category1Id,
                    "https://res.cloudinary.com/dhj7turyv/image/upload/v1767075299/chicken_bites_rxarz2.jpg", 10.99f,
                    null));

            Category category2 = categoryRepository.save(new Category("Pasta",
                    "Classic, comforting pasta dishes with rich, bold flavors.", MenuItemType.MAIN));
            UUID category2Id = category2.getId();
            menuItemRepository.save(new MenuItem("Creamy Alfredo Fettuccine",
                    "Rich parmesan cream sauce over soft fettuccine.", category2Id,
                    "https://res.cloudinary.com/dhj7turyv/image/upload/v1767075295/creamy_alfredo_fettuccine_dd3squ.jpg", 15.99f,
                    List.of(MenuItemTag.VEGETARIAN)));
            menuItemRepository.save(
                    new MenuItem("Spaghetti Bolognese", "Slow-cooked beef ragu with herbs and tomatoes.", category2Id,
                            "https://res.cloudinary.com/dhj7turyv/image/upload/v1767075287/spaghetti_bolognese_w4mzss.jpg",
                            16.99f,
                            null));
            menuItemRepository
                    .save(new MenuItem("Pesto Penne", "Basil pesto tossed with penne and cherry tomatoes.", category2Id,
                            "https://res.cloudinary.com/dhj7turyv/image/upload/v1767075290/pesto_penne_x3pwly.jpg",
                            15.99f,
                            List.of(MenuItemTag.VEGETARIAN)));
            menuItemRepository.save(
                    new MenuItem("Seafood Linguine", "Shrimp and mussels in a garlic white-wine sauce.", category2Id,
                            "https://res.cloudinary.com/dhj7turyv/image/upload/v1767075290/seafood_linguine_cc8q1v.jpg",
                            18.99f,
                            List.of(MenuItemTag.SEAFOOD)));

            Category category3 = categoryRepository.save(new Category("Hamburger",
                    "Juicy, handcrafted burgers stacked with fresh toppings.", MenuItemType.MAIN));
            UUID category3Id = category3.getId();
            menuItemRepository.save(new MenuItem("Classic Cheeseburger",
                    "Juicy beef patty with cheddar, lettuce, and tomato.", category3Id,
                    "https://res.cloudinary.com/dhj7turyv/image/upload/v1767075297/classic_cheeseburger_uu7itn.jpg", 14.99f,
                    null));
            menuItemRepository
                    .save(new MenuItem("Bacon BBQ Burger", "Smoked bacon, BBQ sauce, and crispy onions.", category3Id,
                            "https://res.cloudinary.com/dhj7turyv/image/upload/v1767075301/bacon_bbq_burger_blu4gx.jpg",
                            15.99f,
                            null));
            menuItemRepository.save(
                    new MenuItem("Mushroom Swiss Burger", "Sautéed mushrooms with melted Swiss cheese.", category3Id,
                            "https://res.cloudinary.com/dhj7turyv/image/upload/v1767075290/mushroom_swiss_burger_v9sldj.jpg",
                            15.49f,
                            null));

            Category category4 = categoryRepository.save(new Category("Dessert",
                    "Sweet, indulgent treats to end your meal perfectly.", MenuItemType.DESSERT));
            UUID category4Id = category4.getId();
            menuItemRepository
                    .save(new MenuItem("Chocolate Lava Cake", "Warm chocolate cake with a molten center.", category4Id,
                            "https://res.cloudinary.com/dhj7turyv/image/upload/v1767075297/chocolate_lava_cake_tmbk5q.jpg",
                            7.99f,
                            List.of(MenuItemTag.VEGETARIAN)));
            menuItemRepository
                    .save(new MenuItem("Classic Cheesecake", "Creamy cheesecake with a buttery crust.", category4Id,
                            "https://res.cloudinary.com/dhj7turyv/image/upload/v1767075295/classic_cheesecake_gn75lt.jpg",
                            7.99f,
                            List.of(MenuItemTag.VEGETARIAN)));
            menuItemRepository
                    .save(new MenuItem("Tiramisu Cup", "Espresso-soaked layers with mascarpone cream.", category4Id,
                            "https://res.cloudinary.com/dhj7turyv/image/upload/v1767075286/tiramisu_cup_wrm2ea.jpg",
                            7.49f,
                            List.of(MenuItemTag.VEGETARIAN)));
            menuItemRepository.save(new MenuItem("Vanilla Ice Cream Sundae",
                    "Vanilla ice cream topped with chocolate drizzle.", category4Id,
                    "https://res.cloudinary.com/dhj7turyv/image/upload/v1767075285/vanilla_ice_cream_sundae_q3jhau.jpg", 5.99f,
                    List.of(MenuItemTag.VEGETARIAN)));

            Category category5 = categoryRepository.save(new Category("Drink",
                    "Refreshing, ice‑cold beverages to quench your thirst.", MenuItemType.BEVERAGE));
            UUID category5Id = category5.getId();
            menuItemRepository
                    .save(new MenuItem("Lemon Lime Soda", "Crisp citrus soda with refreshing sweetness.", category5Id,
                            "https://res.cloudinary.com/dhj7turyv/image/upload/v1767075291/lemon_lime_soda_poxdgm.jpg",
                            2.99f,
                            List.of(MenuItemTag.VEGETARIAN, MenuItemTag.SUGAR_FREE)));
            menuItemRepository.save(new MenuItem("Iced Tea", "Freshly brewed tea served chilled.", category5Id,
                    "https://res.cloudinary.com/dhj7turyv/image/upload/v1767075291/iced_tea_ep27pp.jpg", 2.99f,
                    List.of(MenuItemTag.VEGETARIAN, MenuItemTag.SUGAR_FREE)));
            menuItemRepository.save(new MenuItem("Strawberry Smoothie",
                    "Bright, refreshing blend of sweet strawberries and creamy chill.", category5Id,
                    "https://res.cloudinary.com/dhj7turyv/image/upload/v1767075286/strawberry_smoothie_nop2x1.jpg", 4.99f,
                    List.of(MenuItemTag.VEGETARIAN)));
        }
    }
}
