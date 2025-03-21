package dk.howards.drawerapp

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
import dk.howards.drawerapp.repository.BookRepository
import dk.howards.drawerapp.ui.screens.BookDetail
import dk.howards.drawerapp.ui.theme.DrawerAppTheme

class BookDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Get the book ID from the intent
        val bookId = intent.getStringExtra("BOOK_ID") ?: ""
        val book = BookRepository.getBookById(bookId)
        
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
                        BookDetail(book = book)
                    }
                }
            }
        }
    }
} 