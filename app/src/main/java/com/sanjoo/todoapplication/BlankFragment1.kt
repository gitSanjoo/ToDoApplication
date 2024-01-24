package com.sanjoo.todoapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sanjoo.todoapplication.databinding.FragmentBlank1Binding

class BlankFragment1 : Fragment() {
    private lateinit var binding: FragmentBlank1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentBlank1Binding.inflate(layoutInflater,container,false)
//get from act1
        binding.tvFromActivity.text=arguments?.getString("mText")

        //send to frag2
        val fragManager2=childFragmentManager
        val fragTransaaction=fragManager2.beginTransaction()
        val fragment=BlankFragment2()

        binding.btnFrag1ToFrag2.setOnClickListener {
            val bundle= Bundle()
            bundle.putString("text2",binding.etFrag1tofrag2.text.toString())
            fragment.arguments=bundle
            fragTransaaction.replace(R.id.frame2,fragment).commit()

        }

        //frag2 to act1
        binding.btnFrag1ToFrag2.setOnClickListener {

        }

        // Inflate the layout for this fragment
        return binding.root
    }
}