package de.supercode.quizzi.services;

import de.supercode.quizzi.dtos.quiz.QuizCreateRequestDTO;
import de.supercode.quizzi.dtos.quiz.QuizCreateResponseDTO;
import de.supercode.quizzi.dtos.quiz.QuizGetAllResponseDTO;
import de.supercode.quizzi.dtos.quiz.QuizPublicGetAllDTO;
import de.supercode.quizzi.entities.Quiz;
import de.supercode.quizzi.repositorys.QuizRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class QuizService {
    QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    // Wir wollen ein Quiz anlegen
    public QuizCreateResponseDTO createNewQuiz(QuizCreateRequestDTO dto){
        Quiz quiz = new Quiz(dto.title());
        quiz = quizRepository.save(quiz);
        QuizCreateResponseDTO response = new QuizCreateResponseDTO(quiz.getId(),quiz.getTitle());
        return response;
    }

    // Wir wollen alle public Quize ausgeben
    public List<QuizPublicGetAllDTO> getAllPublicQuizze(){
        List<Quiz> quizList= quizRepository.findAllByIsPublicTrue();

        return quizList.stream()
                .map(element->{ return new QuizPublicGetAllDTO(element.getId(),element.getTitle(),element.getQuestionCount());})
                .collect(Collectors.toList());

    }

    // Wir wollen ein bestimmtes Quiz löschen
    public void deleteQuizById(long id){
        quizRepository.deleteById(id);
    }


    // Wir wollen den Status ändern
    @Transactional
    public void switchIsPublic(long quizId){
        Quiz quiz = quizRepository.findById(quizId).orElseThrow(()->new NoSuchElementException("Quiz mit der Id: " + quizId + " nicht vorhanden"));

        quiz.setPublic(!quiz.isPublic());
    }

    public List<QuizGetAllResponseDTO> getAllQuizze(){
        List<Quiz> quizList = quizRepository.findAll();

        return quizList
                .stream()
                .map(element->{
                    return new QuizGetAllResponseDTO(element.getId(), element.getTitle(), element.isPublic());})
                .collect(Collectors.toList());
    }
}
