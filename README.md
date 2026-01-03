# Dining-QR Backend Service (MVP)

A lightweight Spring Boot backend that drives the Dining‑QR Ordering System, providing REST APIs for menu retrieval and order submission. The project uses PostgreSQL configured to simulate a cloud‑hosted database environment, reflecting the production architecture where the database runs in the cloud. Designed with a modular, maintainable architecture to support the MVP version of the platform.

![Java](https://img.shields.io/badge/Java-007396?logo=java&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?logo=apachemaven&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?logo=springboot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?logo=postgresql&logoColor=white)

## Features

- __Menu retrieval API__ — serves menu categories and items to the frontend
- __Order submission API__ — receives and processes customer orders
- __Modular service structure__ — clean separation of controllers, services, and models
- __CORS‑enabled endpoints__ — allows secure communication with the React frontend

## Prerequisites

- Java 17+
- Maven
- Spring Boot
- PostgreSQL

## Setup & Run

1. <b>Clone the repository</b>
2. <b>Set up the database</b>
   1. Start your PostgreSQL server
   2. Create a new database (example: dining_qr_db)
3. <b>Create your local configuration file</b><br>
This project uses a local Spring profile for development.
<br>Since `application-local.yaml` contains credentials, it is __not included in the repository__.
<br>Create the file manually at `src/main/resources/application-local.yaml` and add your PostgreSQL settings:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/<DB_NAME>
    username: <USERNAME>
    password: <PASSWORD>
```
4. <b>Run the application</b><br>
Open the main class `DiningQrServiceApplication.java` and run the Spring Boot application. 
When the application starts, it will automatically insert the preloaded sample data into your PostgreSQL database.

## API Endpoints

### 🗂️ Category

__➜ POST /v1/category__ - Creates a new category.

__Request example__:
```Json
{
  "name": "Hamburger",
  "description": "Juicy, handcrafted burgers stacked with fresh toppings.",
  "type": "MAIN"
}
```

__Response example__:
```Json
{
  "id": "0e46e52a-40f0-4a12-9165-8b3046a88323",
  "name": "Hamburger",
  "description": "Juicy, handcrafted burgers stacked with fresh toppings.",
  "type": "MAIN"
}
```

__➜ GET /v1/category__ - Returns all categories.

__Response example__:
```Json
[
  {
    "id": "0e46e52a-40f0-4a12-9165-8b3046a88323",
    "name": "Hamburger",
    "description": "Juicy, handcrafted burgers stacked with fresh toppings.",
    "type": "MAIN"
  }
]
```
ℹ️ __Possible values for "type"__: "APPETIZER", "MAIN", "SIDE", "DESSERT", "BEVERAGE", or "ALCOHOLIC_BEVERAGE"

· · ·

### 🍽️ Menu Item
__➜ POST /v1/menu-item__ - Creates a new menu item.

__Request example__:
```Json
{
  "name": "Bacon BBQ Burger",
  "description": "Smoked bacon, BBQ sauce, and crispy onions.",
  "categoryId": "0e46e52a-40f0-4a12-9165-8b3046a88323",
  "mainImage": "https://res.cloudinary.com/dhj7turyv/image/upload/v1767075301/bacon_bbq_burger_blu4gx.jpg",
  "originalPrice": 15.99,
  "tag": ["PEANUT_FREE"]
}
```

__Response example__:
```Json
{
  "id": "9ea7b44f-dc2c-4985-8d7c-671e2800ef33",
  "name": "Bacon BBQ Burger",
  "description": "Smoked bacon, BBQ sauce, and crispy onions.",
  "categoryId": "0e46e52a-40f0-4a12-9165-8b3046a88323",
  "mainImage": "https://res.cloudinary.com/dhj7turyv/image/upload/v1767075301/bacon_bbq_burger_blu4gx.jpg",
  "originalPrice": 15.99,
  "tag": ["PEANUT_FREE"]
}
```

__➜ GET /v1/menu-item__ - Returns all menu items.<br>
__➜ GET /v1/menu-item?categoryId={categoryId}__ - Returns the menu items under the specified category ID.

```Json
[
  {
    "id": "9ea7b44f-dc2c-4985-8d7c-671e2800ef33"
    "name": "Bacon BBQ Burger",
    "description": "Smoked bacon, BBQ sauce, and crispy onions.",
    "categoryId": "0e46e52a-40f0-4a12-9165-8b3046a88323",
    "mainImage": "https://res.cloudinary.com/dhj7turyv/image/upload/v1767075301/bacon_bbq_burger_blu4gx.jpg",
    "originalPrice": 15.99,
    "tag": ["PEANUT_FREE"]
  }
]
```
ℹ️ __Possible values for "tag"__: "SPICY", "VEGETARIAN", "HALAL", "KOSHER", "SEAFOOD", "SUGAR_FREE", "LACTOSE_FREE", "GLUTEN_FREE", "PEANUT_FREE", and null

· · ·

### 🧾 Order
__➜ POST /v1/order__ - Creates a new order.

__Request example__:
```Json
{
  "items": [
    {
      "menuItemId": "9ea7b44f-dc2c-4985-8d7c-671e2800ef33",
      "menuItemName": "Bacon BBQ Burger",
      "menuItemType": "MAIN",
      "categoryId": "0e46e52a-40f0-4a12-9165-8b3046a88323",
      "categoryName": "Hamburger",
      "subTotal": 15.99,
      "tax": 2.08,
      "total": 18.07
    }
  ]
}
```

__Response example__:
```Json
{
  "id": "b1f39366-07b0-4f14-9f55-76e03b077592",
  "items": [
    {
      "id": "3207c68c-c8ac-4c62-a72e-ef25b13edb86",
      "orderId": "b1f39366-07b0-4f14-9f55-76e03b077592",
      "menuItemId": "9ea7b44f-dc2c-4985-8d7c-671e2800ef33",
      "menuItemName": "Bacon BBQ Burger",
      "menuItemType": "MAIN",
      "categoryId": "0e46e52a-40f0-4a12-9165-8b3046a88323",
      "categoryName": "Hamburger",
      "subTotal": 15.99,
      "tax": 2.08,
      "total": 18.07
    }
  ],
  "dateTime": "2026-01-01T07:00:00.040945"
}
```

__➜ GET /v1/order__ - Returns all orders.

__Response example__:
```Json
[
  {
    "id": "b1f39366-07b0-4f14-9f55-76e03b077592",
    "items": [
      {
        "id": "3207c68c-c8ac-4c62-a72e-ef25b13edb86",
        "orderId": "b1f39366-07b0-4f14-9f55-76e03b077592",
        "menuItemId": "9ea7b44f-dc2c-4985-8d7c-671e2800ef33",
        "menuItemName": "Bacon BBQ Burger",
        "menuItemType": "MAIN",
        "categoryId": "0e46e52a-40f0-4a12-9165-8b3046a88323",
        "categoryName": "Hamburger",
        "subTotal": 15.99,
        "tax": 2.08,
        "total": 18.07
      }
    ],
    "dateTime": "2026-01-01T07:00:00.040945"
  }
]
```

__➜ GET /v1/order/{orderId}__ - Returns the order data for the specified order ID.

__Response example__:
```Json
{
   "id": "b1f39366-07b0-4f14-9f55-76e03b077592",
   "items": [
      {
         "id": "3207c68c-c8ac-4c62-a72e-ef25b13edb86",
         "orderId": "b1f39366-07b0-4f14-9f55-76e03b077592",
         "menuItemId": "9ea7b44f-dc2c-4985-8d7c-671e2800ef33",
         "menuItemName": "Bacon BBQ Burger",
         "menuItemType": "MAIN",
         "categoryId": "0e46e52a-40f0-4a12-9165-8b3046a88323",
         "categoryName": "Hamburger",
         "subTotal": 15.99,
         "tax": 2.08,
         "total": 18.07
      }
   ],
   "dateTime": "2026-01-01T07:00:00.040945"
}
```

## License

This project is for portfolio and demonstration purposes.
