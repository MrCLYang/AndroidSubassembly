package com.example.common.utils

import android.text.TextUtils
import com.example.common.data.bean.UserInfo
import com.example.common.utils.DataStoreUtils.getSyncData
import com.example.common.utils.DataStoreUtils.putSyncData
import com.google.gson.Gson

class CommonUserUtils {
    companion object{
        val instance by lazy (LazyThreadSafetyMode.NONE) {
            CommonUserUtils()
        }
    }

    /**
     * 是否登录，实际业务中，请根据存储的用户信息进行判断
     * */

    fun isLogin():Boolean{
        if(getUser()!=null && getUser()?.data!=null && !TextUtils.isEmpty(getUser()?.data?.userId)){
            return true
        }
        return false
    }

    /**
     * 获取用户存储的用户信息，请根据实际业务进行返回，当前仅用于测试
     * */

    fun getUser():UserInfo?{
        //获取用户信息后转成需要的对象
        val userJson=getSyncData("user","")
        if(TextUtils.isEmpty(userJson)){
            return null
        }
        return Gson().fromJson(userJson,UserInfo::class.java)
    }

    /**
     * 保存用户数据，请以实际为准
     * */
    fun setUser(json:String){
        //存储用户信息
        putSyncData("user",json)
    }

}