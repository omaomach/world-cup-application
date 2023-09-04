package com.omao.worldcupapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1- Adapter View: ListView(lv)
        var lv: ListView = findViewById(R.id.lv)

        // 2- Adapter: MyAdapter
        var adapter = MyAdapter(this, generateData())

        lv?.adapter = adapter
        adapter?.notifyDataSetChanged()

    }

    // 3- Data Source
    fun generateData(): ArrayList<CountryModel> {
        var countryList = ArrayList<CountryModel>()

        var country1: CountryModel = CountryModel(
            "Brazil",
            "5",
            R.drawable.brazil
        )

        var country2: CountryModel = CountryModel(
            "Germany",
            "4",
            R.drawable.germany
        )

        var country3: CountryModel = CountryModel(
            "France",
            "2",
            R.drawable.france
        )

        var country4: CountryModel = CountryModel(
            "Spain",
            "1",
            R.drawable.spain
        )

        var country5: CountryModel = CountryModel(
            "England",
            "1",
            R.drawable.unitedkingdom
        )

        var country6: CountryModel = CountryModel(
            "United States",
            "0",
            R.drawable.unitedstates
        )

        var country7: CountryModel = CountryModel(
            "Saudi Arabia",
            "0",
            R.drawable.saudiarabia
        )

        countryList.add(country1)
        countryList.add(country2)
        countryList.add(country3)
        countryList.add(country4)
        countryList.add(country5)
        countryList.add(country6)
        countryList.add(country7)

        return countryList


    }

}