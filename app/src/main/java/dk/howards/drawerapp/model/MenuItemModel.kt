package dk.howards.drawerapp.model

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItemModel(val id:String, val title:String, val icon:ImageVector, val contentDescription:String, val onClick:()->Unit)
