package de.supercode.quizzi.services;

import de.supercode.quizzi.dtos.question.QuestionForQuizRequestDTO;
import de.supercode.quizzi.dtos.question.QuestionForQuizResponseDTO;
import de.supercode.quizzi.entities.Answer;
import de.supercode.quizzi.entities.Question;
import de.supercode.quizzi.entities.Quiz;
import de.supercode.quizzi.repositorys.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    QuizRepository quizRepository;

    public QuestionService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    // Eine Question wird immer komplett mit ihren Antworten angelegt
    public QuestionForQuizResponseDTO createNewQuestionForQuiz(QuestionForQuizRequestDTO dto){
        Quiz quiz = quizRepository.findById(dto.quizId()).orElseThrow(()->new NoSuchElementException("Quiz mit der Id: "+ dto.quizId()+ " nicht vorhanden"));

        Question question = new Question();
        question.setQuiz(quiz);
        question.setTheQuestion(dto.questionText());
        quiz.getQuestions().add(question);

        List<Answer> answers = Arrays.stream(dto.answers())
                .map(element -> new Answer(element.text(),question))
                .collect(Collectors.toList());

        question.setCorrectAnswer(answers.get(dto.correctAnswerIndex()));
        question.setAnswers(answers);
        quiz.getQuestions().add(question);
        quizRepository.save(quiz);

        return new QuestionForQuizResponseDTO(quiz.getId());


    }
}
