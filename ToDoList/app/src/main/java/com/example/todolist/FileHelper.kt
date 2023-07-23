package com.example.todolist

import android.content.Context
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class FileHelper {

    val FILENAME = "listinfo.dat"

    //write data into FILENAME
    //FileOutputStream : 用於將資料寫入檔案

    fun writeData(item: ArrayList<String>, context: Context) {
        var fos : FileOutputStream = context.openFileOutput(FILENAME,Context.MODE_PRIVATE)
        var oas = ObjectOutputStream(fos)
        oas.writeObject(item)
        oas.close()
    }

    //read data from FILENAME
    //FileInputStream  : 用於從檔案中讀取資料
    fun readData(context: Context) : ArrayList<String> {
        var itemList : ArrayList<String>
        try {
            var fis : FileInputStream = context.openFileInput(FILENAME)
            var oas = ObjectInputStream(fis)
            itemList = oas.readObject() as ArrayList<String>
        } catch (e : FileNotFoundException) {
            itemList = ArrayList()
        }


        return itemList
    }
}