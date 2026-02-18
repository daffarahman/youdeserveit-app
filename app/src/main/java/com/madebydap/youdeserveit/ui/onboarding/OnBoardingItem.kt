package com.madebydap.youdeserveit.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madebydap.youdeserveit.model.OnBoardingModel
import com.madebydap.youdeserveit.ui.theme.instrumentSerif
import com.madebydap.youdeserveit.ui.theme.nunitoSans

@Composable
fun OnBoardingItem(page: OnBoardingModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = page.imageRes),
            contentDescription = page.title,
            modifier = Modifier
                .height(240.dp)
                .width(240.dp)
                .padding(bottom = 20.dp)
        )
        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
            style = TextStyle(
                fontFamily = instrumentSerif,
                fontSize = 32.sp,
                fontWeight = FontWeight.W400,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
            )
        )
        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
            style = TextStyle(
                fontFamily = nunitoSans,
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
            )
        )
    }
}