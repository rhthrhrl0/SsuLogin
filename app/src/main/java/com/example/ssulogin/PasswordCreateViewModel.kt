package com.example.ssulogin

import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yourssu.design.system.atom.BoxButton
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class PasswordCreateViewModel @Inject constructor() : ViewModel() {
    var placeholderTextString = "비밀번호를 입력"
    var helperLabelTextString = "숫자와 영문자 조합으로 8자 이상 입력해 주세요."

    private val _isPositive = MutableLiveData<Boolean>()
    val isPositive: LiveData<Boolean>
        get() = _isPositive

    private val _isNegative = MutableLiveData<Boolean>()
    val isNegative: LiveData<Boolean>
        get() = _isNegative

    var isDisable = false


    var boxButtonText = "다음"
    var boxButtonSize = BoxButton.ExtraLarge
    var boxButtonType = BoxButton.FILLED

    private val _boxButtonIsDisable = MutableLiveData<Boolean>()
    val boxButtonIsDisable: LiveData<Boolean>
        get() = _boxButtonIsDisable

    init {
        _boxButtonIsDisable.postValue(true)
        _isPositive.postValue(false)
        _isNegative.postValue(false)
    }


    val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
            if (Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)[!-~₩]{8,100}\$", s.toString())) {
                _isPositive.postValue(true)
                _isNegative.postValue(false)
                _boxButtonIsDisable.postValue(false) //정규식통과 하면 버튼활성화
            } else {
                _isPositive.postValue(false)
                _isNegative.postValue(true)
                _boxButtonIsDisable.postValue(true) //정규식통과 못하면 버튼 비활성화x`
            }
        }
    }
}