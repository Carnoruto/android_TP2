package com.tonpackage

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tonpackage.model.Ninja
import com.tonpackage.R

@Composable
fun NarutoApp(
    isDarkMode: Boolean,
    onToggleTheme: () -> Unit
) {

    var showNarutoList by remember { mutableStateOf(true) }

    val narutoList = listOf(
        Ninja(1, "Naruto Uzumaki", "Hokage", R.drawable.naruto),
        Ninja(2, "Sasuke Uchiha", "Ninja Déserteur", R.drawable.sasuke),
        Ninja(3, "Sakura Haruno", "Ninja Médecin", R.drawable.sakura),
        Ninja(4, "Kakashi Hatake", "Ninja Mimique", R.drawable.kakashi),
        Ninja(5, "Madara Uchiha", "Akatsuki", R.drawable.madara),
    )

    val borutoList = listOf(
        Ninja(6, "Boruto Uzumaki", "Genin", R.drawable.boruto),
        Ninja(7, "Sarada Uchiha", "Sharingan", R.drawable.sarada),
        Ninja(8, "Kawaki", "Karma", R.drawable.kawaki),
        Ninja(9, "Kashin Koji", "Sage", R.drawable.kashin),
        Ninja(10, "Isshiki Otsutsuki", "Alien", R.drawable.isshiki)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("L'Univers de Naruto", style = MaterialTheme.typography.titleLarge)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Selectionner votre Shinobi!")
            Switch(
                checked = isDarkMode,
                onCheckedChange = { onToggleTheme() }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { showNarutoList = !showNarutoList }) {
            Text(if (showNarutoList) "Voir Boruto" else "Voir Naruto")
        }

        Spacer(modifier = Modifier.height(12.dp))

        val currentList = if (showNarutoList) narutoList else borutoList

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(currentList) { ninja ->
                NinjaCard(ninja)
            }
        }
    }
}

@Composable
fun NinjaCard(ninja: Ninja) {

    var expanded by remember { mutableStateOf(false) }
    var chakra by remember { mutableStateOf(50) }

    val maxChakra = 100

    val animatedProgress by animateFloatAsState(
        targetValue = chakra / maxChakra.toFloat(),
        label = "chakraAnimation"
    )

    val chakraColor =
        if (chakra <= 20) MaterialTheme.colorScheme.error
        else MaterialTheme.colorScheme.primary

    Card(
        onClick = { expanded = !expanded },
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Image(
                painter = painterResource(id = ninja.imageRes),
                contentDescription = ninja.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(ninja.title, style = MaterialTheme.typography.titleLarge)
            Text(ninja.subtitle)

            Spacer(modifier = Modifier.height(12.dp))

            Text("Chakra : $chakra / $maxChakra")

            Spacer(modifier = Modifier.height(6.dp))

            LinearProgressIndicator(
                progress = animatedProgress,
                modifier = Modifier.fillMaxWidth(),
                color = chakraColor
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {

                Button(
                    onClick = { if (chakra < maxChakra) chakra += 10 }
                ) {
                    Text("+10")
                }

                Button(
                    onClick = { if (chakra > 0) chakra -= 10 },
                    enabled = chakra > 0
                ) {
                    Text("-10")
                }
            }

            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text("Ninja ID: ${ninja.id}")
            }
        }
    }
}