package model


import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("link")
    var link: String? = null,
    @SerializedName("answer_count")
    var answer_count: Int? = 0
)
