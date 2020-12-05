package StackService

import io.reactivex.Observable
import model.PagedResponseBody
import model.Question
import retrofit2.http.GET
import retrofit2.http.Query


interface StackService {


    //2.2/search/advanced?order=desc&sort=activity&accepted=True&answers=1&site=stackoverflow
    @GET("/search/advanced?&accepted=True&answers=1")
    fun getQuestions( @Query("pagesize") pageSize: Int,
                      @Query("order") order: String,
                      @Query("sort") sort: String,
                      @Query("site") site: String): Observable<PagedResponseBody<List<Question>>>
}