package com.ramazanpeker.dictionary.feature_dictionary.presentation

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramazanpeker.dictionary.feature_dictionary.domain.model.WordInfo

@Composable
fun WordInfoItem(
    wordInfo: WordInfo,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        wordInfo.let { wordInfo ->
wordInfo.word?.let { word ->
    Text(
        text =word,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black
    )
}

            wordInfo.phonetic?.let { phonetic->
                Text(
                    text = phonetic,
                    fontWeight = FontWeight.Light
                )
            }


            Spacer(modifier = modifier.height(16.dp))
            wordInfo.meanings?.forEach { meaning ->
                Text(text = meaning.partOfSpeech, fontWeight = FontWeight.Bold)
                meaning.definitions.forEachIndexed { i, definition ->
                    Text(text = "${i + 1}. ${definition.definition}")
                    Spacer(modifier = modifier.height(8.dp))
                    definition.example?.let {
                        Text(text = "Example: $it")
                    }
                    Spacer(modifier = modifier.height(8.dp))
                }
                Spacer(modifier = modifier.height(16.dp))

            }
        }
    }

}