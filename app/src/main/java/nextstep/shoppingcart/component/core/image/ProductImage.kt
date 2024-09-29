package nextstep.shoppingcart.component.core.image

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage

/**
 * Create Date: 2024. 9. 16.
 *
 * 상품 이미지는  리스트 화면이랑, 상세 화면에서 사용되므로 component화 시킴
 * @author LeeDongHun
 *
 *
**/
@Composable
fun ProductImage(
    productThumbnail:String,
    imageRatio: ProductImageRatioType = ProductImageRatioType.SHOPPING_ITEM_THUMBNAIL_RATIO
){
    AsyncImage(
        modifier = Modifier.aspectRatio(imageRatio.ratio),
        contentScale = ContentScale.Crop,
        model = productThumbnail,
        contentDescription = "상품 썸네일 이미지",
    )
}

/**
 * 상품 이미지 비율 타입
 */
enum class ProductImageRatioType(val ratio:Float) {
    SHOPPING_ITEM_THUMBNAIL_RATIO(0.98f / 1f),
    SHOPPING_ITEM_DETAIL_RATIO(1f)
}


/**
 * ProductImage 프리뷰 함수
 **/
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFFL
)
@Composable
fun ProductImagePreview() {
    ProductImage(
        productThumbnail = "https://picsum.photos/200/300",
        imageRatio = ProductImageRatioType.SHOPPING_ITEM_DETAIL_RATIO,
    )
}
