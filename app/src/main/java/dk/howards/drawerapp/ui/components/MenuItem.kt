package dk.howards.drawerapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import dk.howards.drawerapp.model.MenuItemModel
import dk.howards.drawerapp.ui.theme.DrawerAppTheme

@Composable
fun MenuItem(model: MenuItemModel) {
    NavigationDrawerItem(
        modifier = Modifier,
        label = {
            Text(
                text = model.title,
                style = TextStyle(color = Color.Black)
            )
        },
        selected = false,
        onClick = {
            model.onClick()
        }
    )

}

@Preview
@Composable
fun MenuItemPreview() {
    DrawerAppTheme(darkTheme = true) {
        MenuItem(
            model = MenuItemModel(
                "1",
                "Home",
                "Home"
            ) { println("click") })
    }
}