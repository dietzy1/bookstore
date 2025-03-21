# BookStore App

A mobile application for browsing and exploring books, built with Kotlin and Jetpack Compose.

## Features

This app meets the required specifications by implementing:

1. **Front View with Menu**: The main screen features a navigation drawer menu allowing users to select different book categories.
2. **List View**: When a user selects a category from the menu, a list of books in that category is displayed.
3. **Detail View**: When a user selects a book from the list, a detailed view of the book is shown with comprehensive information.

## App Structure

- Each view is implemented as a separate Activity, following the assignment requirements
- The app uses a repository pattern to manage book data
- Clean separation between UI components and data logic

## Navigation

- The main screen contains a drawer menu for navigating between book categories
- The book list screens have a back button to return to the main screen
- The book detail screen has a back button to return to the list screen

## Data Handling

The app uses a Repository class to provide mock data for the bookstore. In a real application, this would connect to a database or API.

## UI Components

- **DrawerMenu**: The navigation drawer menu
- **BookItem**: Component for displaying book summaries in the list
- **BookDetail**: Screen for displaying comprehensive book information

## Screens

1. **Home**: The main screen with welcome message and instructions
2. **BooksActivity**: Shows a list of all books
3. **GenreBooksActivity**: Shows books filtered by genre
4. **BookDetailActivity**: Shows detailed information about a selected book

## How to Use

1. Launch the app
2. Use the menu button in the top-left to open the drawer menu
3. Select a book category or "All Books"
4. Browse the list of books
5. Tap on a book to view its details
6. Use the back button to navigate to previous screens 