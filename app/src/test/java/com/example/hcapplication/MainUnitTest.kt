package com.example.hcapplication

import com.example.hcapplication.ui.MainMvpPresenter
import com.example.hcapplication.ui.MainMvpView
import org.mockito.MockitoAnnotations
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainUnitTest {

    @Mock
    private lateinit var view: MainMvpView

    private var presenter:  MainMvpPresenter<MainMvpView>? = null


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        presenter?.onAttach(view)
    }

    @Test
    fun loadDataToViewTest() {
        presenter?.doGetData()
    }
}