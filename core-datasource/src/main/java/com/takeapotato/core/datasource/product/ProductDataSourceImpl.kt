package com.takeapotato.core.datasource.product

import com.takeapotato.core.datasource.product.entity.ProductEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductDataSourceImpl @Inject constructor(
    private val remote: ProductRemote
) : ProductDataSource {

    override fun getProduct(): Flow<ProductEntity> {
        return remote.getProduct().map { it.data!! }
    }

    override fun getAllProductList(offset: Int): Flow<List<ProductEntity>> {
        return flow { emit(productListMock) }
    }
}

private val productListMock = listOf(
    ProductEntity(
        id = 0,
        title = "짱구 랜덤 피규어",
        thumbnailUrl = "https://picsum.photos/200",
        nowBidPrice = 14000,
        bidEndTime = "19일 4시간 26분 남음",
    ),
    ProductEntity(
        id = 0,
        title = "쿠키 먹는 나롱 캔버스",
        thumbnailUrl = "https://picsum.photos/200",
        nowBidPrice = 360000,
        bidEndTime = "19일 4시간 26분 남음",
    ),
    ProductEntity(
        id = 0,
        title = "블루 크롭 티셔츠",
        thumbnailUrl = "https://picsum.photos/200",
        nowBidPrice = 14000,
        bidEndTime = "19일 4시간 26분 남음",
    ),
    ProductEntity(
        id = 0,
        title = "에어팟 프로 1세대",
        thumbnailUrl = "https://picsum.photos/200",
        nowBidPrice = 83000,
        bidEndTime = "19일 4시간 26분 남음",
    ),
    ProductEntity(
        id = 0,
        title = "나롱이의 춘식이",
        thumbnailUrl = "https://picsum.photos/200",
        nowBidPrice = 14000,
        bidEndTime = "19일 4시간 26분 남음",
    ),
    ProductEntity(
        id = 0,
        title = "AWS Summit 때 받았던 사탕",
        thumbnailUrl = "https://picsum.photos/200",
        nowBidPrice = 14000,
        bidEndTime = "19일 4시간 26분 남음",
    ),
    ProductEntity(
        id = 0,
        title = "짱구 랜덤 피규어",
        thumbnailUrl = "https://picsum.photos/200",
        nowBidPrice = 14000,
        bidEndTime = "19일 4시간 26분 남음",
    ),
    ProductEntity(
        id = 0,
        title = "쿠키 먹는 나롱 캔버스",
        thumbnailUrl = "https://picsum.photos/200",
        nowBidPrice = 360000,
        bidEndTime = "19일 4시간 26분 남음",
    ),
    ProductEntity(
        id = 0,
        title = "블루 크롭 티셔츠",
        thumbnailUrl = "https://picsum.photos/200",
        nowBidPrice = 14000,
        bidEndTime = "19일 4시간 26분 남음",
    ),
    ProductEntity(
        id = 0,
        title = "에어팟 프로 1세대",
        thumbnailUrl = "https://picsum.photos/200",
        nowBidPrice = 83000,
        bidEndTime = "19일 4시간 26분 남음",
    ),
    ProductEntity(
        id = 0,
        title = "나롱이의 춘식이",
        thumbnailUrl = "https://picsum.photos/200",
        nowBidPrice = 14000,
        bidEndTime = "19일 4시간 26분 남음",
    ),
    ProductEntity(
        id = 0,
        title = "AWS Summit 때 받았던 사탕",
        thumbnailUrl = "https://picsum.photos/200",
        nowBidPrice = 14000,
        bidEndTime = "19일 4시간 26분 남음",
    )
)


//
//            ProductEntity(
//            title = "짱구 랜덤 피규어",
//    thumbnailUrl = "",
//    currentPrice = 14000,
//    remainTime = "19일 4시간 26분 남음",
//    isLike = false,
//    onSale = true,
//    tagBadgeModel = null,
//),
//ProductModel(
//title = "쿠키 먹는 나롱 캔버스",
//thumbnailUrl = "",
//currentPrice = 360000,
//remainTime = "19일 4시간 26분 남음",
//isLike = true,
//onSale = true,
//tagBadgeModel = TagBadgeModel(
//"작가상품",
//"#B295FF"
//),
//),
//ProductModel(
//title = "블루 크롭 티셔츠",
//thumbnailUrl = "",
//currentPrice = 14000,
//remainTime = "19일 4시간 26분 남음",
//isLike = false,
//onSale = true,
//tagBadgeModel = null,
//),
//ProductModel(
//title = "에어팟 프로 1세대",
//thumbnailUrl = "",
//currentPrice = 83000,
//remainTime = "19일 4시간 26분 남음",
//isLike = false,
//onSale = true,
//tagBadgeModel = null,
//),
//ProductModel(
//title = "나롱이의 춘식이",
//thumbnailUrl = "",
//currentPrice = 14000,
//remainTime = "19일 4시간 26분 남음",
//isLike = false,
//onSale = true,
//tagBadgeModel = null,
//),
//ProductModel(
//title = "AWS Summit 때 받았던 사탕",
//thumbnailUrl = "",
//currentPrice = 14000,
//remainTime = "19일 4시간 26분 남음",
//isLike = false,
//onSale = true,
//tagBadgeModel = null,
//),
//ProductModel(
//title = "짱구 랜덤 피규어",
//thumbnailUrl = "",
//currentPrice = 14000,
//remainTime = "19일 4시간 26분 남음",
//isLike = false,
//onSale = true,
//tagBadgeModel = null,
//),
//ProductModel(
//title = "쿠키 먹는 나롱 캔버스",
//thumbnailUrl = "",
//currentPrice = 360000,
//remainTime = "19일 4시간 26분 남음",
//isLike = true,
//onSale = true,
//tagBadgeModel = TagBadgeModel(
//"작가상품",
//"#B295FF"
//),
//),
//ProductModel(
//title = "블루 크롭 티셔츠",
//thumbnailUrl = "",
//currentPrice = 14000,
//remainTime = "19일 4시간 26분 남음",
//isLike = false,
//onSale = true,
//tagBadgeModel = null,
//),
//ProductModel(
//title = "에어팟 프로 1세대",
//thumbnailUrl = "",
//currentPrice = 83000,
//remainTime = "19일 4시간 26분 남음",
//isLike = false,
//onSale = true,
//tagBadgeModel = null,
//),
//ProductModel(
//title = "나롱이의 춘식이",
//thumbnailUrl = "",
//currentPrice = 14000,
//remainTime = "19일 4시간 26분 남음",
//isLike = false,
//onSale = true,
//tagBadgeModel = null,
//),
//ProductModel(
//title = "AWS Summit 때 받았던 사탕",
//thumbnailUrl = "",
//currentPrice = 14000,
//remainTime = "19일 4시간 26분 남음",
//isLike = false,
//onSale = true,
//tagBadgeModel = null,
//)