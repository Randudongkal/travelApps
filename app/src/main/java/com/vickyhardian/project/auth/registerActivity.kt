package com.vickyhardian.project.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import com.vickyhardian.project.MainActivity
import com.vickyhardian.project.R
import com.vickyhardian.project.dashboard.MainActivityHome
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

class registerActivity : AppCompatActivity() {
    private var mIsShowPass = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        tvregister.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Silahkan Masuk", Toast.LENGTH_SHORT).show()
        }

        buttonRegist.setOnClickListener {
            val intent = Intent(this, MainActivityHome::class.java)
            startActivity(intent)
        }

        showHidePass.setOnClickListener {
            mIsShowPass = !mIsShowPass
            showPassword(mIsShowPass)
        }
        showPassword(mIsShowPass)
    }

    private fun showPassword(isShow: Boolean) {
        if (isShow) {
            // To show the password
            registPass.transformationMethod = HideReturnsTransformationMethod.getInstance()
            showHidePass.setImageResource(R.drawable.eyehide)
        } else {
            // To hide the password
            registPass.transformationMethod = PasswordTransformationMethod.getInstance()
            showHidePass.setImageResource(R.drawable.eyeshow)
        }
        // This line of code to put the pointer at the end of the password string
        registPass.setSelection(registPass.text.toString().length)
    }
}