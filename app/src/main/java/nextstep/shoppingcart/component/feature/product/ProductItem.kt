package nextstep.shoppingcart.component.feature.product

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.component.core.image.ProductImage
import nextstep.shoppingcart.component.core.image.ProductImageRatioType
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.util.getLocalCurrencyFormat
import java.util.Locale


/**
 * 쇼핑카트 상품목록 상품 아이템
 **/
@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    productThumbnail:String,
    productTitle: String,
    productPrice: Long,
    onItemClick: () -> Unit = {},
) {
    Column(
        modifier = modifier.clickable {
            onItemClick()
        },
    ) {
        ProductImage(
            productThumbnail = productThumbnail,
            imageRatio = ProductImageRatioType.SHOPPING_ITEM_THUMBNAIL_RATIO,
        )
        Text(
            modifier = Modifier.padding(start = 5.dp),
            text = productTitle,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight(700),
            color = Color.Black,
            fontSize = 16.sp,
            maxLines = 1,
        )
        Text(
            modifier = Modifier.padding(start = 5.dp),
            text = productPrice.getLocalCurrencyFormat(locale = Locale.KOREA),
            fontWeight = FontWeight(400),
            color = Color.Black,
            fontSize = 16.sp,
            maxLines = 1,
        )
    }
}

/**
 * ShoppingItem 프리뷰 함수
 */
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFFL
)
@Composable
fun ProductItemPreview() {
    ShoppingCartTheme {
        ProductItem(
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(),
            productThumbnail = "https://picsum.photos/200/300",
            productTitle = "상품명",
            productPrice = 100000,
        )
    }
}
