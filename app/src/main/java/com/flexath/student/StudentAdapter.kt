package com.flexath.student

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class StudentAdapter(private val mainActivity: MainActivity) : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    private val studentNameList = arrayOf("Aung Thiha","Win Lwin","Zin Bo Khine","Kyi Lay Lu","Thet Paing Soe","Kyi Khant","Okkar Min")
    private val studentRollList = arrayOf(14,9,6,5,12,7,1)
    private val studentImageList = intArrayOf(R.drawable.aungthiha,R.drawable.abe,R.drawable.zbk,R.drawable.kll,R.drawable.tps
                                             ,R.drawable.kh,R.drawable.baka)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.studentName.text = studentNameList[position]
        holder.studentRoll.text = studentRollList[position].toString()
        holder.studentImage.setImageResource(studentImageList[position])
    }

    override fun getItemCount(): Int {
        return studentNameList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var studentName:TextView
        var studentRoll:TextView
        var studentImage: ShapeableImageView

        init {
            studentName = view.findViewById(R.id.nameOfStudent)
            studentRoll = view.findViewById(R.id.rollOfStudent)
            studentImage = view.findViewById(R.id.studentImage)

            view.setOnClickListener {
                Toast.makeText(view.context, studentNameList[adapterPosition],Toast.LENGTH_SHORT).show()
                Intent(mainActivity,FirstActivity::class.java).also {
                    it.putExtra("Image",studentImageList[adapterPosition])
                    it.putExtra("Roll",studentRollList[adapterPosition])
                    view.context.startActivity(it)
                }
            }
        }
    }
}