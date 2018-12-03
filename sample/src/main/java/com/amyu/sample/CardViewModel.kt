package com.amyu.sample

import androidx.lifecycle.LiveData


data class CardViewModel(
        val logo: LiveData<Int>,
        val background: LiveData<Int>,
        val title: LiveData<String>
)