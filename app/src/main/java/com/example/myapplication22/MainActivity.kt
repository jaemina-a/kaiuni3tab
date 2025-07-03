package com.example.myapplication22

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // 데이터 클래스
    data class MyItem(val title: String, val description: String)

    // 어댑터 클래스
    class MyAdapter(private val itemList: List<MyItem>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        // 뷰홀더 클래스
        class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val titleText: TextView = itemView.findViewById(R.id.titleText)
            val descText: TextView = itemView.findViewById(R.id.descText)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_my, parent, false)
            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val item = itemList[position]
            holder.titleText.text = item.title
            holder.descText.text = item.description
        }

        override fun getItemCount(): Int = itemList.size
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val itemList = listOf(
            MyItem("제목 1", "설명 1"),
            MyItem("제목 2", "설명 2"),
            MyItem("제목 3", "설명 3")
        )

        val adapter = MyAdapter(itemList)
        recyclerView.adapter = adapter
    }
}
