package com.kubiakdev.mvpapp.main

import com.kubiakdev.mvpapp.main.usecase.LoadNamesUseCase
import io.mockk.*
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class MainPresenterTest {

    companion object {
        private const val EXAMPLE_NAME_ONE = "test1"
        private const val EXAMPLE_NAME_TWO = "test2"
    }

    @MockK
    private lateinit var loadNamesUseCase: LoadNamesUseCase

    @MockK
    private lateinit var view: MainContract.View

    @InjectMockKs
    private lateinit var presenter: MainPresenter

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `GIVEN non null names null WHEN onCreate THEN do nothing`() {
        //given
        presenter.subscribe(view = view, state = mockk(relaxed = true))

        //when
        presenter.onCreate()

        //then
        verify {
            loadNamesUseCase wasNot Called
        }
    }

    @Test
    fun `GIVEN names equals null and load names returns error WHEN onCreate THEN do nothing`() {
        //given
        presenter.subscribe(view = view, state = null)
        every { loadNamesUseCase.loadNames() } returns Single.error(mockk<Throwable>())

        //when
        presenter.onCreate()

        //then
        verify(inverse = true) {
            view.displayNames(any())
        }
    }

    @Test
    fun `GIVEN names equals null and load names returns example names WHEN onCreate THEN display given names`() {
        //given
        presenter.subscribe(view = view, state = null)

        val exampleNames = listOf(EXAMPLE_NAME_ONE, EXAMPLE_NAME_TWO)
        every { loadNamesUseCase.loadNames() } returns Single.just(exampleNames)

        //when
        presenter.onCreate()

        //then
        verify {
            view.displayNames(exampleNames)
        }
    }
}