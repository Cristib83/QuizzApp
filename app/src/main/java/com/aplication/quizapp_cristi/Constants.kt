package com.aplication.quizapp_cristi

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTION: String = "total_question"
    const val CORRECT_ANSWER:String = "correct_answer"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()


        val que1 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Austria",
            "Armenia",
            "Australia",
            "Argentina",
            3
        )
        questionsList.add(que1)

        val que2 = Question(
            2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Austria",
            "Armenia",
            "Australia",
            "Argentina",
            4,
        )
        questionsList.add(que2)

        val que3 = Question(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Brazil",
            "Kuwait",
            "Germany",
            "Belgium",
            4
        )
        questionsList.add(que3)

        val que4 = Question(
            4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Brazil",
            "Kuwait",
            "Germany",
            "Belgium",
            1,
        )
        questionsList.add(que4)

        val que5 = Question(
            5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Island",
            "Denmark",
            "Norway",
            "England",
            2,
        )
        questionsList.add(que5)

        val que6 = Question(
            6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Ecuador",
            "Georgia",
            "Fiji",
            "Gibraltar",
            3,
        )
        questionsList.add(que6)

        val que7 = Question(
            7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Austria",
            "Belgium",
            "Germany",
            "Italy",
            3,
        )
        questionsList.add(que7)

        val que8 = Question(
            8,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Armenia",
            "Pakistan",
            "India",
            "Qazaqstan",
            3,
        )
        questionsList.add(que8)

        val que9 = Question(
            9,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Brazil",
            "Kuwait",
            "Cuba",
            "Panama",
            2,
        )
        questionsList.add(que9)

        val que10 = Question(
            4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "New Zeeland",
            "Island",
            "Ireland",
            "England",
            1,
        )
        questionsList.add(que10)

        return questionsList
    }
}