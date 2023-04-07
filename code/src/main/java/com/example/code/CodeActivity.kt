package com.example.code

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.router.CommonRouterConstant
import com.example.common.service.AccountUserService
import com.example.common.service.CommonRouteServiceManager
import com.example.common.utils.CommonUserUtils

@Route(path = CommonRouterConstant.CODE)
class CodeActivity : AppCompatActivity() {
    val TAG=this.javaClass.simpleName

    /** ARouter 形式接收参数*/
    @Autowired(name = "params")
    @JvmField
    var mParams=""

    @Autowired(name = "params2")
    @JvmField
    var mParams2=-1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code)
        //intent 方式 接收参数
        val stringExtra=intent.getStringExtra("params")
        val intExtra=intent.getIntExtra("params2",-1)
        Log.e(TAG, "intent 接收参数1:$stringExtra,接收参数2:$intExtra" )
        //ARouter 形式，接收参数，需要初始化
        ARouter.getInstance().inject(this)
        //打印数据
        Log.e(TAG, "ARouter 接收参数1:$mParams,接收参数2:$mParams2", )
        findViewById<Button>(R.id.btn_get_params).setOnClickListener {
            //获取传递的参数，普通跳转没有
            Toast.makeText(this,"ARouter 接收参数1:$mParams,接收参数2:$mParams2",Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btn_user_info).setOnClickListener {
            CommonUserUtils.instance.getUser()?.let {
                Toast.makeText(this,it.data?.nickName,Toast.LENGTH_SHORT).show()
            }
        }

        //组件之间通过类名称发现服务
        val iml=CommonRouteServiceManager.provide(AccountUserService::class.java)
        iml?.init(this)
        findViewById<Button>(R.id.btn_user_service).setOnClickListener {
            // 模拟，通过服务进行获取用户相关信息
            iml?.getUser()?.let {
                Toast.makeText(this,it.data?.nickName,Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.btn_user_dialog).setOnClickListener {
            //模拟，通过服务进行获取用户相关信息
            iml?.showDialog()
        }

    }
}