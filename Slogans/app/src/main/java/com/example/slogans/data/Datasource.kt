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
            Slogans(R.string.google, R.drawable.googlehq),
            Slogans(R.string.facebook, R.drawable.facebookhq),
            Slogans(R.string.amazon, R.drawable.amazonhq),
            Slogans(R.string.apple, R.drawable.applehq),
            Slogans(R.string.microsoft, R.drawable.microsofthq),
            Slogans(R.string.twitter, R.drawable.twitterhq),
            Slogans(R.string.adidas, R.drawable.adidashq),
            Slogans(R.string.netflix, R.drawable.netflixhq)
        )
    }
}