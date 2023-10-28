package com.ashana.ui.model.cryptocurrency.presentation.feature.coin_details.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.ashana.ui.model.cryptocurrency.data.remote.dto.TeamMember

@Composable
internal fun TeamMember(
    teamMember: TeamMember,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = teamMember.name,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = teamMember.position,
            style = MaterialTheme.typography.bodyMedium,
            fontStyle = FontStyle.Italic
        )
    }
}
