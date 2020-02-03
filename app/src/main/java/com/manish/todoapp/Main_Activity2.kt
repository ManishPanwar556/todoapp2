package com.manish.todoapp

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_2.*
import java.time.Year
import java.util.*

class Main_Activity2 : AppCompatActivity(),View.OnClickListener,AdapterView.OnItemSelectedListener{
    var str:String=""
    var date:String=""
    var year:String=""
    var day:String=""
    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        str=parent.getItemAtPosition(position).toString()
    }


    val obj:MainActivity=MainActivity()
    val db by lazy {
       Room.databaseBuilder(
           this,
           appdatabase::class.java, "user.db"
        )
           .allowMainThreadQueries()
           .fallbackToDestructiveMigration()
           .build()
   }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_2)
        btn.setOnClickListener(this)
        ArrayAdapter.createFromResource(this,R.array.Where,android.R.layout.simple_spinner_item).also {
            adapter->adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter=adapter
        }
        spinner.onItemSelectedListener=this
//        datebtn.setOnClickListener{
//            val now=Calendar.getInstance()
//            val datepicker=DatePickerDialog(this,DatePickerDialog.OnDateSetListener{
//                val selectedDate=Calendar.getInstance()
//                selectedDate.set(Calendar.YEAR,now.)
//            }
//                ,now.get(Calendar.YEAR),now.get(Calendar.DATE),now.get(Calendar.DAY_OF_MONTH)).show()
//        }

    }



    override fun onClick(v: View) {
        db.dao().insert(todo(edt1.text.toString(),edt2.text.toString(),str))

    }

}
