package com.example.account.iml

import android.app.AlertDialog
import android.content.Context
import android.text.TextUtils
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.data.bean.UserInfo
import com.example.common.router.CommonRouterConstant
import com.example.common.service.AccountUserService
import com.example.common.utils.DataStoreUtils
import com.google.gson.Gson

@Route(path = CommonRouterConstant.USER_INFO,name="AccountUserServiceIml")
class AccountUserServiceIml :AccountUserService{
    override fun getUser(): UserInfo? {
      //获取用户信息后,转成需要的对象
      val userJson=DataStoreUtils.getSyncData("user","")
        if(TextUtils.isEmpty(userJson)){
            return null
        }

        return Gson().fromJson(userJson,UserInfo::class.java)
    }
    /**
     * 测试弹窗或其他功能
     * */
    override fun showDialog() {
       AlertDialog.Builder(mContext)
           .setTitle("测试一个Dialog弹出框")
           .setMessage("简单测试一下")
           .setNegativeButton("取消"){
               _,_->
           }
           .setPositiveButton("确定"){
               _,_->
           }
           .show()
    }
    private var mContext:Context?=null
    override fun init(context: Context?) {
        mContext=context
    }

}