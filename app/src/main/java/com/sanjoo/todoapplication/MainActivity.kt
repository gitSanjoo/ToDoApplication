package com.sanjoo.todoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sanjoo.todoapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //act1 to act2
        binding.btnGoToAct2.setOnClickListener {
            var name:String=binding.etName.text.toString()
            val intent=Intent(this,MainActivity2::class.java)
            intent.putExtra("name",name)
            startActivity(intent)
        }
//activity 1 to frag1
        val fragmentManager1=supportFragmentManager
        val fragmentTransaction1=fragmentManager1.beginTransaction()
        val fragment=BlankFragment1()

        binding.btnFrag1.setOnClickListener {
            val mBundle=Bundle()
            mBundle.putString("mText",binding.etName.text.toString())
            fragment.arguments=mBundle
            fragmentTransaction1.replace(R.id.frame1,fragment).commit()
        }
    }
}