package com.santosgo.marvelheroescompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.santosgo.marvelheroescompose.ui.components.StandardTextComp
import com.santosgo.marvelheroescompose.ui.screens.HeroListScreen
import com.santosgo.marvelheroescompose.ui.screens.MarvelHeroesComposeTheme
import com.santosgo.mavelheroes.data.Datasource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MarvelHeroesComposeTheme {
               MarvelHeroesApp()
            }
        }
    }
}
@Composable
fun MarvelHeroesApp() {
    // Crear la lista de héroes y añadir duplicados para probar el desplazamiento
    val heroes = Datasource.getListXtimes(4)

    MarvelHeroesComposeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            HeroListScreen(heroes, Modifier.padding(innerPadding))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeroListPreview() {
    MarvelHeroesComposeTheme {
       MarvelHeroesApp()
    }
}