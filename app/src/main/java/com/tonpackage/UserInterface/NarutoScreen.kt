package com.tonpackage.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import com.tonpackage.R
import com.tonpackage.data.local.NinjaEntity

@Composable
fun NarutoScreen(
    viewModel: NinjaViewModel,
    isDarkMode: Boolean,
    onToggleTheme: () -> Unit
) {

    val ninjas by viewModel.ninjas.collectAsState()
    var search by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        // 🔥 BACKGROUND
        Image(
            painter = painterResource(id = R.drawable.background_konoha),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            // 🔥 HEADER
            Text(
                text = "🌀 Naruto Universe",
                style = MaterialTheme.typography.titleLarge
            )

            Row {
                Text("Mode sombre")
                Switch(
                    checked = isDarkMode,
                    onCheckedChange = { onToggleTheme() }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 🔍 SEARCH
            TextField(
                value = search,
                onValueChange = {
                    search = it
                    viewModel.setSearch(it)
                },
                label = { Text("Rechercher un ninja") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            // 🔥 BOUTON AJOUT LISTE
            Button(
                onClick = { viewModel.addDefaultNinjas() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ajouter les ninjas")
            }

            // 🔥 BOUTON SUPPRIME LISTE
            Button(
                onClick = { viewModel.deleteAllNinjas() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Supprimer tous les ninjas")
            }

            Spacer(modifier = Modifier.height(10.dp))

            // 📜 LISTE
            LazyColumn {
                items(ninjas) { ninja ->
                    NinjaCard(ninja, viewModel)
                }
            }
        }
    }
}

fun getNinjaImage(name: String): Int {
    return when (name.lowercase()) {
        "naruto" -> R.drawable.naruto
        "sasuke" -> R.drawable.sasuke
        "sakura" -> R.drawable.sakura
        "kakashi" -> R.drawable.kakashi
        "madara" -> R.drawable.madara
        "boruto" -> R.drawable.boruto
        "sarada" -> R.drawable.sarada
        "kawaki" -> R.drawable.kawaki
        "isshiki" -> R.drawable.isshiki
        "kashin koji" -> R.drawable.kashin
        else -> R.drawable.naruto // fallback
    }
}

@Composable
fun NinjaCard(
    ninja: NinjaEntity,
    viewModel: NinjaViewModel
) {

    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .animateContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {

        Column(modifier = Modifier.padding(12.dp)) {

            Row {

                // 🔥 IMAGE (tu peux améliorer plus tard)
                Image(
                    painter = painterResource(id = getNinjaImage(ninja.name)),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Column {
                    Text(
                        text = ninja.name,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text("Village: ${ninja.village}")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 🔥 BARRE CHAKRA
            LinearProgressIndicator(
                progress = ninja.chakra / 100f,
                modifier = Modifier.fillMaxWidth()
            )

            Text("Chakra: ${ninja.chakra}")

            Spacer(modifier = Modifier.height(8.dp))

            // 🔥 ACTIONS
            Row {

                Button(onClick = {
                    viewModel.updateNinja(
                        ninja.copy(chakra = (ninja.chakra + 10).coerceAtMost(100))
                    )
                }) { Text("+") }

                Spacer(modifier = Modifier.width(5.dp))

                Button(onClick = {
                    viewModel.updateNinja(
                        ninja.copy(chakra = (ninja.chakra - 10).coerceAtLeast(0))
                    )
                }) { Text("-") }

                Spacer(modifier = Modifier.width(5.dp))

                Button(onClick = {
                    viewModel.deleteNinja(ninja)
                }) { Text("X") }
            }

            TextButton(onClick = { expanded = !expanded }) {
                Text("Détails")
            }

            if (expanded) {
                Text("Ninja puissant du village ${ninja.village}")
            }
        }
    }
}