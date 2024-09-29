package nextstep.shoppingcart.component.feature.product

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.mock.shoppingItemMockList
import nextstep.shoppingcart.model.ShoppingItemUiModel


/**
 * Create Date: 2024. 8. 31.
 *
 * Description: 상품 리스트 관련 컴포넌트
 * @author LeeDongHun
 *
 *
**/
@Composable
fun ProductList(
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
    productList: List<ShoppingItemUiModel>,
    onItemClick: (ShoppingItemUiModel) -> Unit,

){
    LazyVerticalGrid(
        contentPadding = contentPadding,
        modifier = modifier,
        columns = GridCells.Fixed(2),
    ) {
        items(
            items = productList,
            key = { item -> item.id }
        ) { item ->
            ProductItem(
                modifier = Modifier.padding(5.dp),
                productThumbnail = item.productThumbnail,
                productTitle = item.productTitle,
                productPrice = item.productPrice,
                onItemClick = {
                    onItemClick(item)
                }
            )
        }
    }
}

/**
 * 상품 리스트 프리뷰 함수
 */
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFFL,
    showSystemUi = true,
    name = "ProductList"
)
@Composable
fun ProductListPreview() {
    ProductList(
        modifier = Modifier.padding(10.dp),
        contentPadding = PaddingValues(0.dp),
        productList = shoppingItemMockList,
        onItemClick = {}
    )
}
