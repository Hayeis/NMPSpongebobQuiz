package com.alfons.nmpspongebobquiz

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alfons.nmpspongebobquiz.databinding.QuestionCardBinding

class QuestionAdapter(): RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): QuestionViewHolder {
        val binding = QuestionCardBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        return QuestionViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: QuestionViewHolder,
        position: Int
    ) {
        holder.binding.imgQuestion.setImageResource(BankSoal.pertanyaannya[position].imageId)
        holder.binding.txtQuestionTitle.text = BankSoal.pertanyaannya[position].soal
    }

    override fun getItemCount(): Int {
        return BankSoal.pertanyaannya.size
    }

    class QuestionViewHolder(val binding:
                             QuestionCardBinding): RecyclerView.ViewHolder(binding.root)
}