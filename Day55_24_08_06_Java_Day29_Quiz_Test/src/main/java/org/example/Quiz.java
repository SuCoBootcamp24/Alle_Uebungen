package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questionList;

    public Quiz() {
        this.questionList = new ArrayList<>();
    }

    //----
    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    //----

    public void addQuestion(Question question) {
        if (this.questionList.contains(question)) throw new IllegalArgumentException("Frage existiert bereits");
        this.questionList.add(question);
    }

    public int askQuestions(User user) {
        int correctAnswers = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Los Gehts!");

        for (Question question : questionList) {
            System.out.println(question.getDescription());
            String[] choices = question.getChoices();
            for (int i = 0; i < choices.length; i++) {
                System.out.println((i + 1) + ": " + choices[i]);
            }
            String[] userChoices = getUserInput(scanner, choices);
            correctAnswers = checkUserChooses(user, question, userChoices, correctAnswers);
        }
        return correctAnswers;
    }

    private int checkUserChooses(User user, Question question, String[] userChoices, int correctAnswers) {
        if (question.answerQuestion(userChoices)) {
            System.out.println("Correct ");
            user.increaseScore();
            correctAnswers++;
        } else {
            System.out.println("False ");
        }
        return correctAnswers;
    }

    private String[] getUserInput(Scanner scanner, String[] choices) {
        System.out.println("Bitte wählen Sie Ihre Antworten (geben Sie die Nummern durch Kommas getrennt ein):\n");
        String input = scanner.nextLine();
        String[] userChoices = parseInput(input, choices);
        return userChoices;
    }

    private String[] parseInput(String input, String[] choices) {
        String[] userChoicesIndex = input.replaceAll("\\s+", "").split(",");
        List<String> answer = new ArrayList<>();
        for (String index : userChoicesIndex) {
            try {
                int index2 = Integer.parseInt(index.trim()) - 1;
                if (index2 >= 0 && index2 < choices.length) {
                    answer.add(choices[index2]);
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println(numberFormatException.getMessage());
            }
        }
        return answer.toArray(new String[0]);
    }

}
