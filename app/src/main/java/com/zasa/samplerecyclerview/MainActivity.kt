package com.zasa.samplerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

data class Person(var name: String, var age: Int)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 6 steps to make recyclerView
        // 1. Add recyclerview androidx library to build.gradle file - DONE
        // 2. define a model class to use as a data source - DONE
        val contacts = createPerson()
        // 3. add a recyclerview to activity main or in your layout file that display the view to display the items - DONE
        // 4. create a custom raw layout XML file to visualize the item or card -DONE
        // 5. create a RecyclerView.Adapter and ViewHolder to render an item
        rvContacts.adapter = ContactsAdapter(this, contacts)

        // 6. Bind the adapter to the data source to populate the RecyclerView
        rvContacts.layoutManager = LinearLayoutManager(this)


    }

    fun createPerson() : List<Person>{
        val persons = mutableListOf<Person>()
        for (i in 1..100){
            persons.add(Person("Person $i", i))
        }
        return persons
    }
}