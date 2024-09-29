package nextstep.shoppingcart.component.core.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.Blue50
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

/**
 * Create Date: 2024. 9. 15.
 *
 * 장바구니 담기 버튼
 * @author LeeDongHun
 *
 *
 **/
@Composable
fun AddCartButton(
    modifier: Modifier = Modifier,
    addCartButtonClicked: () -> Unit = {}
) {
    Button(
        colors = ButtonDefaults.buttonColors(Blue50),
        modifier = modifier
            .height(54.dp)
            .fillMaxWidth(),
        shape = RectangleShape,
        onClick = {
            addCartButtonClicked()
        }, content = {
            Text(
                text = stringResource(id = R.string.add_cart),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
        }
    )
}

/**
 * AddCartButton 프리뷰 함수
**/
@Preview
@Composable
fun AddCartButtonPreview() {
    ShoppingCartTheme {
        AddCartButton()
    }
}
