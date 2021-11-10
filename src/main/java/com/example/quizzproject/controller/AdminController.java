package com.example.quizzproject.controller;

import com.example.quizzproject.model.CoursesQuiz;
import com.example.quizzproject.model.DataQuiz;
import com.example.quizzproject.service.CoursesQuizService;
import com.example.quizzproject.service.DataQuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    private DataQuizzService dataQuizzService;
    @Autowired
    private CoursesQuizService coursesQuizService;

    @PostMapping("/addCourse")
    public String addCourses(@RequestBody CoursesQuiz coursesQuiz) {
        coursesQuizService.saveCourses(coursesQuiz);
        return "new course is added";
    }

    @GetMapping("/course")
    public List<CoursesQuiz> getAllCourse() {
        return coursesQuizService.getAllCourses();
    }

    @GetMapping("/course/{id}")
    public Optional<CoursesQuiz> getCourseById(@PathVariable int id){
        return coursesQuizService.getCoursesById(id);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable int id) {
        coursesQuizService.removeCourses(id);
        return "course is deleted";
    }

    @PutMapping("/updateCourse/{id}")
    public String updateCourse(@RequestBody CoursesQuiz coursesQuiz) {
        coursesQuizService.saveCourses(coursesQuiz);
        return "course is updated";
    }

    @GetMapping("/question")
    public List<DataQuiz> getAllQuestion() {
        return dataQuizzService.getAllQuestion();
    }

    @GetMapping("/question/{id}")
    public Optional<DataQuiz> getQuestionById(@PathVariable int id){
        return dataQuizzService.getQuestionById(id);
    }

    @PostMapping("/addQuestion")
    public String add(@RequestBody DataQuiz dataQuiz) {
        dataQuizzService.saveQuestion(dataQuiz);
        return "new question is added";
    }

    @DeleteMapping("/deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable int id) {
        dataQuizzService.removeQuestion(id);
        return "question is deleted";
    }

    @PutMapping("/updateQuestion/{id}")
    public String updateQuestion(@RequestBody DataQuiz dataQuiz) {
        dataQuizzService.saveQuestion(dataQuiz);
        return "question is updated";
    }

}