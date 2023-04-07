package com.example.common

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.utils.DataStoreUtils

abstract class CommonApp :Application() {
    override fun onCreate() {
        super.onCreate()
        if(isDebug()){
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
        DataStoreUtils.init(this)
    }

    abstract fun isDebug():Boolean
}