package me.qingshu.kmpapp.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import kmpapplication.composeapp.generated.resources.Res
import kmpapplication.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun TopBar() {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 4.dp,
        shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            HeaderLeftSection()
            HeaderNavigation()
            HeaderAuthActions()
        }
    }
}

@Composable
private fun HeaderLeftSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {}
    ) {
        Image(
            painter = painterResource(Res.drawable.compose_multiplatform),
            contentDescription = "Logo",
            modifier = Modifier.size(48.dp),
        )
        Text(
            text = "CatMovie",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
private fun HeaderNavigation() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        listOf("Home", "Produces", "About", "Contact").forEach { item ->
            Text(
                text = item,
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier
                    .clickable {}
                    .hoverable(remember { MutableInteractionSource() })
                    .padding(8.dp)
            )
        }
    }
}

@Composable
private fun HeaderAuthActions() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedButton(
            onClick = {},
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = MaterialTheme.colors.primary
            )
        ) {
            Text("Sign In")
        }

        Button(
            onClick = {}
        ) {
            Text("Register")
        }
    }
}