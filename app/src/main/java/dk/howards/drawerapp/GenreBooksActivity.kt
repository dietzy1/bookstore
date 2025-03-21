package dk.howards.drawerapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import dk.howards.drawerapp.model.Genre
import dk.howards.drawerapp.repository.BookRepository
import dk.howards.drawerapp.ui.screens.BookList
import dk.howards.drawerapp.ui.theme.DrawerAppTheme

class GenreBooksActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Get the genre from the intent
        val genreName = intent.getStringExtra("GENRE") ?: ""
        val genre = try {
            Genre.valueOf(genreName)
        } catch (e: Exception) {
            null
        }
        
        setContent {
            DrawerAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Button(onClick = { finish() }) {
                            Text(
                                text = "Back",
                                style = TextStyle(color = MaterialTheme.colorScheme.onSurface)
                            )
                        }
                        
                        if (genre != null) {
                            BookList(
                                title = "${genre.name} Books",
                                books = BookRepository.getBooksByGenre(genre)
                            ) { bookId ->
                                val intent = Intent(this@GenreBooksActivity, BookDetailActivity::class.java).apply {
                                    putExtra("BOOK_ID", bookId)
                                }
                                startActivity(intent)
                            }
                        } else {
                            // If genre is invalid, show all books
                            BookList(
                                title = "All Books",
                                books = BookRepository.getAllBooks()
                            ) { bookId ->
                                val intent = Intent(this@GenreBooksActivity, BookDetailActivity::class.java).apply {
                                    putExtra("BOOK_ID", bookId)
                                }
                                startActivity(intent)
                            }
                        }
                    }
                }
            }
        }
    }
} 