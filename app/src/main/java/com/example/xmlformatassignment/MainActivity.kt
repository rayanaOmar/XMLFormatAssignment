package com.example.xmlformatassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv)

        var students: List<Students>? = null

        try{
            val parser = XmlPullParserHandler()
            val istream = assets.open("studentdetails.xml")

            students = parser.parse(istream)

            recyclerView.adapter = RVadapter(students)
            recyclerView.layoutManager = LinearLayoutManager(this)
        }catch(e: IOException){
            e.printStackTrace()
        }

    }
}