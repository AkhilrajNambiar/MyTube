// This file is to ensure that however complex the data is, we will return it
// as an iterable List, so the execution part(MainActivity) does not have to freak
// out by handling a huge dataset
// Suppose that the slogans had .csv files of employees, images about the companies and
// so on, MainActivity will never have to worry handling of these data!
package com.example.slogans.data

import com.example.slogans.R
import com.example.slogans.model.Slogans

class Datasource{
    fun loadSlogans(): List<Slogans>{
        return listOf<Slogans>(
            Slogans(R.string.google),
            Slogans(R.string.facebook),
            Slogans(R.string.amazon),
            Slogans(R.string.apple),
            Slogans(R.string.microsoft),
            Slogans(R.string.twitter),
            Slogans(R.string.adidas),
            Slogans(R.string.netflix)
        )
    }
}