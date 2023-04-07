package com.example.common.data.bean

/**
 * 测试用户对象
 * */
data class UserInfo(var code:Int,var message:String,var data:User) {
    class User {
        var userName:String?=null
        var userId:String?=null
        var nickName:String?=null
    }
}