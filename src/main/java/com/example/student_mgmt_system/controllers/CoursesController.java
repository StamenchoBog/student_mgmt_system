package com.example.student_mgmt_system.controllers;

import com.example.student_mgmt_system.db.domain.Course;
import com.example.student_mgmt_system.db.repositories.CoursesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/courses")
public class CoursesController {

    private final CoursesRepository coursesRepository;

    public CoursesController(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }


    @GetMapping
    public String showList(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                           @RequestParam(value = "size", defaultValue = "10") int size) {
        Page<Course> coursePage = coursesRepository.findAll(PageRequest.of(page, size));
        List<Course> courses = coursePage.getContent();
        int totalPages = coursePage.getTotalPages();
        int currentPage = coursePage.getNumber(); // Get the current page number
        model.addAttribute("pageUrl", "courses");
        model.addAttribute("courses", courses);
        model.addAttribute("size", size);
        model.addAttribute("pageNumber", page);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("hasPreviousPage", currentPage > 0); // Check if previous page exists
        model.addAttribute("hasNextPage", currentPage < totalPages - 1); // Check if next page exists
        return "courses";
    }

    @GetMapping("/create")
    public String showUpdateForm(Model model) {
        model.addAttribute("course", new Course());
        return "insert-course";
    }

    @PostMapping("/publish")
    public String update(@RequestParam("c_name") String c_name,
                         @RequestParam("c_credits") Integer c_credits,
                         @RequestParam("c_semester") Integer c_semester,
                         @RequestParam("c_level") Integer c_level)
    {
        coursesRepository.course_insert(c_name,c_credits,c_semester,c_level);
        return "redirect:/courses";
    }
}

