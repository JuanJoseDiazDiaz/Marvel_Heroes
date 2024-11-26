package com.santosgo.marvelheroescompose.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
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
fun HeroCard(hero: Hero) {
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