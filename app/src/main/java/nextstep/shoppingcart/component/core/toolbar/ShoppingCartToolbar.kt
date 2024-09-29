package nextstep.shoppingcart.component.core.toolbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme


/**
 * 쇼핑카트 toolbar 컴포넌트
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCartToolbar(
	modifier: Modifier = Modifier,
	actionIconClicked: () -> Unit = {}
) {
	CenterAlignedTopAppBar(modifier = modifier,
		title = {
			Text(text = stringResource(id = R.string.product_list))
		},
		actions = {
			IconButton(
				modifier = Modifier.padding(12.dp, end = 0.dp),
				onClick = {
					actionIconClicked()
				}
			) {
				Icon(
					painter = painterResource(id = R.drawable.shopping_cart),
					contentDescription = "장바구니 버튼"
				)
			}
		}
	)
}

/**
 * Shopping cart toolbar 프리뷰 함수
 */
@Preview(
	backgroundColor = 0xFFFFFFFFL,
	showBackground = true
)
@Composable
fun ShoppingCartToolbarPreview() {
	ShoppingCartTheme {
		ShoppingCartToolbar(
			modifier = Modifier.fillMaxWidth()
		)
	}
}
