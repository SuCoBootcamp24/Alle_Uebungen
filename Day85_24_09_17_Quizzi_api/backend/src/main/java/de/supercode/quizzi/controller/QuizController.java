package de.supercode.quizzi.controller;

import de.supercode.quizzi.dtos.quiz.QuizCreateRequestDTO;
import de.supercode.quizzi.dtos.quiz.QuizCreateResponseDTO;
import de.supercode.quizzi.dtos.quiz.QuizGetAllResponseDTO;
import de.supercode.quizzi.dtos.quiz.QuizPublicGetAllDTO;
import de.supercode.quizzi.services.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {
    QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public ResponseEntity<QuizCreateResponseDTO> createNewQuiz(@RequestBody @Validated QuizCreateRequestDTO dto){

        return ResponseEntity.status(HttpStatus.CREATED).body(quizService.createNewQuiz(dto));
    }

    @PutMapping("/{quizId}")
    public ResponseEntity switchQuizIsPublic(@PathVariable long quizId){
        try{
            quizService.switchIsPublic(quizId);
            return ResponseEntity.ok().build();
        }catch(NoSuchElementException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping
    public ResponseEntity<List<QuizGetAllResponseDTO>> getAllQuizze(){
        return ResponseEntity.ok(quizService.getAllQuizze());
    }

    @GetMapping("/public")
    public ResponseEntity<List<QuizPublicGetAllDTO>> getAllPublicQuizze(){
        return ResponseEntity.ok(quizService.getAllPublicQuizze());
    }
}
