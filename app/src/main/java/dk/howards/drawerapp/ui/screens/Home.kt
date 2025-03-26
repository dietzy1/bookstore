package dk.howards.drawerapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dk.howards.drawerapp.R

@Composable
fun Home() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter =  painterResource(id = R.drawable.book_cover_placeholder),
            contentDescription = "Book cover",
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 16.dp)
            ,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary, BlendMode.SrcIn)
        )
        
        Text(
            text = "Welcome to Bookstore App",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        Text(
            text = "Discover your next favorite book",
            style = TextStyle(
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground
            ),
            modifier = Modifier.padding(bottom = 24.dp)
        )
        
        Text(
            text = "Use the menu to browse our collection by category or see all available books",
            style = TextStyle(
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center
            )
        )
    }
}