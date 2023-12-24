package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int userScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Initialize questions
        questions = new ArrayList<>();
        questions.add(new Question("What is the average lifespan of a dog?", new String[]{"8-10 years", "10-12 years", "12-15 years"}, 2));
        questions.add(new Question("What is the scientific name for a cat?", new String[]{"Canis lupus familiaris", "Felis catus", "Equus ferus caballus"}, 1));
        // Add more questions...

        // Set up UI components
        final TextView questionTextView = findViewById(R.id.questionTextView);
        final RadioGroup optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        final Button nextButton = findViewById(R.id.nextButton);

        // Display the first question
        displayQuestion(questionTextView, optionsRadioGroup, nextButton);
    }

    private void displayQuestion(final TextView questionTextView, final RadioGroup optionsRadioGroup, final Button nextButton) {
        if (currentQuestionIndex < questions.size()) {
            final Question currentQuestion = questions.get(currentQuestionIndex);

            // Update UI components with the current question and options
            questionTextView.setText(currentQuestion.getQuestionText());
            optionsRadioGroup.removeAllViews();
            for (int i = 0; i < currentQuestion.getOptions().length; i++) {
                RadioButton radioButton = new RadioButton(this);
                radioButton.setText(currentQuestion.getOptions()[i]);
                optionsRadioGroup.addView(radioButton);
            }

            // Handle "Next" button click
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int selectedOptionIndex = optionsRadioGroup.indexOfChild(findViewById(optionsRadioGroup.getCheckedRadioButtonId()));

                    // Handle the selected option (e.g., compare with correct option, store user response)
                    if (selectedOptionIndex == currentQuestion.getCorrectOptionIndex()) {
                        // User selected the correct option
                        userScore++;
                    }

                    // Move to the next question
                    currentQuestionIndex++;
                    displayQuestion(questionTextView, optionsRadioGroup, nextButton);
                }
            });
        } else {
            // Quiz completed
            displayResult();
        }
    }

    private void displayResult() {
        // Calculate the percentage score
        int totalQuestions = questions.size();
        int percentageScore = (userScore * 100) / totalQuestions;

        // Display the result
        Toast.makeText(this, "Quiz completed!\nYour Score: " + percentageScore + "%", Toast.LENGTH_SHORT).show();

        // You can customize this part to handle the result in your app (e.g., show a result screen, save the score, etc.)
    }
}

