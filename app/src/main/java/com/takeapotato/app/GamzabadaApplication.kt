package com.takeapotato.app

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GamzabadaApplication : Application() {
  override fun onCreate() {
    super.onCreate()
    // 다른 초기화 코드들

    // Kakao SDK 초기화
    KakaoSdk.init(this, "d25360bd5778870e3f6da2e38ebf6148")
  }
}