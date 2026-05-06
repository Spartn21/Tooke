package com.tooke.app.model

data class FoodSpot(
    val id: Int,
    val name: String,
    val description: String,
    val location: String,
    val priceRange: String,
    val foodItems: List<String>,
    val isOpen: Boolean,
    val rating: Float,
    val distanceFromCampus: String,
    val category: FoodCategory
)

enum class FoodCategory(val label: String) {
    ROLEX("Rolex"),
    LOCAL_MEAL("Local Meal"),
    SNACKS("Snacks"),
    BEVERAGES("Beverages"),
    MIXED("Mixed")
}
