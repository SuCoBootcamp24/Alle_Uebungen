package de.supercode.quizzi.dtos.quiz;

public record QuizGetAllResponseDTO(
        long quizId,
        String title,
        boolean isPublic
) {
}
