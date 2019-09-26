package com.andraganoid.egghunt2

import android.widget.Toast

fun MainActivity.toast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()