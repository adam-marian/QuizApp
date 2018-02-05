package com.example.android.quizapp;

import android.widget.CheckBox;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkQuestion1(View view) {

        checkCheckboxQuestion(R.id.q1_a1, R.id.q1_a2, R.id.q1_a3, R.id.q1_a4, false, false, false, true);

    }

    public void checkQuestion2(View view) {

        checkCheckboxQuestion(R.id.q2_a1, R.id.q2_a2, R.id.q2_a3, R.id.q2_a4, false, false, false, true);

    }

    public void checkQuestion3(View view) {

        checkCheckboxQuestion(R.id.q3_a1, R.id.q3_a2, R.id.q3_a3, R.id.q3_a4, false, true, false, false);

    }


    public void checkQuestion4(View view) {

        checkCheckboxQuestion(R.id.q4_a1, R.id.q4_a2, R.id.q4_a3, R.id.q4_a4, true, false, false, false);

    }


    public void checkQuestion5(View view) {

        checkCheckboxQuestion(R.id.q5_a1, R.id.q5_a2, R.id.q5_a3, R.id.q5_a4, false, false, false, true);

    }


    /**
     * This method checks all questions and shows a toast with overall score.
     */

    public void getScore(View view) {

        if (
                !isAnsweredCheckbox(R.id.q1_a1, R.id.q1_a2, R.id.q1_a3, R.id.q1_a4)
                        ||
                        !isAnsweredCheckbox(R.id.q2_a1, R.id.q2_a2, R.id.q2_a3, R.id.q2_a4)
                        ||
                        !isAnsweredCheckbox(R.id.q3_a2, R.id.q3_a2, R.id.q3_a3, R.id.q3_a4)
                        ||
                        !isAnsweredCheckbox(R.id.q4_a1, R.id.q4_a2, R.id.q4_a3, R.id.q4_a4)
                        ||
                        !isAnsweredCheckbox(R.id.q5_a1, R.id.q5_a2, R.id.q5_a3, R.id.q5_a4)
                ) {
            Toast.makeText(this, R.string.missing, Toast.LENGTH_SHORT).show();
            return;
        }

        // create score variable
        int score = 0;

        // evaluate the answers and add 1 to the score variable if the answer is correct

        //question 1
        if (isCorrectCheckbox(R.id.q1_a1, R.id.q1_a2, R.id.q1_a3, R.id.q1_a4, false, false, false, true)) {
            score++;
        }

        //question 2
        if (isCorrectCheckbox(R.id.q2_a1, R.id.q2_a2, R.id.q2_a3, R.id.q2_a4, false, false, false, true)) {
            score++;
        }

        //question 3
        if (isCorrectCheckbox(R.id.q3_a1, R.id.q3_a2, R.id.q3_a3, R.id.q3_a4, false, true, false, false)) {
            score++;
        }

        //question 4
        if (isCorrectCheckbox(R.id.q4_a1, R.id.q4_a2, R.id.q4_a3, R.id.q4_a4, true, false, false, false)) {
            score++;
        }

        //question 5
        if (isCorrectCheckbox(R.id.q5_a1, R.id.q5_a2, R.id.q5_a3, R.id.q5_a4, false, false, false, true)) {
            score++;
        }


        String displayScore = "You correctly answered " + score + " questions out of 5.";

        Toast.makeText(this, displayScore, Toast.LENGTH_LONG).show();

    }

    /**
     * This method checks whether a checkbox question is answered or not.
     *
     * @param checkboxId1 - first checkbox id
     * @param checkboxId2 - second checkbox id
     * @param checkboxId3 - third checkbox id
     * @param checkboxId4 - fourth checkbox id
     * @return boolean true if the question is answered, false in case the answer is missing.
     */

    private boolean isAnsweredCheckbox(int checkboxId1, int checkboxId2, int checkboxId3, int checkboxId4) {
        if (!getCheckboxState(checkboxId1) && !getCheckboxState(checkboxId2) && !getCheckboxState(checkboxId3) && !getCheckboxState(checkboxId4)) {
            return false;
        } else {
            return true;
        }
    }


    private void checkCheckboxQuestion(int id1, int id2, int id3, int id4, boolean answer1, boolean answer2, boolean answer3, boolean answer4) {

        // display correct if the answer is right

        if (isCorrectCheckbox(id1, id2, id3, id4, answer1, answer2, answer3, answer4)) {
            Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show();
        }

        // Otherwise it displays incorrect
        else {
            Toast.makeText(this, R.string.incorrect, Toast.LENGTH_SHORT).show();
        }

    }


    private boolean isCorrectCheckbox(int id1, int id2, int id3, int id4, boolean answer1, boolean answer2, boolean answer3, boolean answer4) {


        if ((getCheckboxState(id1) == answer1) && (getCheckboxState(id2) == answer2) && (getCheckboxState(id3) == answer3) && (getCheckboxState(id4) == answer4)) {
            return true;
        } else {
            return false;
        }

    }


    private boolean getCheckboxState(int checkboxId) {
        CheckBox currentCheckBox = (CheckBox) findViewById(checkboxId);
        return currentCheckBox.isChecked();
    }


}