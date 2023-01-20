package com.example.catraksi_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.catraksi_project.Model.ApiInterface
import com.example.catraksi_project.Model.LoginAplikasi
import com.example.catraksi_project.Model.RetrofitInstance
import com.example.catraksi_project.Session.SessionManager
import com.example.catraksi_project.databinding.ActivityLoginAplikasiBinding
import okhttp3.Response
import okhttp3.ResponseBody
import kotlin.math.log

class LoginAplikasiActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var string1: String
    lateinit var string2: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_aplikasi)
        title = "KotlinApp"
        button = findViewById(R.id.btn_login)
        editText1 = findViewById(R.id.nama_pengguna_login)
        editText2 = findViewById(R.id.kata_sandi_login)

        button.setOnClickListener(){
            string1 = editText1.text.toString()
            string2 = editText2.text.toString()
            signin(string1, string2)
            Log.i("data : ", string1 + string2)
        }

    }

    private fun signin(username: String, password: String){
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val signInInfo = LoginAplikasi(username, password)
        retIn.login(signInInfo).enqueue(object : retrofit2.Callback<ResponseBody> {
            override fun onFailure(call: retrofit2.Call<ResponseBody>, t: Throwable) {
                Toast.makeText(
//                    context, untuk fragment
//                    ini untuk activity
                    this@LoginAplikasiActivity,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
            override fun onResponse(call: retrofit2.Call<ResponseBody>, response: retrofit2.Response<ResponseBody>) {
                if (response.code() == 200) {
                    Toast.makeText(this@LoginAplikasiActivity, "Login success!", Toast.LENGTH_SHORT).show()
                    val sessionManager = SessionManager(this@LoginAplikasiActivity)
                    sessionManager.setLoggin(true)
                    sessionManager.setUsername(username)
//                    findNavController().navigate(R.id.action_loginAcitvity_to_berandaFragment2)
                    val i = Intent(applicationContext, MenuUtama::class.java)
                    i.putExtra("Value1", "Selamat Datang")
                    startActivity(i)
                } else {
                    Toast.makeText(this@LoginAplikasiActivity, "Login failed!", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }



    fun keRegister(view: View?){
        val i = Intent(applicationContext, RegisterAplikasiActivity::class.java)
        i.putExtra("Value1", "Halaman Register")
        startActivity(i)
    }

}