package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    private val _score = MutableLiveData(0)
    val score: LiveData<Int> get()= _score
    private val _currentWordCount = MutableLiveData(0)
    val currentWordCount:LiveData<Int> get() = _currentWordCount
    private val _currentScrambledWord = MutableLiveData<String>()
    val currentScrambledWord: LiveData<String> get() = _currentScrambledWord
    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord:String
    init {
        Log.d("GameFragment", "GameViewModel created")
        getNextWord()
    }

    private fun getNextWord(){
        currentWord = allWordsList.random()
        val scrambled = currentWord.toCharArray()

        //Shuffle the letters till you get a scrambled word
        while(String(scrambled).equals(currentWord, false)){
            scrambled.shuffle()
        }
        if(wordsList.contains(currentWord)){
            getNextWord()
        }
        else{
            _currentScrambledWord.value = String(scrambled)
            _currentWordCount.value = (_currentWordCount.value)?.inc()
            wordsList.add(currentWord)
        }
    }

    fun nextWord():Boolean{
        if( _currentWordCount.value!! < MAX_NO_OF_WORDS){
            getNextWord()
            return true
        }
        return false
    }

    private fun increaseScore(){
        _score.value = (_score.value)?.plus(SCORE_INCREASE)
    }
    fun isUserWordCorrect(playerWord: String) : Boolean{
        if( playerWord.equals(currentWord, true)){
            increaseScore()
            return true
        }
        return false
    }

    fun reinitializeData(){
        _score.value = 0
        _currentWordCount.value = 0
        wordsList.clear()
        getNextWord()
    }
}