package com.example.common.service

import com.alibaba.android.arouter.facade.template.IProvider
import com.example.common.data.bean.UserInfo

interface AccountUserService:IProvider {
    /**
     * 获取用户信息
     * */
    fun getUser():UserInfo?

    /**
     * 测试弹出Dialog
     * */
    fun showDialog()

}