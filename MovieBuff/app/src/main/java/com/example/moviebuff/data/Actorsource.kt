package com.example.moviebuff.data

import com.example.moviebuff.R
import com.example.moviebuff.model.actorModel

class Actorsource {
    fun actorsList():List<actorModel>{
        return listOf(
            actorModel(R.string.mohanlal, R.drawable.mohanlal),
            actorModel(R.string.mammootty, R.drawable.mammootty),
            actorModel(R.string.amitabh, R.drawable.amitabh),
            actorModel(R.string.jack, R.drawable.jack),
            actorModel(R.string.ddl, R.drawable.ddl),
            actorModel(R.string.leo, R.drawable.leonardo),
            actorModel(R.string.kamalHassan, R.drawable.kamal_hassan),
            actorModel(R.string.shahrukh, R.drawable.shahrukh),
            actorModel(R.string.akshay, R.drawable.akshay_kumar),
            actorModel(R.string.hritik, R.drawable.hritik),
            actorModel(R.string.vijay, R.drawable.vijay)
        )
    }
}