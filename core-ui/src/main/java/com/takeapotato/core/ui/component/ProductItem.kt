package com.takeapotato.core.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.takeapotato.core.ui.R
import com.takeapotato.core.ui.theme.*
import com.takeapotato.core.ui.util.dpToSp
import com.takeapotato.core.ui.util.toDecimal

@Composable
fun ProductItem(
    onClick: () -> Unit,
    title: String,
    imageUrl: String,
    remainTime: String,
    price: Int,
    titleMaxLine: Int = 1,
    isLike: Boolean,
    onLikeClick: (Boolean) -> Unit,
    tagBadge: (@Composable () -> Unit)? = null,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }) {
        Box(
            Modifier
                .fillMaxWidth()
                .aspectRatio(152f / 160f)
                .background(Gray100, shape = RoundedCornerShape(4.dp))
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentDescription = null,
            )

            Box(modifier = Modifier.padding(start = 8.dp, top = 8.dp)) {
                tagBadge?.invoke()
            }

        }
        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Text(
                text = title,
                style = TextStyle(
                    color = Gray700,
                    fontSize = dpToSp(dp = 14.dp),
                    lineHeight = dpToSp(dp = 16.8.dp),
                    fontWeight = FontWeight.Normal,
                ),
                maxLines = titleMaxLine,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 3.dp)
            )
            if (isLike) {
                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            onLikeClick(false)
                        },
                    painter = painterResource(id = R.drawable.ic_heart_fill),
                    contentDescription = "",
                    tint = PotatoYellow,
                )
            } else {
                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            onLikeClick(true)
                        },
                    painter = painterResource(id = R.drawable.ic_heart_line),
                    contentDescription = "",
                    tint = Gray300
                )
            }
        }
        Text(
            text = remainTime,
            style = TextStyle(
                color = Gray500,
                fontSize = dpToSp(dp = 12.dp),
                lineHeight = dpToSp(dp = 14.4.dp),
                fontWeight = FontWeight.Normal,
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.Top) {
            Text(
                text = price.toDecimal(),
                style = TextStyle(
                    color = Gray900,
                    fontSize = dpToSp(dp = 16.dp),
                    lineHeight = dpToSp(dp = 19.2.dp),
                    fontWeight = FontWeight.Bold,
                )
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "원",
                style = TextStyle(
                    color = Gray900,
                    fontSize = dpToSp(dp = 15.dp),
                    lineHeight = dpToSp(dp = 18.dp),
                    fontWeight = FontWeight.Medium,
                )
            )
        }
    }
}

@Preview
@Composable
private fun ProductItemPreview() {
    ProductItem(
        onClick = { },
        title = "",
        imageUrl = "",
        remainTime = "19일 4시간 26분 남음",
        price = 14000,
        onLikeClick = { },
        isLike = true
    )
}
