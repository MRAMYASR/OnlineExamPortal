package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.exception.QuestionNotFoundException;
import com.capg.model.Course;
import com.capg.model.Question;
import com.capg.service.CourseService;
import com.capg.service.QuestionService;

@RestController
public class QuestionRestController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private CourseService courseService;

	@PostMapping("question/createQuestion")
	public ResponseEntity<Question> createQuestion(@Validated @RequestBody Question ques) {
		Question a = questionService.addQuestion(ques);
		System.out.println(a);
		return new ResponseEntity<Question>(a, HttpStatus.OK);
	}

	@PostMapping("question/addQuestion")
	public Question addQuestion(@RequestBody Question question) {
		Course courseResponse = courseService.findById(question.getCourse().getCourse_id());
		question.setCourse(courseResponse);
		return questionService.addQuestion(question);

	}

	@GetMapping("/question")
	public ResponseEntity<List<Question>> getQuestions() {
		return questionService.getQuestions();
	}

	@GetMapping("/question/{id}")
	public ResponseEntity<Question> getQuestionById(@PathVariable(value = "id") int q_id)
			throws QuestionNotFoundException {
		return questionService.getQuestionById(q_id);
	}

	@PutMapping("/question/{id}")
	public ResponseEntity<Question> updateQuestionById(@PathVariable(value = "id") int q_id,
			@RequestBody Question question) throws QuestionNotFoundException {
		return questionService.updateQuestionById(q_id, question);
	}

	@DeleteMapping("/question/{id}")
	public ResponseEntity<Question> deleteQuestionById(@PathVariable(value = "id") int q_id)
			throws QuestionNotFoundException {
		return questionService.deleteQuestionById(q_id);
	}

}
