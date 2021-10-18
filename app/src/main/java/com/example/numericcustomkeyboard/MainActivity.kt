package com.example.numericcustomkeyboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import java.lang.ref.WeakReference
import android.view.View.OnTouchListener
import android.text.Editable

import android.text.TextWatcher
import android.util.Log
import android.text.InputType
import android.view.View.OnFocusChangeListener


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        KeyboardView.initCustomKeyboard(findViewById(R.id.password_field), findViewById(R.id.keyboardView))




    }
}