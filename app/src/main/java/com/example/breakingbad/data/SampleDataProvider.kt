package com.example.breakingbad.data

class SampleDataProvider {

    companion object{
        private val sampleText1 = "Walter White"
        private val sampleText2 = "Heisenberg"
        private val sampleText3 = "09-07-1958"
        private val sampleText4 = "Deceased"
        private val sampleText5 = "Bryan Cranston"
        private val sampleText6 = "Jesse Pinkman"
        private val sampleText7 = "Cap N' Cook"
        private val sampleText8 = "09-24-1984"
        private val sampleText9 = "Alive"
        private val sampleText10 = "Aaron Paul"
        private val sampleText11 = "Henry Schrader"
        private val sampleText12 = "Hank"
        private val sampleText13 = "Unknown"
        private val sampleText14 = "Deceased"
        private val sampleText15 = "Dean Norris"


        fun getAmiibo() = arrayListOf(
            CharacterEntity(1, sampleText1, sampleText2, sampleText3, sampleText4, sampleText5 ),
            CharacterEntity(1, sampleText6, sampleText7, sampleText8, sampleText9, sampleText10 ),
            CharacterEntity(1, sampleText11, sampleText12, sampleText13, sampleText14, sampleText15 )
        )
    }
}