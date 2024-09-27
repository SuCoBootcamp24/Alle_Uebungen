package de.supercode.quizzi.dtos.question;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record QuestionForQuizRequestDTO(
        long quizId,

        @NotBlank
        String questionText,

        @Valid
        AnswerCreateRequestDTO[] answers,

        @NotNull
        int correctAnswerIndex

) {
}
