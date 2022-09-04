package com.takeapotato.app.feature.product.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.takeapotato.core.data.network.Result
import com.takeapotato.core.data.network.asResult
import com.takeapotato.core.domain.product.Product
import com.takeapotato.core.domain.product.ProductService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val productService: ProductService
) : ViewModel() {


    private val product: Flow<Result<Product>> = productService.getProduct(1).asResult()

    val uiState: StateFlow<ProductListScreenUiState> =

        product.map { productResult ->
            val product: ProductsUiState =
                if (productResult is Result.Success) {
                    ProductsUiState.Success(
                        products = listOf(productResult.data)
                    )
                } else if (productResult is Result.Loading) {
                    ProductsUiState.Loading
                } else {
                    ProductsUiState.Error
                }
            ProductListScreenUiState(product)
        }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = ProductListScreenUiState(ProductsUiState.Loading)
            )
}

sealed interface ProductsUiState {
    data class Success(val products: List<Product>) : ProductsUiState
    object Error : ProductsUiState
    object Loading : ProductsUiState
}

data class ProductListScreenUiState(
    val productsState: ProductsUiState
)
