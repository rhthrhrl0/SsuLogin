package com.example.ssulogin

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yourssu.design.system.atom.BoxButton
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IdCreateViewModel @Inject constructor() : ViewModel() {
    var placeholderTextString = "이메일을 입력해주세요."
    var suffixLabelTextString = "@soongsil.ac.kr"
    var isPositive = false
    var isNegative = false
    var isDisable = false

    var boxButtonText = "다음"
    var boxButtonSize = BoxButton.ExtraLarge
    var boxButtonType = BoxButton.FILLED

    private val _boxButtonIsDisable = MutableLiveData<Boolean>()
    val boxButtonIsDisable: LiveData<Boolean>
        get() = _boxButtonIsDisable


    init {
        _boxButtonIsDisable.postValue(true)
    }

    fun boxButtonStateChange() {
        val boolean: Boolean = _boxButtonIsDisable.value!!
        _boxButtonIsDisable.postValue(!(boolean))
    }


    val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
            if (s.toString() == "") {
                if (!(boxButtonIsDisable.value!!))
                    boxButtonStateChange()
                Log.d("kmj", "비어있음")
            } else {
                if (boxButtonIsDisable.value!!)
                    boxButtonStateChange()
                Log.d("kmj", "비지않음")
            }
        }
    }
}