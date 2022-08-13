package com.example.kullaniciadisaklama

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    lateinit  var sharedPreferences :SharedPreferences //Değeri sonradan vericez
    var alinanKullaniciAdi :String? = null   //string null- null olabilir

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SharedPreferences

        sharedPreferences = this.getSharedPreferences("com.example.kullaniciadisaklama", MODE_PRIVATE)

        alinanKullaniciAdi = sharedPreferences.getString("kullaniciAdi","")//buradaki ilk parametremiz aşşağıda key ile verdiğimiz kullaniciAdi 

        if(alinanKullaniciAdi!=null)
        {
            textView.text = "Kullanıcı adınız :${alinanKullaniciAdi}"
        }





        buttonKaydet.setOnClickListener {

            val kullaniciAdi = editText.text.toString()

            if(kullaniciAdi == "")
            {
                Toast.makeText(this,"Lütfen bir isim giriniz", Toast.LENGTH_LONG).show()
            }
            else
            {
                sharedPreferences.edit().putString("kullaniciAdi",kullaniciAdi).apply()
                textView.text = "Kullanıcı Adı  :${kullaniciAdi}"
            }


        }



        buttonSil.setOnClickListener {

            alinanKullaniciAdi = sharedPreferences.getString("kullaniciAdi","")

            if(alinanKullaniciAdi!=null)
            {
                textView.text = "Kullanıcı Adı :"
                sharedPreferences.edit().remove("kullaniciAdi").apply()
            }

        }

    }



}
