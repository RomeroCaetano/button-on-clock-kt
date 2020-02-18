package com.example.expobre.Model

import java.util.Random

object MegaSena{
    fun getInstance() : List<Int>{
        val random = Random()
        var numbers = mutableSetOf<Int>()

        while( numbers.size < 6){
            numbers.add(random.nextInt(60)+1)
        }
        return numbers.sorted()
    }
}