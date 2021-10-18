package com.example.numericcustomkeyboard

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import java.lang.ref.WeakReference

open class KeyboardView : FrameLayout, View.OnClickListener {

    companion object {
        var mEditTextField: WeakReference<EditText>? = null

        fun initCustomKeyboard(mEditText:EditText, keyBoardView:KeyboardView) {

            this.mEditTextField=WeakReference(mEditText)

            mEditTextField?.get()?.inputType = InputType.TYPE_NULL

            mEditTextField?.get()?.setOnClickListener {
                keyBoardView.visibility = View.VISIBLE
                Log.d("onClick", "@@@@@@")
            }
            mEditTextField?.get()?.onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
                if (hasFocus) {
                    Log.d("Focus", "@@@@@@")
                }
            }
        }
    }

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        inflate(context, R.layout.number_pad, this)
        initViews()
    }

    private fun initViews() {
        mEditTextField.also { mEditTextField = it }
        mView<View>(R.id.key_0).setOnClickListener(this)
        mView<View>(R.id.key_1).setOnClickListener(this)
        mView<View>(R.id.key_2).setOnClickListener(this)
        mView<View>(R.id.key_3).setOnClickListener(this)
        mView<View>(R.id.key_4).setOnClickListener(this)
        mView<View>(R.id.key_5).setOnClickListener(this)
        mView<View>(R.id.key_6).setOnClickListener(this)
        mView<View>(R.id.key_7).setOnClickListener(this)
        mView<View>(R.id.key_8).setOnClickListener(this)
        mView<View>(R.id.key_9).setOnClickListener(this)
        mView<View>(R.id.key_comma).setOnClickListener(this)
        mView<View>(R.id.key_delete).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        // handle number button click
        if (v.tag != null && "number_button" == v.tag) {
            mEditTextField?.get()?.append((v as TextView).text)
            return
        }

        when (v.id) {

            R.id.key_comma -> {
                var mNumber = mEditTextField?.get()?.text.toString()
                if("," !in mNumber && mNumber.isNotEmpty()){
                    mNumber= "$mNumber,"
                    mEditTextField?.get()?.setText(mNumber)
               }
            }
            R.id.key_delete -> {
                val editable = mEditTextField?.get()?.text
                val charCount = editable?.length
                if (charCount != null) {
                    if (charCount > 0) {
                        editable.delete(charCount - 1, charCount)
                    }
                }
            }
        }
    }


    private fun <T : View?> mView (id: Int): T {
        return super.findViewById<View>(id) as T
    }


}