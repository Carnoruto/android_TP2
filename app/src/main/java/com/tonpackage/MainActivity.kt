package com.tonpackage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tonpackage.data.NinjaRepository
import com.tonpackage.data.local.AppDatabase
import com.tonpackage.datastore.SettingsDataStore
import com.tonpackage.ui.NarutoScreen
import com.tonpackage.ui.NinjaViewModel
import com.tonpackage.ui.NinjaViewModelFactory
import com.tonpackage.ui.theme.NarutoUniverseTheme
import kotlinx.coroutines.launch
import androidx.compose.runtime.collectAsState

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val context = LocalContext.current
            val scope = rememberCoroutineScope()

            val dataStore = remember { SettingsDataStore(context) }
            val isDarkMode by dataStore.isDark.collectAsState(initial = false)

            val db = remember { AppDatabase.getDatabase(context) }
            val repo = remember { NinjaRepository(db.ninjaDao()) }

            val viewModel: NinjaViewModel = viewModel(
                factory = NinjaViewModelFactory(repo)
            )

            NarutoUniverseTheme(darkTheme = isDarkMode) {
                NarutoScreen(
                    viewModel = viewModel,
                    isDarkMode = isDarkMode,
                    onToggleTheme = {
                        scope.launch {
                            dataStore.saveDark(!isDarkMode)
                        }
                    }
                )
            }
        }
    }
}