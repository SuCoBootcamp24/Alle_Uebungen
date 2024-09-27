package de.supercode.quizzi.dtos.quiz;

import jakarta.validation.constraints.NotBlank;

public record QuizCreateRequestDTO(
        @NotBlank
        String title
) {

}
