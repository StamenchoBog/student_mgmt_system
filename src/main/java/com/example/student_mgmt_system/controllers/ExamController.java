package com.example.student_mgmt_system.controllers;

import com.example.student_mgmt_system.db.domain.Address;
import com.example.student_mgmt_system.db.domain.Exam;
import com.example.student_mgmt_system.db.repositories.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/exams")
public class ExamController {
    private final ExamRepository examRepository;

    @Autowired
    public ExamController(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @GetMapping
    public String showList(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                           @RequestParam(value = "size", defaultValue = "10") int size) {
        Page<Exam> examPage = examRepository.findAll(PageRequest.of(page, size));
        List<Exam> exams = examPage.getContent();
        int totalPages = examPage.getTotalPages();
        int currentPage = examPage.getNumber(); // Get the current page number
        model.addAttribute("pageUrl", "exams");
        model.addAttribute("exams", exams);
        model.addAttribute("size", size);
        model.addAttribute("pageNumber", page);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("hasPreviousPage", currentPage > 0); // Check if previous page exists
        model.addAttribute("hasNextPage", currentPage < totalPages - 1); // Check if next page exists
        return "exams";
    }
}
