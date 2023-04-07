package com.example.androidsubassembly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.common.router.CommonRouterConstant
import com.example.common.router.CommonRouterManger

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //模拟跳转account 组件
        findViewById<Button>(R.id.btn_account).setOnClickListener {
            CommonRouterManger.instance.navigationActivity(CommonRouterConstant.ACCOUNT)
        }
        // 模拟跳转code 组件
        findViewById<Button>(R.id.btn_code).setOnClickListener {
            CommonRouterManger.instance.navigationActivity(CommonRouterConstant.CODE)
        }

    }
}