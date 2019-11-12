package com.antoniosj.actorstmdb.listactors.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.antoniosj.actorstmdb.R
import com.antoniosj.actorstmdb.entity.TmdbActor
import com.antoniosj.actorstmdb.listactors.viewmodel.ListActorsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var listActorsAdapter: ListActorsAdapter
    lateinit var recyclerView: RecyclerView

    /*
     * temporary. Change for Dagger in the future
     */
    private val listActorsViewModel: ListActorsViewModel by lazy {
        ViewModelProviders.of(this).get(ListActorsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listActorsViewModel.personResponse.observe(this, Observer {
            s -> Log.d("ASJ", s.results.toString())
            listActorsAdapter = ListActorsAdapter(s) {
                clicked(it)
            }
            rv_actors.adapter = listActorsAdapter
            rv_actors.layoutManager = LinearLayoutManager(this)
        })
        
        listActorsViewModel.loadPeople()
    }

    fun clicked(actor: TmdbActor) {
        //in future this will open a detail screen
        Log.d("ASJ", actor.name)
    }
}