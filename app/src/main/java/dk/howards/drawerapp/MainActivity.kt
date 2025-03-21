package dk.howards.drawerapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import dk.howards.drawerapp.model.Genre
import dk.howards.drawerapp.model.MenuItemModel
import dk.howards.drawerapp.ui.components.DrawerMenu
import dk.howards.drawerapp.ui.screens.Home
import dk.howards.drawerapp.ui.theme.DrawerAppTheme

class MainActivity : ComponentActivity() {

    private val menuItemModels = listOf(
        MenuItemModel(
            "1",
            "All Books",
            Icons.Default.Info,
            "Browse all books"
        ) {
            val intent = Intent(this, BooksActivity::class.java)
            startActivity(intent)
            Log.v("Drawer", "click All Books")
        },
        MenuItemModel(
            "2",
            "Fiction",
            Icons.Default.Favorite,
            "Fiction books"
        ) {
            val intent = Intent(this, GenreBooksActivity::class.java).apply {
                putExtra("GENRE", Genre.FICTION.name)
            }
            startActivity(intent)
            Log.v("Drawer", "click Fiction")
        },
        MenuItemModel(
            "3",
            "Science Fiction",
            Icons.Default.Search,
            "Science Fiction books"
        ) {
            val intent = Intent(this, GenreBooksActivity::class.java).apply {
                putExtra("GENRE", Genre.SCIENCE_FICTION.name)
            }
            startActivity(intent)
            Log.v("Drawer", "click Science Fiction")
        },
        MenuItemModel(
            "4",
            "Fantasy",
            Icons.Default.List,
            "Fantasy books"
        ) {
            val intent = Intent(this, GenreBooksActivity::class.java).apply {
                putExtra("GENRE", Genre.FANTASY.name)
            }
            startActivity(intent)
            Log.v("Drawer", "click Fantasy")
        },
        MenuItemModel(
            "5",
            "Romance",
            Icons.Default.Favorite,
            "Romance books"
        ) {
            val intent = Intent(this, GenreBooksActivity::class.java).apply {
                putExtra("GENRE", Genre.ROMANCE.name)
            }
            startActivity(intent)
            Log.v("Drawer", "click Romance")
        },
        MenuItemModel(
            "6",
            "Mystery",
            Icons.Default.Warning,
            "Mystery books"
        ) {
            val intent = Intent(this, GenreBooksActivity::class.java).apply {
                putExtra("GENRE", Genre.MYSTERY.name)
            }
            startActivity(intent)
            Log.v("Drawer", "click Mystery")
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrawerAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DrawerMenu(menuItemModels) {
                        Home()
                    }
                }
            }
        }
    }
}

