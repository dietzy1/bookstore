package dk.howards.drawerapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dk.howards.drawerapp.R
import dk.howards.drawerapp.model.BookOverview
import dk.howards.drawerapp.model.Genre
import dk.howards.drawerapp.ui.theme.DrawerAppTheme

@Composable
fun BookItem(book: BookOverview, onItemClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onItemClick(book.id) },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .width(80.dp)
                    .height(120.dp)
                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)),
                painter = painterResource(id = book.coverImageId),
                contentDescription = book.title,
                contentScale = ContentScale.Fit
            )
            
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            ) {
                Text(
                    text = book.title,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                )
                
                Text(
                    text = "By ${book.author}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                )
                
                Text(
                    text = "Genre: ${book.genre.name.replace("_", " ")}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                )
                
                Text(
                    text = "Published: ${book.releaseYear}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun BookItemPreview() {
    DrawerAppTheme {
        val book = BookOverview(
            "1",
            "The Great Gatsby",
            "F. Scott Fitzgerald",
            Genre.FICTION,
            1925,
            R.drawable.gatsby
        )
        BookItem(book = book, onItemClick = {})
    }
} 