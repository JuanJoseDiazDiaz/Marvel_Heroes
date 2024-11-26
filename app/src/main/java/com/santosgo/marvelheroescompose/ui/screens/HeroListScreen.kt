package com.santosgo.marvelheroescompose.ui.screens

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ExtendedColorScheme
import com.example.compose.extendedDark
import com.example.compose.extendedLight
import com.example.ui.theme.AppTypography
import com.santosgo.marvelheroescompose.R
import com.santosgo.marvelheroescompose.model.Hero
import com.santosgo.marvelheroescompose.ui.components.HeroCard
import com.santosgo.marvelheroescompose.ui.components.StandardTextComp
import com.santosgo.mavelheroes.data.Datasource

@Composable
fun HeroListScreen(heroes: MutableList<Hero>, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Surface(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            shadowElevation = 2.dp,
            shape = MaterialTheme.shapes.medium,
            color = Color.Red
        ) {
            StandardTextComp(
                text = stringResource(R.string.marvel_hero_list),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
        }

        LazyColumn(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            items(heroes) { hero ->
               HeroCard(hero)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HeroListScreenPreview() {
    HeroListScreen(Datasource.heroList())
}
val LocalExtendedColorScheme = staticCompositionLocalOf {
    extendedLight //tomar cualquiera de los creados como referencia.
}

@Composable
fun MarvelHeroesComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> extendedDark
        else -> extendedLight
    }

    val extendedColorScheme = when {
        darkTheme -> extendedDark
        else -> extendedLight
    }

    CompositionLocalProvider(LocalExtendedColorScheme provides extendedColorScheme) {
        MaterialTheme(
            colorScheme = colorScheme as ColorScheme,
            typography = AppTypography,
            content = content
        )
    }
}

@Composable
fun MedHeaderComp(title: String) {
    val extendedColorScheme = LocalExtendedColorScheme.current
    Surface(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .fillMaxWidth(),
        shadowElevation = 2.dp,
        shape = MaterialTheme.shapes.medium,
        color = extendedColorScheme.customHeader.color,
        contentColor = extendedColorScheme.customHeader.onColor
    ) {

    }
}