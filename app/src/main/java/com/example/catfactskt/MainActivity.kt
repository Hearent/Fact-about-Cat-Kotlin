package com.example.catfactskt

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catfactskt.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var catFacts = ArrayList<String>()
    var catFactsLength = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val catApi = RetrofitHelper.getInstance().create(CatAPI::class.java)
        binding.progressCircular.visibility = View.VISIBLE
        GlobalScope.launch {
            val result = catApi.getCatsFacts()
            if (result != null) {
                result.body()!!.catResult.forEach {
                    catFacts.add(it.fact)
                    catFactsLength.add(it.length.toString())
                }.toString()
                binding.progressCircular.visibility = View.INVISIBLE
                this@MainActivity.runOnUiThread(java.lang.Runnable {
                    binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                    binding.recyclerView.adapter = MyAdapter(catFacts, catFactsLength)
                })

            }
        }

    }
}