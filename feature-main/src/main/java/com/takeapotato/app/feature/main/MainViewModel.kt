package com.takeapotato.app.feature.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.takeapotato.core.data.network.Result
import com.takeapotato.core.data.network.asResult
import com.takeapotato.core.domain.product.Product
import com.takeapotato.core.domain.product.ProductService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val productService: ProductService
) : ViewModel() {
    private var offset = 0
    private val _products: MutableStateFlow<Result<List<Product>>> =
        MutableStateFlow(Result.Loading)

    val products: StateFlow<Result<List<Product>>>
        get() = _products

    init {
        viewModelScope.launch {
            productService.getAllProductList(offset).asResult()
                .collect {
                    _products.value = it
                }
        }
    }

    val uiState: StateFlow<MainViewScreenUiState> = products.map { productResult ->
        val product: MainViewUiState =
            when (productResult) {
                is Result.Success -> {
                    MainViewUiState.Success(
                        allProducts = productResult.data.toTwoColumnProductItems()
                    )
                }

                is Result.Loading -> {
                    MainViewUiState.Loading
                }

                else -> {
                    MainViewUiState.Error
                }
            }
        MainViewScreenUiState(product)
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = MainViewScreenUiState(MainViewUiState.Loading)
        )


    fun onScrollEndReach() {
        viewModelScope.launch {
            offset = 25

            productService.getAllProductList(offset)
                .asResult()
                .collect {
                    val oldResult = _products.value
                    val oldProducts = (oldResult as? Result.Success)?.data ?: emptyList()
                    val newProducts = (it as? Result.Success)?.data ?: emptyList()

                    val combined = oldProducts + newProducts

                    _products.value = Result.Success(combined)

                }

            Log.e("aa", "onScrollEndReach")
        }
    }

    private fun List<Product>.toTwoColumnProductItems(): List<TwoColumnProductItem> {
        val newList = mutableListOf<TwoColumnProductItem>()
        for (i in 0..this.lastIndex step 2) {
            try {
                if (lastIndex > i) {
                    newList.add(
                        TwoColumnProductItem(
                            this[i],
                            this[i + 1]
                        )
                    )
                } else {
                    newList.add(TwoColumnProductItem(this[i], null))
                }
            } catch (e: ArrayIndexOutOfBoundsException) {
                e.printStackTrace()
            }

        }
        return newList
    }
}

sealed interface MainViewUiState {
    data class Success(val allProducts: List<TwoColumnProductItem>) : MainViewUiState
    object Error : MainViewUiState
    object Loading : MainViewUiState
}

data class MainViewScreenUiState(
    val viewState: MainViewUiState
)

data class TwoColumnProductItem(
    val first: Product,
    val second: Product?,
)