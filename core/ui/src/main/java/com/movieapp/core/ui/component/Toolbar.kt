package com.movieapp.core.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.movieapp.core.viewmodels.enums.SortType

@Composable
fun MovieToolbar(
    title: String,
    sortType: SortType,
    onSortSelected: (sortType: SortType) -> Unit,
    showDropdown: Boolean,
    onDropdownShown: (Boolean) -> Unit,
) {
    TopAppBar(
        title = { Text(text = title) },
        backgroundColor = Color.White,
        elevation = 4.dp,
        actions = {
            IconButton(onClick = { onDropdownShown(true) }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Sort",
                )
            }
            DropdownMenu(
                expanded = showDropdown,
                onDismissRequest = { onDropdownShown(false) },
            ) {
                DropdownMenuItem(
                    onClick = {
                        onSortSelected(SortType.MOST_POPULAR)
                        onDropdownShown(false)
                    },
                    content = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            if (sortType == SortType.MOST_POPULAR) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Selected",
                                    tint = MaterialTheme.colors.primary,
                                )
                            }
                            Text(text = SortType.MOST_POPULAR.title)
                        }
                    },
                )
                DropdownMenuItem(
                    onClick = {
                        onSortSelected(SortType.TOP_RATED)
                        onDropdownShown(false)
                    },
                    content = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            if (sortType == SortType.TOP_RATED) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Selected",
                                    tint = MaterialTheme.colors.primary,
                                )
                            }
                            Text(text = SortType.TOP_RATED.title)
                        }
                    },
                )
            }
        },
    )
}
