package de.supercode.quizzi.dtos.question;

import jakarta.validation.constraints.NotBlank;

public record AnswerCreateRequestDTO(
        @NotBlank
        String text
) {
}
