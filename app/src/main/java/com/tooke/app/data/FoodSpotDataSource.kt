package com.tooke.app.data

import com.tooke.app.model.FoodCategory
import com.tooke.app.model.FoodSpot

object FoodSpotDataSource {

    fun getAllSpots(): List<FoodSpot> = listOf(
        FoodSpot(
            id = 1,
            name = "Mama Nakato's Kitchen",
            description = "Authentic home-cooked Ugandan meals. The best matooke in Kampala campus area.",
            location = "Gate B, Opposite Ndejje Kampala Campus",
            priceRange = "UGX 3,000 – 6,000",
            foodItems = listOf("Matooke & Groundnut Stew", "Rice & Beans", "Posho & Beef", "Maize Porridge"),
            isOpen = true,
            rating = 4.8f,
            distanceFromCampus = "2 min walk",
            category = FoodCategory.LOCAL_MEAL
        ),
        FoodSpot(
            id = 2,
            name = "Rolex Corner",
            description = "Fast, cheap, and filling. The classic Ugandan rolex — chapati rolled with eggs and vegetables.",
            location = "Near Bukoto Stage, Kampala",
            priceRange = "UGX 1,500 – 3,500",
            foodItems = listOf("Plain Rolex", "Double Egg Rolex", "Rolex + Avocado", "Chapati Only"),
            isOpen = true,
            rating = 4.5f,
            distanceFromCampus = "5 min walk",
            category = FoodCategory.ROLEX
        ),
        FoodSpot(
            id = 3,
            name = "Campus Canteen",
            description = "On-campus cafeteria serving quick meals between lectures. Student-friendly prices.",
            location = "Inside Ndejje Kampala Campus, Block A",
            priceRange = "UGX 2,000 – 5,000",
            foodItems = listOf("Fried Rice", "Chapati & Beans", "Soda & Juice", "Mandazi", "Tea"),
            isOpen = true,
            rating = 3.9f,
            distanceFromCampus = "On campus",
            category = FoodCategory.MIXED
        ),
        FoodSpot(
            id = 4,
            name = "Ssalongo's Grill",
            description = "Grilled meat and local sides. Popular for lunch breaks. Known for their suya and gonja.",
            location = "Bukoto Road, 200m from campus",
            priceRange = "UGX 4,000 – 9,000",
            foodItems = listOf("Grilled Chicken", "Suya (Roasted Meat)", "Gonja (Roasted Plantain)", "Nsenene (Grasshoppers, seasonal)"),
            isOpen = false,
            rating = 4.6f,
            distanceFromCampus = "7 min walk",
            category = FoodCategory.LOCAL_MEAL
        ),
        FoodSpot(
            id = 5,
            name = "Jajja's Groundnuts & Snacks",
            description = "Street snacks and light bites. Perfect for between-class hunger. Run by a local grandmother.",
            location = "Main Gate Sidewalk, Ndejje Kampala",
            priceRange = "UGX 500 – 2,000",
            foodItems = listOf("Roasted Groundnuts", "Cassava Crisps", "Boiled Eggs", "Mandazi", "Popcorn"),
            isOpen = true,
            rating = 4.3f,
            distanceFromCampus = "1 min walk",
            category = FoodCategory.SNACKS
        ),
        FoodSpot(
            id = 6,
            name = "Freshly Squeezed",
            description = "Local fruit juices and cold beverages. Passion fruit, watermelon, and pineapple daily.",
            location = "Opposite Campus Parking, Bukoto",
            priceRange = "UGX 1,000 – 2,500",
            foodItems = listOf("Passion Fruit Juice", "Watermelon Juice", "Pineapple Juice", "Tamarind Drink", "Cold Water"),
            isOpen = true,
            rating = 4.4f,
            distanceFromCampus = "3 min walk",
            category = FoodCategory.BEVERAGES
        ),
        FoodSpot(
            id = 7,
            name = "Nnalongo's Katogo Stop",
            description = "Morning and midday katogo specialist. Matooke cooked with offals or beans — a true Ugandan breakfast.",
            location = "Ntinda Road Junction, near Kampala Campus",
            priceRange = "UGX 2,500 – 4,500",
            foodItems = listOf("Katogo (Matooke + Offals)", "Katogo (Matooke + Beans)", "Millet Porridge", "Black Tea"),
            isOpen = true,
            rating = 4.7f,
            distanceFromCampus = "10 min walk",
            category = FoodCategory.LOCAL_MEAL
        )
    )
}
