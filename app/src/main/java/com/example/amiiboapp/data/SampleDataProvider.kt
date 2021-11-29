package com.example.amiiboapp.data

class SampleDataProvider {

    companion object{
        private val sampleText1 = "Tom Nook - Winter\n"
        private val sampleText2 = "Tom Nook"
        private val sampleText3 = "Animal Crossing"
        private val sampleText4 = "Isabelle - Winter"
        private val sampleText5 = "Isabelle"
        private val sampleText6 = "Animal Crossing"
        private val sampleText7 = "Kapp'n"
        private val sampleText8 = "Kapp'n"
        private val sampleText9 = "Animal Crossing"

        fun getAmiibo() = arrayListOf(
            AmiiboEntity(1, sampleText1, sampleText2, sampleText3 ),
            AmiiboEntity(2, sampleText4, sampleText5, sampleText6 ),
            AmiiboEntity(3, sampleText7, sampleText8, sampleText9 )
        )
    }
}