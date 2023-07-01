package com.example.githubsearchcompose.features.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.githubsearchcompose.R

@Composable
fun SearchBar(
    onTextChange: (text: String) -> Unit,
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val searchValue = rememberSaveable { mutableStateOf("") }
    Box(
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
            .clip(shape = RoundedCornerShape(16.dp))
    ) {
        TextField(
            value = searchValue.value,
            onValueChange = {
                searchValue.value = it
                onTextChange(it)
            },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search_hint),
                    color = Color.Black,
                    fontSize = 14.sp
                )
            },
            leadingIcon = {
                IconButton(
                    onClick = onSearchClick
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = null
                    )
                }
            },
            modifier = Modifier
                .requiredHeight(56.dp)
                .fillMaxWidth()
                .background(Color.White)
        )
    }
}

@Preview
@Composable
private fun PreviewSearchBar() {
    SearchBar(
        onTextChange = {},
        onSearchClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .height(40.dp)
    )
}