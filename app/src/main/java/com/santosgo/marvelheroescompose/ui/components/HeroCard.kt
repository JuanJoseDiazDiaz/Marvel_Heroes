package com.santosgo.marvelheroescompose.ui.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.twotone.Favorite
import androidx.compose.material.icons.twotone.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.santosgo.marvelheroescompose.R
import com.santosgo.marvelheroescompose.model.Hero
import com.santosgo.mavelheroes.data.Datasource

@Composable
fun HeroCard2(hero: Hero, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            // Imagen del héroe
            ImageComp(
                modifier = Modifier,
                drawable = Datasource.getDrawableIdByName(hero.photo),
                height = 100,
                width = 100
            )

            // Columna con el nombre y atributos del héroe
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                StandardTextComp(
                    text = hero.name,
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                StandardTextComp(
                    text = "Poder: ${hero.power}",
                    style = MaterialTheme.typography.bodyMedium
                )
                StandardTextComp(
                    text = "Inteligencia: ${hero.intelligence}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Column {
                IconButton(
                    onClick = { /* Acción futura, como mostrar más información del héroe */ },
                    modifier = Modifier.size(48.dp)
                ) {

                    Icon(
                        imageVector = Icons.TwoTone.Favorite,
                        modifier = Modifier.size(48.dp),
                        contentDescription = stringResource(R.string.more_content_desc),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                // Botón de acción con ícono
                IconButton(
                    onClick = { /* Acción futura, como mostrar más información del héroe */ },
                    modifier = Modifier.size(48.dp)
                ) {

                    Icon(
                        imageVector = Icons.TwoTone.KeyboardArrowDown,
                        modifier = Modifier.size(48.dp),
                        contentDescription = stringResource(R.string.more_content_desc),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Composable
fun HeroCardLand(hero: Hero) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp),
        shape = MaterialTheme.shapes.large
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            // Imagen del héroe
            ImageComp(
                modifier = Modifier,
                drawable = Datasource.getDrawableIdByName(hero.photo),
                height = 100,
                width = 100
            )

            // Columna con el nombre y atributos del héroe
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Bottom
                ) {
                    StandardTextComp(
                        text = hero.name,
                        style = MaterialTheme.typography.headlineMedium
                    )
                    StandardTextComp(
                        text = "Poder: ${hero.power}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    StandardTextComp(
                        text = "Inteligencia: ${hero.intelligence}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                StandardTextComp(
                    text = stringResource(R.string.hero_description, hero.description),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
    }
}

@Composable
fun FavHeroCard(hero: Hero, heroes: MutableList<Hero>, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            // Imagen del héroe
            ImageComp(
                modifier = Modifier,
                drawable = Datasource.getDrawableIdByName(hero.photo),
                height = 100,
                width = 100
            )

            // Columna con el nombre y atributos del héroe
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                StandardTextComp(
                    text = hero.name,
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                StandardTextComp(
                    text = stringResource(R.string.power, hero.power),
                    style = MaterialTheme.typography.bodyMedium
                )
                StandardTextComp(
                    text = stringResource(R.string.intelligence, hero.intelligence),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Column(verticalArrangement = Arrangement.SpaceAround) {
                // Botón de acción con ícono
                IconButton(
                    onClick = {
//                      heroes.removeIf()
                    },
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        modifier = Modifier.size(48.dp),
                        contentDescription = stringResource(R.string.delete_desc),
                        tint = MaterialTheme.colorScheme.error
                    )
                }
                // Botón de acción con ícono
                IconButton(
                    onClick = { Log.d("FavHeroCard", "Botón \"mostrar más\" pulsado") },
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        modifier = Modifier.size(48.dp),
                        contentDescription = stringResource(R.string.more_content_desc),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Composable
fun FavHeroCardLand(hero: Hero) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp),
        shape = MaterialTheme.shapes.large
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            // Imagen del héroe
            ImageComp(
                modifier = Modifier,
                drawable = Datasource.getDrawableIdByName(hero.photo),
                height = 150,
                width = 150
            )

            // Columna con el nombre y atributos del héroe
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Bottom
                ) {
                    StandardTextComp(
                        text = hero.name,
                        style = MaterialTheme.typography.headlineMedium
                    )
                    StandardTextComp(
                        text = stringResource(R.string.power, hero.power),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    StandardTextComp(
                        text = stringResource(R.string.intelligence, hero.intelligence),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    IconButton(
                        onClick = {
                            Log.d(
                                "FavHeroCard",
                                "Botón favorito pulsado"
                            )
                        }, //incluir el héroe en favoritos
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Clear,
                            modifier = Modifier.size(48.dp),
                            contentDescription = stringResource(R.string.delete_desc),
                            tint = MaterialTheme.colorScheme.error
                        )
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                StandardTextComp(
                    text = stringResource(R.string.hero_description, hero.description),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
    }
}