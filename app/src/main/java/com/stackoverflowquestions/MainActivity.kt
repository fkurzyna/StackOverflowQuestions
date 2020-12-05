package com.stackoverflowquestions

import HTTPClient.HTTPClient
import QuestionsAdapter.QuestionsAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import model.PagedResponseBody
import model.Question

class MainActivity : AppCompatActivity() {
    private val disposables = CompositeDisposable()
    private val adapter = QuestionsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAdapter()
        initSwipeToRefresh()
        fetchDataRx()
    }

    private fun initAdapter() {
        list.adapter = adapter
    }

    private fun initSwipeToRefresh() {
        swipe_refresh.setOnRefreshListener {
            fetchDataRx()
        }
    }

    private fun fetchDataRx() {
        val restfulAPI = HTTPClient(BuildConfig.ENDPOINT);
        val disposable = restfulAPI.getStackService().getQuestions( 15,
            "desc",
            "activity",
            "stackoverflow")
            .map { formatData(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list -> updateUI(list) }, { showError(it) })
        disposables.add(disposable)
    }

    private fun showError(it: Throwable?) {
    }

    private fun updateUI(text: List<Question>) {
        adapter.setQuestions(text)
        swipe_refresh.isRefreshing = false;
    }

    private fun formatData(it: PagedResponseBody<List<Question>>): List<Question> {
       return it.items
    }
}
