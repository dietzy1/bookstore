package dk.howards.drawerapp.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import dk.howards.drawerapp.model.MenuItemModel
import dk.howards.drawerapp.ui.theme.DrawerAppTheme
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
            TopBar(title = "My Cool App") {
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
