package com.example.androidsubassembly

import com.example.common.CommonApp

class App : CommonApp() {
    override fun isDebug(): Boolean {
        return BuildConfig.DEBUG
    }
}