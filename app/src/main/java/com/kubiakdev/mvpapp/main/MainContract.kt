package com.kubiakdev.mvpapp.main

import com.kubiakdev.mvpapp.base.BaseState
import com.kubiakdev.mvpapp.base.BaseStatefulPresenter
import com.kubiakdev.mvpapp.base.BaseView

interface MainContract {

    interface View : BaseView {

        fun displayNames(names: List<String>)
    }

    interface State : BaseState {

        val names: List<String>?
    }

    interface Presenter : BaseStatefulPresenter<View, State> {

       fun onCreate()
    }
}