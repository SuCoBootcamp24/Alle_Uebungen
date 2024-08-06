package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class QuizTest {

    private Quiz quiz;
    private User user;
    private Question question1;
    private Question question2;

    @BeforeEach
    void setUp() {
        quiz = new Quiz();
        user = new User("TestUser");

        // Frage 1: Eine korrekte Antwort
        String[] choices1 = {"Berlin", "Hamburg", "München", "Köln"};
        String[] correctChoices1 = {"Berlin"};
        question1 = new Question("Was ist die Hauptstadt von Deutschland?", choices1, correctChoices1);

        // Frage 2: Zwei korrekte Antworten
        String[] choices2 = {"1", "2", "3", "4"};
        String[] correctChoices2 = {"1", "3"};
        question2 = new Question("Wählen Sie die Primzahlen?", choices2, correctChoices2);

        quiz.addQuestion(question1);
        quiz.addQuestion(question2);
    }


    @Test
    void addQuestionNewQuestion() {
        quiz.addQuestion(question1);

        assertEquals(1, quiz.getQuestionList().size());
    }

    @Test
    void addQuestionDublicatedQuestion() {
        quiz.addQuestion(question1);
        assertThrows(IllegalArgumentException.class, () -> quiz.addQuestion(question1));
    }



    @Test
    void testAskQuestions_AllCorrect() {
        // Simulieren der Benutzereingaben für alle korrekten Antworten
        System.setIn(new java.io.ByteArrayInputStream("1\n1,3\n".getBytes()));

        int correctAnswers = quiz.askQuestions(user);

        assertEquals(2, correctAnswers);
        assertEquals(2, user.getScore());
    }

    @Test
    void testAskQuestions_SomeCorrect() {
        // Simulieren der Benutzereingaben für eine teilweise korrekte Antwort
        System.setIn(new java.io.ByteArrayInputStream("1\n2,3\n".getBytes()));

        int correctAnswers = quiz.askQuestions(user);

        assertEquals(1, correctAnswers);
        assertEquals(1, user.getScore());
    }

    @Test
    void testAskQuestions_NoneCorrect() {
        // Simulieren der Benutzereingaben für keine korrekten Antworten
        System.setIn(new java.io.ByteArrayInputStream("2\n4\n".getBytes()));

        int correctAnswers = quiz.askQuestions(user);

        assertEquals(0, correctAnswers);
        assertEquals(0, user.getScore());
    }

}