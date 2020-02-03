package com.manish.todoapp

import androidx.room.*

@Dao
interface dao {

    @Insert
    fun insert(todo:todo)

    @Insert
    fun insertlist(list: List<todo>)

    @Update
    fun update(todo: todo)

    @Delete
    fun delete(todo: todo)

    @Query("select *from todo")
    fun getalllist():List<todo>

}