package de.supercode.quizzi.dtos.quiz;

public record QuizPublicGetAllDTO(
        long quizId,
        String title,
        int questionCount
) {
}
