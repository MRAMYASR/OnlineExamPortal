package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capg.exception.QuestionNotFoundException;
import com.capg.model.Question;
import com.capg.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	public Question addQuestion(Question ques) {
		Question q = questionRepository.save(ques);
		return q;
	}

	@Override
	public ResponseEntity<List<Question>> getQuestions() {
		List<Question> questions = questionRepository.findAll();
		return ResponseEntity.ok().body(questions);
	}

	@Override
	public ResponseEntity<Question> getQuestionById(int q_id) throws QuestionNotFoundException {
		Question question = questionRepository.findById(q_id)
				.orElseThrow(() -> new QuestionNotFoundException("Q_ID :: " + q_id + " Not Found"));
		return ResponseEntity.ok().body(question);
				
	}

	@Override
	public ResponseEntity<Question> updateQuestionById(int q_id, Question question) throws QuestionNotFoundException {
		Question newQuestion = questionRepository.findById(q_id)
				.orElseThrow(() -> new QuestionNotFoundException("Q_ID:: " + q_id + " Not Found"));
		newQuestion.setQ_name(question.getQ_name());
		newQuestion.setOption_a(question.getOption_a());
		newQuestion.setOption_b(question.getOption_b());
		newQuestion.setOption_c(question.getOption_c());
		newQuestion.setOption_d(question.getOption_d());
		final Question updatedQuestion = questionRepository.save(newQuestion);
		return ResponseEntity.ok().body(updatedQuestion);
	}

	@Override
	public ResponseEntity<Question> deleteQuestionById(int q_id) throws QuestionNotFoundException {
		Question question = questionRepository.findById(q_id)
				.orElseThrow(() -> new QuestionNotFoundException("Q_ID :: " + q_id + " Not Found"));
		questionRepository.deleteById(q_id);
		return ResponseEntity.ok().body(question);
	}

}
