package com.example.matthewchang_technicaltest_androidintern

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val students = listOf(
            Student("CS Telkomsel", "081293551227", R.drawable.ic_person),
            Student("CS XL", "08178889999", R.drawable.ic_person),
            Student("CS Indosat", "085512345678", R.drawable.ic_person),
            Student("CS Smartfren", "088812345678", R.drawable.ic_person),
            Student("CS Three", "089912345678", R.drawable.ic_person)
        )

        recyclerView.adapter = StudentAdapter(students)
    }
}

data class Student(val name: String, val phoneNumber: String, val profileImage: Int)

class StudentAdapter(private val students: List<Student>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.bind(student)
    }

    override fun getItemCount() = students.size

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.tvName)
        private val phoneTextView: TextView = itemView.findViewById(R.id.tvPhone)
        private val profileImageView: ImageView = itemView.findViewById(R.id.imgProfile)

        fun bind(student: Student) {
            nameTextView.text = student.name
            phoneTextView.text = student.phoneNumber
            profileImageView.setImageResource(student.profileImage)
        }
    }
}
