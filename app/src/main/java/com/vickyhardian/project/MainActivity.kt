package com.vickyhardian.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.vickyhardian.project.auth.registerActivity
import com.vickyhardian.project.dashboard.MainActivityHome
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    private var mIsShowPass = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()

        tv_register.setOnClickListener {
            val intent = Intent(this, registerActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Silahkan Mendaftar", Toast.LENGTH_SHORT).show()
        }

        btn_Login.setOnClickListener {
            val intent = Intent(this, MainActivityHome::class.java)
            startActivity(intent)
        }

        ivShowHidePass.setOnClickListener {
            mIsShowPass = !mIsShowPass
            showPassword(mIsShowPass)
        }
        showPassword(mIsShowPass)
    }

    private fun showPassword(isShow: Boolean) {
        if (isShow) {
            // To show the password
            LoginPass.transformationMethod = HideReturnsTransformationMethod.getInstance()
            ivShowHidePass.setImageResource(R.drawable.eyehide)
        } else {
            // To hide the password
            LoginPass.transformationMethod = PasswordTransformationMethod.getInstance()
            ivShowHidePass.setImageResource(R.drawable.eyeshow)
        }
        // This line of code to put the pointer at the end of the password string
        LoginPass.setSelection(LoginPass.text.toString().length)
    }

}
