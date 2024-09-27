package de.supercode.quizzi.repositorys;

import de.supercode.quizzi.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
