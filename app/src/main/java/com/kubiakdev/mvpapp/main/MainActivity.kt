package com.kubiakdev.mvpapp.main

import android.os.Bundle
import android.widget.Toast
import com.kubiakdev.mvpapp.R
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainContract.View {

    companion object {
        private const val BUNDLE_SAVED_STATE = "saved_state"
    }

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)

        presenter.subscribe(view = this, state = getSavedState(savedInstanceState))
        presenter.onCreate()
    }

    private fun getSavedState(savedInstanceState: Bundle?): MainContract.State? {
        return savedInstanceState?.getParcelable<MainState>(BUNDLE_SAVED_STATE)
    }

    override fun displayNames(names: List<String>) {
        names.forEach { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putParcelable(BUNDLE_SAVED_STATE, presenter.getState())
        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unSubscribe()
    }
}
