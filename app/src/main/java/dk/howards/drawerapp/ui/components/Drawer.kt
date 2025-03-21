package dk.howards.drawerapp.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dk.howards.drawerapp.R
import dk.howards.drawerapp.model.MenuItemModel
import dk.howards.drawerapp.ui.theme.DrawerAppTheme
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
                drawerContentColor = Color.Cyan,
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
        //scrimColor = Color.Blue,
        content = content

    )
}



