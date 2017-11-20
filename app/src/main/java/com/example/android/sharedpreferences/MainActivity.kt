package com.example.android.sharedpreferences

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    internal var sharedPreferences: SharedPreferences? = null
    internal var username: EditText? = null
    internal var password: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.ed_username)
        password = findViewById(R.id.ed_password)
        sharedPreferences = getSharedPreferences(mypreferences, Context.MODE_PRIVATE)

        if (sharedPreferences!!.contains(name)) {
            username!!.setText(sharedPreferences!!.getString(name, ""))
        } else if (sharedPreferences!!.contains(Email)) {
            password!!.setText(sharedPreferences!!.getString(Email, ""))
        }
    }

    @SuppressLint("CommitPrefEdits")
    fun Save(view: View) {
        val n = username!!.text.toString()
        val e = password!!.text.toString()
        val editor = sharedPreferences!!.edit()
        editor.putString(name, n)
        editor.putString(Email, e)
    }

    fun Clear(view: View) {
        username = findViewById(R.id.ed_username)
        password = findViewById(R.id.ed_password)
        username!!.setText("")
        password!!.setText("")
    }

    fun Get(view: View) {
        username = findViewById(R.id.ed_username)
        password = findViewById(R.id.ed_password)
        sharedPreferences = getSharedPreferences(mypreferences, Context.MODE_PRIVATE)

        if (sharedPreferences!!.contains(name)) {
            username!!.setText(sharedPreferences!!.getString(name, ""))
        } else if (sharedPreferences!!.contains(Email)) {
            password!!.setText(sharedPreferences!!.getString(Email, ""))
        }
    }

    companion object {
        private val mypreferences = "mypref"
        private val name = "namaKey"
        private val Email = "emailKey"
    }
}
