package com.example.amiiboapp.data

class SampleDataProvider {

    companion object{
        private val sampleText1 = "Tom Nook - Winter\n"
        private val sampleText2 = ""
        private val sampleText3 = ""
        private val sampleText4 = ""
        private val sampleText5 = "Isabelle - Winter\n"
        private val sampleText6 = ""
        private val sampleText7 = ""
        private val sampleText8 = ""
        private val sampleText9 = "Kapp'n\n"
        private val sampleText10 = ""
        private val sampleText11 = ""
        private val sampleText12 = ""

        fun getAmiibo() = arrayListOf(
            AmiiboEntity(1, sampleText1, sampleText2, sampleText3, sampleText4 ),
            AmiiboEntity(2, sampleText5, sampleText6, sampleText7, sampleText8 ),
            AmiiboEntity(3, sampleText9, sampleText10, sampleText11, sampleText12 )
        )
    }
}