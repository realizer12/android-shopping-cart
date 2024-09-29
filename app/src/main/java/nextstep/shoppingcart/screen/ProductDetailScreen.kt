package nextstep.shoppingcart.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.component.core.button.AddCartButton
import nextstep.shoppingcart.component.core.image.ProductImage
import nextstep.shoppingcart.component.core.image.ProductImageRatioType
import nextstep.shoppingcart.component.core.toolbar.BackButtonToolbar
import nextstep.shoppingcart.mock.shoppingItemMockList
import nextstep.shoppingcart.navigation.ERROR_PRODUCT_ID
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.util.getLocalCurrencyFormat


/**
 *
 * 상품 상세 화면 screen
 *
 * ProductDetailScreen으로 외부에서
 * 주입이 필요한 데이터
 * state관련 처리 여기서 진행
 * 외부로 클릭 처리 넘겨줌.
 **/
@Composable
fun ProductDetailRoute(
    productId: Int,
    addCartButtonClicked: (productId: Int) -> Unit = {},
    toolbarBackBtnClicked: () -> Unit = {},
) {
    val shoppingItemUiModel = shoppingItemMockList
        .first { it.id == productId }
        .takeIf { productId != ERROR_PRODUCT_ID }

    shoppingItemUiModel?.let {
        ProductDetailScreen(
            modifier = Modifier.fillMaxSize(),
            productId = shoppingItemUiModel.id,
            productName = shoppingItemUiModel.productTitle,
            productPrice = shoppingItemUiModel.productPrice,
            productThumbnail = shoppingItemUiModel.productThumbnail,
            addCartButtonClicked = addCartButtonClicked,
            toolbarBackBtnClicked = toolbarBackBtnClicked
        )
    }
}

/**
 * 상품 상세 화면 screen
 **/
@Composable
private fun ProductDetailScreen(
    modifier: Modifier = Modifier,
    productId: Int,
    productName: String,
    productPrice: Long,
    productThumbnail: String,
    addCartButtonClicked: (productId: Int) -> Unit = {},
    toolbarBackBtnClicked: () -> Unit = {},
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            BackButtonToolbar(
                toolbarTitleString = stringResource(id = R.string.product_detail),
                onBackBtnClicked = { // 뒤로가기 버튼 클릭 시 처리
                    toolbarBackBtnClicked()
                }
            )
        },
        bottomBar = {
            AddCartButton(
                modifier = Modifier.navigationBarsPadding(),
                addCartButtonClicked = { // 장바구니 담기 버튼 클릭 시 처리
                    addCartButtonClicked(productId)
                }
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .wrapContentHeight()
                .verticalScroll(rememberScrollState())
        ) {
            ProductImage(
                productThumbnail = productThumbnail,
                imageRatio = ProductImageRatioType.SHOPPING_ITEM_DETAIL_RATIO,
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                text = productName,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 24.sp,
            )
            Divider(
                thickness = 1.dp,
                color = Color.Gray,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.price),
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp,
                )
                Text(
                    text = productPrice.getLocalCurrencyFormat(),
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp,
                )
            }
        }
    }
}

/**
 * 상품 상세 화면 프리뷰 함수
 */
@Preview
@Composable
fun ProductDetailScreenPreview() {
    ShoppingCartTheme {
        ProductDetailScreen(
            productThumbnail = shoppingItemMockList.first().productThumbnail,
            productName = shoppingItemMockList.first().productTitle,
            productPrice = shoppingItemMockList.first().productPrice,
            productId = shoppingItemMockList.first().id,
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize(),
        )
    }
}
