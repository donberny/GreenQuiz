package com.example.android.greenquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int score = 0;
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

        if (finalScore <= badScoreCompare) {
            Toast.makeText(this, "You are not one bit green, but you can start the change today.", Toast.LENGTH_SHORT).show();
        }
        if ((finalScore >= mediumScoreCompareLow) && (finalScore <= mediumScoreCompareHigh)) {
            Toast.makeText(this, "You are sort of green, but there is room for improvement.", Toast.LENGTH_SHORT).show();
        }
        if (finalScore == perfectScoreCompare) {
            Toast.makeText(this, "You are super green! Keep on changing the world!", Toast.LENGTH_SHORT).show();
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
        boolean valueQuestionOne = checkQuestion1();
        if (valueQuestionOne) {
            score += 1;
        }
        String valueQuestionTwo = checkQuestion2();
        if (valueQuestionTwo.equals(answerCompareQuestionTwo)) {
            score += 1;
        }
        boolean valueQuestionThree = checkQuestion3();
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
        boolean valueQuestionFive = checkQuestion5();
        if (valueQuestionFive) {
            score += 1;
        }
        boolean valueQuestionSix = checkQuestion6();
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
        boolean valueQuestionEight = checkQuestion8();
        if (valueQuestionEight) {
            score += 1;
        }

        return score;
    }

    /**
     * Gets answer to question 1.
     *
     * @return boolean value of correct answer for question 1
     */
    private boolean checkQuestion1() {
        RadioButton getAnswer1 = findViewById(R.id.q1_answer_3_radio_button);
        return getAnswer1.isChecked();
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
    private boolean checkQuestion3() {
        RadioButton getAnswer3 = findViewById(R.id.q3_answer_1_radio_button);
        return getAnswer3.isChecked();
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
    private boolean checkQuestion5() {
        RadioButton getAnswer5 = findViewById(R.id.q5_answer_1_radio_button);
        return getAnswer5.isChecked();
    }

    /**
     * Gets answer to question 6.
     *
     * @return boolean value of correct answer for question 6
     */
    private boolean checkQuestion6() {
        RadioButton getAnswer6 = findViewById(R.id.q6_answer_2_radio_button);
        return getAnswer6.isChecked();
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
     * @return boolean value of correct answer for question 8
     */
    private boolean checkQuestion8() {
        RadioButton getAnswer8 = findViewById(R.id.q8_answer_2_radio_button);
        return getAnswer8.isChecked();
    }
}
