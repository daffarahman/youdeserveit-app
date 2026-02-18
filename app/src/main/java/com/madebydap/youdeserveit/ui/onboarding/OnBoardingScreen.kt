package com.madebydap.youdeserveit.ui.onboarding

import android.content.IntentSender
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.madebydap.youdeserveit.model.onBoardingList
import kotlinx.coroutines.launch
import androidx.compose.material3.Button
import androidx.compose.material3.TextButton
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.madebydap.youdeserveit.ui.theme.instrumentSerif

@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    onFinished: () -> Unit
) {
    val pagerState = rememberPagerState { onBoardingList.size }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Welcome",
            modifier = Modifier
                .padding(top = 128.dp)
                .align(Alignment.CenterHorizontally),
            style = TextStyle(
                fontFamily = instrumentSerif,
                fontSize = 48.sp,
                fontWeight = FontWeight.W300,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
            )
        )

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) { page ->
            OnBoardingItem(onBoardingList[page])
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        ) {
            TextButton(
                onClick = {
                    val skipPage = pagerState.pageCount - 1
                    coroutineScope.launch { pagerState.animateScrollToPage(skipPage) }
                }
            ) {
                Text(
                    text = "Skip",
                    style = MaterialTheme.typography.labelLarge.copy(
                        color = MaterialTheme.colorScheme.secondary
                    )
                )
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f)
            ) {
                repeat(onBoardingList.size) { index ->
                    val isSelected = pagerState.currentPage == index
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .width(if (isSelected) 18.dp else 8.dp)
                            .height(8.dp)
                            .background(
                                color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant,
                                shape = CircleShape
                            )
                    )
                }
            }

            Button(
                onClick = {
                    if (pagerState.currentPage < onBoardingList.size - 1) {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    } else {
                        // Handle "Get Started" logic here
                        onFinished()
                    }
                },
            ) {
                Text(
                    text = if (pagerState.currentPage == onBoardingList.size - 1) "Get Started" else "Next",
                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
                )
            }
        }
    }
}