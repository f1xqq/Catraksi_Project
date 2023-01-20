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
import com.example.catraksi_project.Model.RegisterAplikasi
import com.example.catraksi_project.Model.RetrofitInstance
import okhttp3.Response
import okhttp3.ResponseBody

class RegisterAplikasiActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var editText3: EditText
    lateinit var string1: String
    lateinit var string2: String
    lateinit var string3: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_aplikasi)
        title = "KotlinApp"
        button = findViewById(R.id.btn_register)
        editText1 = findViewById(R.id.nama_pengguna_register)
        editText2 = findViewById(R.id.email_register)
        editText3 = findViewById(R.id.kata_sandi_register)

        button.setOnClickListener(){
            string1 = editText1.text.toString()
            string2 = editText2.text.toString()
            string3 = editText3.text.toString()
            singup(string1, string2, string3)
            Log.i("data : ", string1 + string2 + string3)
        }
    }

    fun keLogin(view: View?){
        val i = Intent(applicationContext, LoginAplikasiActivity::class.java)
        i.putExtra("Value1", "Sedang berada di halaman Register")
        startActivity(i)
    }

    private fun singup(nama_pengguna: String, email: String, password: String){
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val registerInfo = RegisterAplikasi(nama_pengguna, email, password)

        retIn.registerUser(registerInfo).enqueue(object :
            retrofit2.Callback<ResponseBody> {
            override fun onFailure(call: retrofit2.Call<ResponseBody>, t: Throwable) {
                Toast.makeText(
                    this@RegisterAplikasiActivity,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(
                call: retrofit2.Call<ResponseBody>,
                response: retrofit2.Response<ResponseBody>
            ) {
                if(response.code() == 201){
                    Toast.makeText(this@RegisterAplikasiActivity,  "Registrasi "+editText1.text.toString()+" Berhasil!", Toast.LENGTH_SHORT).show()
                    val i = Intent(applicationContext, LoginAplikasiActivity::class.java)
                    i.putExtra("Value1", "Terimakasih, kamu berhasil terdaftar")
                    startActivity(i)
                }
            }
        })
    }
}