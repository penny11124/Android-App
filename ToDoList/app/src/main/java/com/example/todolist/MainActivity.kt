package com.example.todolist

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var item : EditText
    lateinit var add : Button
    lateinit var listView : ListView

    var itemList = ArrayList<String>()

    var fileHelper = FileHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        item = findViewById(R.id.editText)
        add = findViewById(R.id.button)
        listView = findViewById(R.id.list)

        itemList = fileHelper.readData(this)

        var arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,itemList)

        listView.adapter = arrayAdapter

        add.setOnClickListener {
            var itemName : String = item.text.toString()
            itemList.add(itemName)
            item.setText("")
            fileHelper.writeData(itemList,applicationContext)

            //告訴arrayAdapter資料已經變更，需要更新ListView的顯示。這樣就會立即更新ListView，將新的資料顯示出來。
            arrayAdapter.notifyDataSetChanged()
        }
        
        listView.setOnItemClickListener { adapterView, view, position, id ->
            var alert = AlertDialog.Builder(this)
            alert.setTitle("Delete")
                .setMessage("Do you want to delete this item from the list?")
                .setCancelable(false)
                .setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, which ->
                    dialogInterface.cancel()
                })
                .setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, which ->
                    itemList.removeAt(position)
                    arrayAdapter.notifyDataSetChanged()
                    fileHelper.writeData(itemList,applicationContext)
                })
            alert.create().show()
        }
    }
}