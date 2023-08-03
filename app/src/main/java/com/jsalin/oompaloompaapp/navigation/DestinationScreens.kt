package com.jsalin.oompaloompaapp.navigation

import com.jsalin.oompaloompaapp.util.DETAIL_SCREEN
import com.jsalin.oompaloompaapp.util.HOME_SCREEN

sealed class DestinationScreens(val route: String) {
    object Home: DestinationScreens(HOME_SCREEN)
    object Detail: DestinationScreens(DETAIL_SCREEN)
}