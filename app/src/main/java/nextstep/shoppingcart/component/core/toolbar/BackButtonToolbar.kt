package nextstep.shoppingcart.component.core.toolbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R


/**
 * Create Date: 2024. 9. 14.
 *
 * Description: 뒤로가기 버튼이 있는 툴바
 * @author LeeDongHun
 *
 *
 **/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackButtonToolbar(
    modifier: Modifier = Modifier,
    toolbarTitleString: String,
    onBackBtnClicked: () -> Unit = {}
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = toolbarTitleString)
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    onBackBtnClicked()
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "뒤로가기 버튼"
                )
            }
        }
    )
}

/**
 * BackButtonToolbar 프리뷰 함수
 **/
@Preview(
    backgroundColor = 0xFFFFFFFFL,
    showBackground = true
)
@Composable
fun BackButtonToolbarPreview() {
    BackButtonToolbar(
        toolbarTitleString = "상품 상세"
    )
}
