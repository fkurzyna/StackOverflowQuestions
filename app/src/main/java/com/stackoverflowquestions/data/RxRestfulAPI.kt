
import model.Question

import retrofit2.http.GET
import retrofit2.http.Path

interface RxRestfulAPI {
    @GET("/2.2/search/advanced?order=desc&sort=activity&accepted=True&answers=2&site=stackoverflow")
    fun getQuestions(): List<Question>

}