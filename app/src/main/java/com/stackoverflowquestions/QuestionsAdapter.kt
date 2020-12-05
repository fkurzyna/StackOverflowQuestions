package QuestionsAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stackoverflowquestions.R
import model.Question

class QuestionsAdapter(): RecyclerView.Adapter<QuestionsAdapter.QuestionHolder>() {
    private var questions: ArrayList<Question> = ArrayList<Question>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionHolder {
        val inflater = LayoutInflater.from(parent.context)
        return QuestionHolder(inflater.inflate(R.layout.question_view_holder, parent, false))
    }

    override fun getItemCount(): Int = questions.size

    override fun onBindViewHolder(holder: QuestionHolder, position: Int) {
        holder.title.text = ""+questions[position].title
        holder.link.text = questions[position].link
    }

    fun setQuestions(listQuestions:List<Question>){
        questions.clear()
        questions.addAll(listQuestions)
        notifyDataSetChanged()
    }

    inner class QuestionHolder(val view:View):RecyclerView.ViewHolder(view) {
        val title:TextView = view.findViewById(R.id.title)
        val link:TextView = view.findViewById(R.id.link)
    }

}


