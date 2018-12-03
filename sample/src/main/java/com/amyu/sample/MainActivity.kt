package com.amyu.sample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.amyu.stack_card_layout_manager.StackCardLayoutManager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = StackCardAdapter(applicationContext).apply {
            onItemClickListener = { cardView, cardViewModel ->
                val compat = ActivityOptionsCompat.makeSceneTransitionAnimation(this@MainActivity, cardView, cardView.transitionName)
                startActivityWithOptions(compat) { DetailActivity.createIntent(it, cardViewModel.title.value!!, cardViewModel.background.value!!, cardViewModel.logo.value!!) }
            }
            submitList(
                    listOf(
                            CardViewModel(
                                    title = MutableLiveData<String>().apply {
                                        postValue("omisego")
                                    },
                                    background = MutableLiveData<Int>().apply {
                                        postValue(R.drawable.omg_background)
                                    },
                                    logo = MutableLiveData<Int>().apply {
                                        postValue(R.drawable.ic_omg)
                                    }
                            ),
                            CardViewModel(
                                    title = MutableLiveData<String>().apply {
                                        postValue("NEM")
                                    },
                                    background = MutableLiveData<Int>().apply {
                                        postValue(R.drawable.nem_background)
                                    },
                                    logo = MutableLiveData<Int>().apply {
                                        postValue(R.drawable.ic_nem)
                                    }
                            ),
                            CardViewModel(
                                    title = MutableLiveData<String>().apply {
                                        postValue("Ethereum")
                                    },
                                    background = MutableLiveData<Int>().apply {
                                        postValue(R.drawable.ethereum_background)
                                    },
                                    logo = MutableLiveData<Int>().apply {
                                        postValue(R.drawable.ic_ethereum)
                                    }
                            ),
                            CardViewModel(
                                    title = MutableLiveData<String>().apply {
                                        postValue("Ripple")
                                    },
                                    background = MutableLiveData<Int>().apply {
                                        postValue(R.drawable.ripple_background)
                                    },
                                    logo = MutableLiveData<Int>().apply {
                                        postValue(R.drawable.ic_ripple)
                                    }
                            ),
                            CardViewModel(
                                    title = MutableLiveData<String>().apply {
                                        postValue("Bitcoin")
                                    },
                                    background = MutableLiveData<Int>().apply {
                                        postValue(R.drawable.bitcoin_background)
                                    },
                                    logo = MutableLiveData<Int>().apply {
                                        postValue(R.drawable.ic_bitcoin)
                                    }
                            )
                    )
            )
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = StackCardLayoutManager(5)
        val itemDecor = ItemTouchHelper(
                object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0) {
                    override fun onMove(
                            recyclerView: RecyclerView,
                            viewHolder: RecyclerView.ViewHolder,
                            target: RecyclerView.ViewHolder
                    ): Boolean = true.also { _ ->
                        val fromPos = viewHolder.adapterPosition
                        val toPos = target.adapterPosition
                        adapter.notifyItemMoved(fromPos, toPos)
                    }

                    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    }
                })
        itemDecor.attachToRecyclerView(recyclerView)
    }
}

fun AppCompatActivity.startActivityWithOptions(options: ActivityOptionsCompat, function: (context: Context) -> Intent) {
    startActivity(function(applicationContext), options.toBundle())
}
