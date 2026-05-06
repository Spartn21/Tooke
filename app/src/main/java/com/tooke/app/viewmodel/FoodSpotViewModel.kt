package com.tooke.app.viewmodel

import androidx.lifecycle.ViewModel
import com.tooke.app.data.FoodSpotDataSource
import com.tooke.app.model.FoodCategory
import com.tooke.app.model.FoodSpot
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class HomeUiState(
    val allSpots: List<FoodSpot> = emptyList(),
    val filteredSpots: List<FoodSpot> = emptyList(),
    val selectedCategory: FoodCategory? = null,
    val searchQuery: String = "",
    val isLoading: Boolean = false
)

class FoodSpotViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadSpots()
    }

    private fun loadSpots() {
        val spots = FoodSpotDataSource.getAllSpots()
        _uiState.value = _uiState.value.copy(
            allSpots = spots,
            filteredSpots = spots,
            isLoading = false
        )
    }

    fun onSearchQueryChanged(query: String) {
        _uiState.value = _uiState.value.copy(searchQuery = query)
        applyFilters()
    }

    fun onCategorySelected(category: FoodCategory?) {
        _uiState.value = _uiState.value.copy(selectedCategory = category)
        applyFilters()
    }

    private fun applyFilters() {
        val state = _uiState.value
        var result = state.allSpots

        if (state.searchQuery.isNotBlank()) {
            result = result.filter { spot ->
                spot.name.contains(state.searchQuery, ignoreCase = true) ||
                        spot.foodItems.any { it.contains(state.searchQuery, ignoreCase = true) } ||
                        spot.location.contains(state.searchQuery, ignoreCase = true)
            }
        }

        state.selectedCategory?.let { category ->
            result = result.filter { it.category == category }
        }

        _uiState.value = _uiState.value.copy(filteredSpots = result)
    }

    fun getSpotById(id: Int): FoodSpot? {
        return _uiState.value.allSpots.find { it.id == id }
    }
}
