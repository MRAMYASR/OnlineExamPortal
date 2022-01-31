package com.capg.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capg.exception.QuestionNotFoundException;
import com.capg.model.Question;

public interface QuestionService {

	public Question addQuestion(Question ques);

	public ResponseEntity<List<Question>> getQuestions();

	public ResponseEntity<Question> getQuestionById(int q_id) throws QuestionNotFoundException;

	public ResponseEntity<Question> updateQuestionById(int q_id, Question question) throws QuestionNotFoundException;

	public ResponseEntity<Question> deleteQuestionById(int q_id) throws QuestionNotFoundException;

}
