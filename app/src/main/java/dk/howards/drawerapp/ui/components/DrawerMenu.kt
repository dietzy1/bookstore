package dk.howards.drawerapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dk.howards.drawerapp.model.MenuItemModel
import kotlinx.coroutines.launch

@Composable
fun DrawerMenu(
    menuItemModels: List<MenuItemModel>,
    content: @Composable () -> Unit = {}
) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    Column {
        Row {
            TopBar(title = "Open menu",
            ) {
                scope.launch {
                    drawerState.open()
                }
            }
        }
        Row {
            Drawer(
                menuItems = menuItemModels,
                drawerState = drawerState,
                content = content
            )
        }
    }
}
