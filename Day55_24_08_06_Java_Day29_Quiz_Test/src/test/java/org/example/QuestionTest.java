package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    @Test
    void answerQuestion() {
       String[] choices = { "Luxemburg", "Angola", "Berlin", "NRW" };
       String[] correctChoices = { "Luxemburg" };
       String[] chosen = { "Luxemburg" };

       Question question = new Question( "Was ist die Hauptstadt von Luxemburg?", choices, correctChoices);

       assertTrue(question.answerQuestion(chosen));
    }

    @Test
    void answerQuestionIncorrect() {
        String[] choices = { "Luxemburg", "Angola", "Berlin", "NRW" };
        String[] correctChoices = { "Luxemburg" };
        String[] chosen = { "Hamburg" };

        Question question = new Question( "Was ist die Hauptstadt von Luxemburg?", choices, correctChoices);

        assertFalse(question.answerQuestion(chosen));

    }

    @Test
    void AnswerQuestionMoreChoicesAssCorrect() {
        String[] choices = { "Luxemburg", "Angola", "Berlin", "NRW" };
        String[] correctChoices = { "Luxemburg", };
        String[] chosen = { "" };

        Question question = new Question( "Was ist die Hauptstadt von Luxemburg?", choices, correctChoices);

        assertFalse(question.answerQuestion(chosen));

    }


    @Test
    void setDescriptionWrongText() {
        String[] choices = { "Luxemburg", "Angola", "Berlin", "NRW" };
        String[] correctChoices = { "Luxemburg", };

        assertThrows(IllegalArgumentException.class, () -> { Question question = new Question( "Was ist die Hauptstadt von Luxemburg", choices, correctChoices);});
    }

    @Test
    void setCorrectChoicesWithNullCorrectChoices() {
        String[] choices = { "Luxemburg" };

        assertThrows(IllegalArgumentException.class, () -> { Question question = new Question( "Was ist die Hauptstadt von Luxemburg", choices, null);});
    }

    @Test
    void setCorrectChoicesWithMoreCorrectChoicesAsChoicesOptions() {
        String[] choices = { "Luxemburg" };
        String[] correctChoices = { "Luxemburg", "Hamburg"};

        assertThrows(IllegalArgumentException.class, () -> { Question question = new Question( "Was ist die Hauptstadt von Luxemburg", choices, correctChoices);});
    }

    @Test
    void setUnknownChoiceInCorrectChoices() {
        String[] choices = { "Luxemburg", "Angola", "Berlin", "NRW" };
        String[] correctChoices = { "Luxemburg", "Hamburg"};

        assertThrows(IllegalArgumentException.class, () -> { Question question = new Question( "Was ist die Hauptstadt von Luxemburg", choices, correctChoices);});
    }


}