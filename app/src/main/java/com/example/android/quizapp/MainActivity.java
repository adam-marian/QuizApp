package com.example.android.quizapp;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
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

        checkAnswer(R.id.q1_a1, R.id.q1_a2, R.id.q1_a3, R.id.q1_a4, true, false, false, true);

    }

    public void checkQuestion2(View view) {

        checkAnswer(R.id.q2_a1, R.id.q2_a2, R.id.q2_a3, R.id.q2_a4, true, false, true, true);

    }

    public void checkQuestion3(View view) {

        checkAnswer(R.id.q3_a1, R.id.q3_a2, R.id.q3_a3, R.id.q3_a4, true, false, true, true);

    }

    public void checkQuestion4(View view) {

        if (getRadioButtonState(R.id.q4_a1)) {
            Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.incorrect, Toast.LENGTH_SHORT).show();
        }
    }

    public void checkQuestion5(View view) {

        if (getRadioButtonState(R.id.q5_a3)) {
            Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.incorrect, Toast.LENGTH_SHORT).show();
        }
    }

    public void checkQuestion6(View view) {

        if (getRadioButtonState(R.id.q6_a2)) {
            Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.incorrect, Toast.LENGTH_SHORT).show();
        }
    }

    public void checkQuestion7(View view) {

        if (getEditText(R.id.nameField).equalsIgnoreCase(getString(R.string.edittext_answer))) {
            Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.incorrect, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method checks all questions and shows a toast with overall score.
     */

    public void getScore(View view) {

        // create score variable

        int score = 0;

        //question 1
        if (isCheckboxCorrect(R.id.q1_a1, R.id.q1_a2, R.id.q1_a3, R.id.q1_a4, true, false, false, true)) {
            score++;
        }

        //question 2
        if (isCheckboxCorrect(R.id.q2_a1, R.id.q2_a2, R.id.q2_a3, R.id.q2_a4, true, false, true, true)) {
            score++;
        }

        //question 3
        if (isCheckboxCorrect(R.id.q3_a1, R.id.q3_a2, R.id.q3_a3, R.id.q3_a4, true, false, true, true)) {
            score++;
        }

        //question 4
        if (getRadioButtonState(R.id.q4_a1)) {
            score++;
        }

        //question 5
        if (getRadioButtonState(R.id.q5_a3)) {
            score++;
        }

        //question 6
        if (getRadioButtonState(R.id.q6_a2)) {
            score++;
        }

        if (getEditText(R.id.nameField).equalsIgnoreCase(getString(R.string.edittext_answer))) {
            score++;
        }

        String displayScore = "Congratulations! ";

        if (score == 7) {
            displayScore += "You got 7 out of 7!You really know your way around Middle Earth!!";
        } else if (score < 7 && score > 3) {
            displayScore += "You got " + score + " out of 7.";
        } else {
            displayScore = "You got " + score + " out of 7." + "You must be taken to Isengard!!!";
        }
        Toast.makeText(this, displayScore, Toast.LENGTH_LONG).show();
    }


    private void checkAnswer(int id1, int id2, int id3, int id4, boolean answer1, boolean answer2, boolean answer3, boolean answer4) {

        // display correct if the answer is right
        if (isCheckboxCorrect(id1, id2, id3, id4, answer1, answer2, answer3, answer4)) {
            Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show();
        }
        // Otherwise it displays incorrect
        else {
            Toast.makeText(this, R.string.incorrect, Toast.LENGTH_SHORT).show();
        }

    }


    private boolean isCheckboxCorrect(int id1, int id2, int id3, int id4, boolean answer1, boolean answer2, boolean answer3, boolean answer4) {
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

    private boolean getRadioButtonState(int radioButtonId) {
        RadioButton currentRadioButton = (RadioButton) findViewById(radioButtonId);
        return currentRadioButton.isChecked();
    }

    private String getEditText(int editTextId) {
        EditText currentEditText = (EditText) findViewById(editTextId);
        return currentEditText.getText().toString();
    }

}