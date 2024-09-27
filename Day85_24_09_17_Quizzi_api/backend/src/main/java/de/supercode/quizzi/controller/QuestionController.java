package de.supercode.quizzi.controller;

import de.supercode.quizzi.dtos.question.QuestionForQuizRequestDTO;
import de.supercode.quizzi.dtos.question.QuestionForQuizResponseDTO;
import de.supercode.quizzi.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {
    QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<QuestionForQuizResponseDTO> createNewQuestionForQuiz(@RequestBody @Validated QuestionForQuizRequestDTO dto){
        try {
            //questionService.createNewQuestionForQuiz(dto);
            return ResponseEntity.ok(questionService.createNewQuestionForQuiz(dto));
        }catch(NoSuchElementException ex){
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }catch(Exception ex){
            ex.printStackTrace();
            return ResponseEntity.status(500).build();
        }

    }
}
