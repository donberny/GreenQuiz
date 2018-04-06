package com.example.android.greenquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int score = 0;
    int emptyQuizValidation = 1;
    int badScoreCompare = 2;
    int mediumScoreCompareLow = 3;
    int mediumScoreCompareHigh = 7;
    int perfectScoreCompare = 8;
    String answerCompareQuestionTwo = "Showers";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Submits the answers to know your shade of green.
     *
     * toast message will be displayed depending on the score and the screen will display your shade of green.
     */
    public void submitQuiz(View view) {
        int finalScore = calculateScore();
        int getEmptyQuiz = checkEmptyQuiz();

        if (getEmptyQuiz == emptyQuizValidation) {
            Toast.makeText(this, "Empty quiz, please answer the questions.", Toast.LENGTH_SHORT).show();
        }
        if ((finalScore <= badScoreCompare) && (finalScore >= emptyQuizValidation)) {
            Toast.makeText(this, "You are not one bit green, but you can start the change today.", Toast.LENGTH_SHORT).show();
            finalScore = 0;
            score = 0;
        }
        if ((finalScore >= mediumScoreCompareLow) && (finalScore <= mediumScoreCompareHigh)) {
            Toast.makeText(this, "You are sort of green, but there is room for improvement.", Toast.LENGTH_SHORT).show();
            finalScore = 0;
            score = 0;
        }
        if (finalScore == perfectScoreCompare) {
            Toast.makeText(this, "You are super green! Keep on changing the world!", Toast.LENGTH_SHORT).show();
            score = 0;
        }
    }

    /**
     * Resets the quiz so you can start it over
     *
     */
    public void resetQuiz(View view){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    @Override
    public void finish() {
        super.finish();
    }

    /**
     * Calculates the score.
     *
     * @return int value of overall quiz correct answers
     */
    private int calculateScore() {
        boolean valueQuestionOne = checkQuestion1Three();
        if (valueQuestionOne) {
            score += 1;
        }
        String valueQuestionTwo = checkQuestion2();
        if (valueQuestionTwo.equals(answerCompareQuestionTwo)) {
            score += 1;
        }
        boolean valueQuestionThree = checkQuestion3One();
        if (valueQuestionThree) {
            score += 1;
        }
        boolean valueQuestionFourCheckBoxOne = checkQuestion4One();
        boolean valueQuestionFourCheckBoxTwo = checkQuestion4Two();
        boolean valueQuestionFourCheckBoxThree = checkQuestion4Three();
        boolean valueQuestionFourCheckBoxFour = checkQuestion4Four();
        if ((valueQuestionFourCheckBoxOne)
                && (valueQuestionFourCheckBoxThree)
                && (valueQuestionFourCheckBoxFour)
                && (!valueQuestionFourCheckBoxTwo)) {
            score += 1;
        }
        boolean valueQuestionFive = checkQuestion5One();
        if (valueQuestionFive) {
            score += 1;
        }
        boolean valueQuestionSix = checkQuestion6Two();
        if (valueQuestionSix) {
            score += 1;
        }
        boolean valueQuestionSevenCheckBoxOne = checkQuestion7One();
        boolean valueQuestionSevenCheckBoxTwo = checkQuestion7Two();
        boolean valueQuestionSevenCheckBoxThree = checkQuestion7Three();
        boolean valueQuestionSevenCheckBoxFour = checkQuestion7Four();
        boolean valueQuestionSevenCheckBoxFive = checkQuestion7Five();
        if ((valueQuestionSevenCheckBoxOne)
                && (valueQuestionSevenCheckBoxFive)
                && (!valueQuestionSevenCheckBoxTwo)
                && (!valueQuestionSevenCheckBoxThree)
                && (!valueQuestionSevenCheckBoxFour)) {
            score += 1;
        }
        boolean valueQuestionEight = checkQuestion8Two();
        if (valueQuestionEight) {
            score += 1;
        }

        return score;
    }

    /**
     * Calculates the score.
     *
     * @return int value of overall quiz correct answers
     */
    private int checkEmptyQuiz() {
        boolean valueQuestionOne1 = checkQuestion1One();
        boolean valueQuestionOne2 = checkQuestion1Two();
        boolean valueQuestionOne3 = checkQuestion1Three();

        String valueQuestionTwo = checkQuestion2();

        boolean valueQuestionThree1 = checkQuestion3One();
        boolean valueQuestionThree2 = checkQuestion3Two();
        boolean valueQuestionThree3 = checkQuestion3Three();
        boolean valueQuestionThree4 = checkQuestion3Four();
        boolean valueQuestionThree5 = checkQuestion3Five();

        boolean valueQuestionFourCheckBoxOne = checkQuestion4One();
        boolean valueQuestionFourCheckBoxTwo = checkQuestion4Two();
        boolean valueQuestionFourCheckBoxThree = checkQuestion4Three();
        boolean valueQuestionFourCheckBoxFour = checkQuestion4Four();


        boolean valueQuestionFive1 = checkQuestion5One();
        boolean valueQuestionFive2 = checkQuestion5Two();

        boolean valueQuestionSix1 = checkQuestion6One();
        boolean valueQuestionSix2 = checkQuestion6Two();

        boolean valueQuestionSevenCheckBoxOne = checkQuestion7One();
        boolean valueQuestionSevenCheckBoxTwo = checkQuestion7Two();
        boolean valueQuestionSevenCheckBoxThree = checkQuestion7Three();
        boolean valueQuestionSevenCheckBoxFour = checkQuestion7Four();
        boolean valueQuestionSevenCheckBoxFive = checkQuestion7Five();

        boolean valueQuestionEight1 = checkQuestion8One();
        boolean valueQuestionEight2 = checkQuestion8Two();

        if ((!valueQuestionOne1) && (!valueQuestionOne2) && (!valueQuestionOne3)
                && (valueQuestionTwo.equals(""))
                && (!valueQuestionThree1)
                && (!valueQuestionThree2)
                && (!valueQuestionThree3)
                && (!valueQuestionThree4)
                && (!valueQuestionThree5)
                && (!valueQuestionFourCheckBoxOne)
                && (!valueQuestionFourCheckBoxTwo)
                && (!valueQuestionFourCheckBoxThree)
                && (!valueQuestionFourCheckBoxFour)
                && (!valueQuestionFive1)
                && (!valueQuestionFive2)
                && (!valueQuestionSix1)
                && (!valueQuestionSix2)
                && (!valueQuestionSevenCheckBoxOne)
                && (!valueQuestionSevenCheckBoxTwo)
                && (!valueQuestionSevenCheckBoxThree)
                && (!valueQuestionSevenCheckBoxFour)
                && (!valueQuestionSevenCheckBoxFive)
                && (!valueQuestionEight1)
                && (!valueQuestionEight2)) {
            return 1;
        }

        return 0;
    }

    /**
     * Gets answer 1 to question 1.
     *
     * @return boolean value of incorrect answer 1 for question 1
     */
    private boolean checkQuestion1One() {
        RadioButton getAnswer1One = findViewById(R.id.q1_answer_1_radio_button);
        return getAnswer1One.isChecked();
    }

    /**
     * Gets answer 2 to question 1.
     *
     * @return boolean value of incorrect correct answer 2 for question 1
     */
    private boolean checkQuestion1Two() {
        RadioButton getAnswer1Two = findViewById(R.id.q1_answer_2_radio_button);
        return getAnswer1Two.isChecked();
    }

    /**
     * Gets answer 3 to question 1.
     *
     * @return boolean value of correct answer for question 1
     */
    private boolean checkQuestion1Three() {
        RadioButton getAnswer1Three = findViewById(R.id.q1_answer_3_radio_button);
        return getAnswer1Three.isChecked();
    }

    /**
     * Gets answer to question 2.
     *
     * @return String value of input for question 2
     */
    private String checkQuestion2() {
        EditText getAnswer2 = findViewById(R.id.q2_answer_input);
        return getAnswer2.getText().toString();
    }

    /**
     * Gets answer to question 3.
     *
     * @return boolean value of correct answer for question 3
     */
    private boolean checkQuestion3One() {
        RadioButton getAnswer3One = findViewById(R.id.q3_answer_1_radio_button);
        return getAnswer3One.isChecked();
    }

    /**
     * Gets answer to question 3.
     *
     * @return boolean value of correct answer for question 3
     */
    private boolean checkQuestion3Two() {
        RadioButton getAnswer3Two = findViewById(R.id.q3_answer_2_radio_button);
        return getAnswer3Two.isChecked();
    }

    /**
     * Gets answer to question 3.
     *
     * @return boolean value of correct answer for question 3
     */
    private boolean checkQuestion3Three() {
        RadioButton getAnswer3Three = findViewById(R.id.q3_answer_3_radio_button);
        return getAnswer3Three.isChecked();
    }

    /**
     * Gets answer to question 3.
     *
     * @return boolean value of correct answer for question 3
     */
    private boolean checkQuestion3Four() {
        RadioButton getAnswer3Four = findViewById(R.id.q3_answer_4_radio_button);
        return getAnswer3Four.isChecked();
    }

    /**
     * Gets answer to question 3.
     *
     * @return boolean value of correct answer for question 3
     */
    private boolean checkQuestion3Five() {
        RadioButton getAnswer3Five = findViewById(R.id.q3_answer_5_radio_button);
        return getAnswer3Five.isChecked();
    }

    /**
     * Gets check box 1 to question 4.
     *
     * @return boolean value of check box 1 for question 4
     */
    private boolean checkQuestion4One() {
        CheckBox getAnswer4One = findViewById(R.id.q4_answer_1_checkbox);
        return getAnswer4One.isChecked();
    }

    /**
     * Gets check box 2 to question 4.
     *
     * @return boolean value of check box 2 for question 4
     */
    private boolean checkQuestion4Two() {
        CheckBox getAnswer4Two = findViewById(R.id.q4_answer_2_checkbox);
        return getAnswer4Two.isChecked();
    }

    /**
     * Gets check box 3 to question 4.
     *
     * @return boolean value of check box 3 for question 4
     */
    private boolean checkQuestion4Three() {
        CheckBox getAnswer4Three = findViewById(R.id.q4_answer_3_checkbox);
        return getAnswer4Three.isChecked();
    }

    /**
     * Gets check box 4 to question 4.
     *
     * @return boolean value of check box 4 for question 4
     */
    private boolean checkQuestion4Four() {
        CheckBox getAnswer4Four = findViewById(R.id.q4_answer_4_checkbox);
        return getAnswer4Four.isChecked();
    }

    /**
     * Gets answer to question 5.
     *
     * @return boolean value of correct answer for question 5
     */
    private boolean checkQuestion5One() {
        RadioButton getAnswer5One = findViewById(R.id.q5_answer_1_radio_button);
        return getAnswer5One.isChecked();
    }

    /**
     * Gets answer to question 5.
     *
     * @return boolean value of incorrect answer for question 5
     */
    private boolean checkQuestion5Two() {
        RadioButton getAnswer5Two = findViewById(R.id.q5_answer_2_radio_button);
        return getAnswer5Two.isChecked();
    }

    /**
     * Gets answer to question 6.
     *
     * @return boolean value of correct answer for question 6
     */
    private boolean checkQuestion6One() {
        RadioButton getAnswer6One = findViewById(R.id.q6_answer_1_radio_button);
        return getAnswer6One.isChecked();
    }

    /**
     * Gets answer to question 6.
     *
     * @return boolean value of correct answer for question 6
     */
    private boolean checkQuestion6Two() {
        RadioButton getAnswer6Two = findViewById(R.id.q6_answer_2_radio_button);
        return getAnswer6Two.isChecked();
    }

    /**
     * Gets check box 1 to question 7.
     *
     * @return boolean value of check box 1 for question 7
     */
    private boolean checkQuestion7One() {
        CheckBox getAnswer7One = findViewById(R.id.q7_answer_1_checkbox);
        return getAnswer7One.isChecked();
    }

    /**
     * Gets check box 2 to question 7.
     *
     * @return boolean value of check box 2 for question 7
     */
    private boolean checkQuestion7Two() {
        CheckBox getAnswer7Two = findViewById(R.id.q7_answer_2_checkbox);
        return getAnswer7Two.isChecked();
    }

    /**
     * Gets check box 3 to question 7.
     *
     * @return boolean value of check box 3 for question 7
     */
    private boolean checkQuestion7Three() {
        CheckBox getAnswer7Three = findViewById(R.id.q7_answer_3_checkbox);
        return getAnswer7Three.isChecked();
    }

    /**
     * Gets check box 4 to question 7.
     *
     * @return boolean value of check box 4 for question 7
     */
    private boolean checkQuestion7Four() {
        CheckBox getAnswer7Four = findViewById(R.id.q7_answer_4_checkbox);
        return getAnswer7Four.isChecked();
    }

    /**
     * Gets check box 5 to question 7.
     *
     * @return boolean value of check box 5 for question 7
     */
    private boolean checkQuestion7Five() {
        CheckBox getAnswer7Five = findViewById(R.id.q7_answer_5_checkbox);
        return getAnswer7Five.isChecked();
    }

    /**
     * Gets answer to question 8.
     *
     * @return boolean value of incorrect answer for question 8
     */
    private boolean checkQuestion8One() {
        RadioButton getAnswer8One = findViewById(R.id.q8_answer_1_radio_button);
        return getAnswer8One.isChecked();
    }

    /**
     * Gets answer to question 8.
     *
     * @return boolean value of correct answer for question 8
     */
    private boolean checkQuestion8Two() {
        RadioButton getAnswer8Two = findViewById(R.id.q8_answer_2_radio_button);
        return getAnswer8Two.isChecked();
    }
}
