Tooke - Find Affordable Food Near Ndejje Kampala Campus
Tooke (from Matooke, Uganda's green banana staple) helps Ndejje University Kampala Campus students discover nearby affordable food spots so no student leaves campus hungry.

Video Presentation
https://youtu.be/Ul80JHY_ns0
15-minute presentation covering Problem Pitch, UI/UX Walkthrough, Architecture Audit, Code Quality and QA, and App Demo.

Team Roster
Name	Student ID	Role
Jeremiah Mulungi	23/2/314/WJ/230	Lead Developer / UI-UX Specialist / Git and QA Manager / Testing Engineer / Documentation Lead

The Problem
Students at Ndejje University Kampala Campus frequently leave campus hungry, not from a lack of food, but from a lack of knowledge about where to find affordable, reliable food nearby. Food spots are scattered, undiscovered, and unevenly distributed around the campus area.
The Solution
Tooke maps all known food spots near Ndejje Kampala Campus with what each spot sells, current open/closed status, distance from campus, price range in UGX, student ratings, and search and filter by food category.

Feature Set
Browse all food spots near Ndejje Kampala Campus
Search by food name, spot name, or location
Filter by category: Rolex, Local Meal, Snacks, Beverages, Mixed
View detailed spot information including menu, price, distance, and rating
Open/Closed status indicator per spot
Material 3 design with full Dark Mode support
Custom Tooke brand identity using green and earth tones inspired by Matooke leaves
3-screen navigation: Home, Detail, About

Technical Stack
Layer	Technology
Language	Kotlin
UI Framework	Jetpack Compose
Architecture	MVVM (Model-View-ViewModel)
State Management	StateFlow + collectAsState
Navigation	Navigation Compose (3 screens)
Design System	Material 3
Data Layer	Static DataSource (FoodSpotDataSource)
Testing	JUnit4 Unit Tests
Build System	Gradle (Kotlin DSL)
---
QA Summary
Testing and QA conducted by: Jeremiah Mulungi
#	Test Case	Description	Expected Result	Actual Result	Status
1	Initial State Load	ViewModel loads all spots on init	allSpots is not empty and filteredSpots equals allSpots	Passed	Pass
2	Search by Food Name	Searching "rolex" filters relevant spots	Only rolex-related spots returned	Passed	Pass
3	Category Filter	Selecting ROLEX category filters correctly	Only ROLEX category spots shown	Passed	Pass
4	Clear Category Filter	Setting category to null restores all spots	All spots visible again	Passed	Pass
5	Get Spot By ID	getSpotById(1) returns correct spot	Spot with id 1 returned	Passed	Pass
6	Invalid Spot ID	getSpotById(9999) returns null	null returned, no crash	Passed	Pass
7	Empty Search Query	Clearing search restores all spots	All spots visible again	Passed	Pass
7 of 7 tests passing.

Project Structure

app/src/main/java/com/tooke/app/
    MainActivity.kt
    model/
        FoodSpot.kt
    data/
        FoodSpotDataSource.kt
    viewmodel/
        FoodSpotViewModel.kt
    ui/
        TookeApp.kt
        theme/
            Theme.kt
        screens/
            HomeScreen.kt
            DetailScreen.kt
            AboutScreen.kt
app/src/test/java/com/tooke/app/
    FoodSpotViewModelTest.kt




Architecture


UI Layer (Compose Screens)
        collectAsState()
ViewModel Layer (FoodSpotViewModel)
        reads from
Data Layer (FoodSpotDataSource)
        returns
Model Layer (FoodSpot, FoodCategory)


State flows unidirectionally. MainActivity only sets content. All logic lives in ViewModel, screens, and data layers as required by the brief.



 Design Decisions

* Color palette: Deep greens (#2D6A4F) inspired by matooke leaves, warm earth accents for cultural grounding
* Dark Mode: Full Material 3 dark color scheme, tested and verified
* Typography: Material 3 default type scale, no hardcoded sizes in UI components
* Brand name: Tooke, short for Matooke, Uganda's staple green banana



Built for Solutions for a Digital Uganda | Mobile Programming BIT 2205 | Ndejje University 2025/2026
