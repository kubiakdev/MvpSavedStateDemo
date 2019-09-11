package com.kubiakdev.mvpapp.main

import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainState(override val names: List<String>?): MainContract.State