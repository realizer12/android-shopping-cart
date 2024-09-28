package nextstep.shoppingcart.model

/**
 * Create Date: 2024. 9. 28.
 *
 * 장바구니에 담긴 상품 정보를 표현하기 위한 UI Model 클래스
 * @author LeeDongHun
 * 
 * 
**/
data class CartItemUiModel(
    val product: ShoppingItemUiModel,
    val count: Int,
) {
    val totalPrice: Long get() = product.productPrice * count
}

/**
 * Create Date: 2024. 9. 28.
 *
 * 장바구니 기능을 사용하기 위한 cart object 클래스
 *
 * @author LeeDongHun
 *
 *
**/
object Cart {
    private val _items: MutableList<CartItemUiModel> = mutableListOf()
    val items: List<CartItemUiModel> get() = _items.toList()

    val totalPrice: Long get() = _items.sumOf { it.totalPrice }

    fun addOne(product: ShoppingItemUiModel): List<CartItemUiModel> {
        val item = _items.find { it.product == product }
        if (item == null) {
            _items.add(CartItemUiModel(product, 1))
        } else {
            val index = _items.indexOf(item)
            _items[index] = item.copy(count = item.count + 1)
        }
        return items
    }

    fun removeOne(product: ShoppingItemUiModel): List<CartItemUiModel> {
        _items.find { it.product == product }
            ?.let { item ->
                if (item.count > 1) {
                    val index = _items.indexOf(item)
                    _items[index] = item.copy(count = item.count - 1)
                } else {
                    _items.remove(item)
                }
            }
        return items
    }

    fun removeAll(product: ShoppingItemUiModel): List<CartItemUiModel> {
        _items.removeAll { it.product == product }
        return items
    }
}
