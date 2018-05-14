package com.example.ayushgupta.ktmy2

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import java.io.File

class ListTest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_test)
        val status = ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)
        if (status == PackageManager.PERMISSION_GRANTED){
            readFile()
        }
        else {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),123)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
            readFile()
        }
        else{
            Toast.makeText(this,"can't proceed without permission",Toast.LENGTH_SHORT).show()
        }
    }
    private fun readFile(){
        val listTest: ListView = findViewById(R.id.List_View)
        var path = "/storage/sdcard0/"
        var file = File(path)
        if (!file.exists()){
            path = "/storage/emulated/0/"
            file = File(path)
        }
        val files = file.list()
        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,files)
        listTest.adapter = adapter
    }
}