package com.kubiakdev.mvpapp.data

import io.reactivex.Single

class DummyRepository {

    fun getNames(): Single<List<String>> {
        return Single.just(listOf("name1", "name2", "name3"))
    }
}