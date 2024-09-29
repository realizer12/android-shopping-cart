package nextstep.shoppingcart.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.component.core.toolbar.BackButtonToolbar
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

/**
 * Create Date: 2024. 9. 16.
 *
 * Description: 쇼핑카트 screen
 * @author LeeDongHun
 *
 *
**/

@Composable
fun ShoppingCartRoute(
    toolbarBackBtnClicked: () -> Unit = {},
) {
    ShoppingCartScreen(
        modifier = Modifier.fillMaxSize(),
        toolbarBackBtnClicked = toolbarBackBtnClicked
    )
}

/**
 * Shopping cart screen 함수
**/
@Composable
private fun ShoppingCartScreen(
    modifier: Modifier = Modifier,
    toolbarBackBtnClicked: () -> Unit = {},
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            BackButtonToolbar(
                toolbarTitleString = stringResource(id = R.string.cart),
                onBackBtnClicked = {
                    toolbarBackBtnClicked()
                }
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier.padding(contentPadding)
        ) {

        }
    }
}

/**
 * Shopping cart screen 프리뷰 함수
 */
@Composable
@Preview
fun ShoppingCartScreenPreview() {
   ShoppingCartTheme {
       ShoppingCartScreen()
   }
}
