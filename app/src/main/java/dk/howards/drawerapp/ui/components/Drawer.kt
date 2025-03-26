package dk.howards.drawerapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import dk.howards.drawerapp.model.MenuItemModel

import kotlinx.coroutines.launch

@Composable
fun Drawer(
    menuItems: List<MenuItemModel>,
    drawerState: DrawerState,
    content: @Composable () -> Unit
) {
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = MaterialTheme.colorScheme.onBackground,
                drawerContentColor = MaterialTheme.colorScheme.onSurface,
            ) {
                Box {
                    Box(modifier = Modifier.padding(top = 120.dp)) {
                        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                            menuItems.map {
                                MenuItem(model = it.copy(onClick = {
                                    scope.launch {
                                        it.onClick()
                                        drawerState.close()
                                    }
                                }))
                            }
                        }
                    }
                }
            }
        },
        gesturesEnabled = true,
        content = content

    )
}



