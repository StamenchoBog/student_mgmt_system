package com.example.student_mgmt_system.controllers;

import com.example.student_mgmt_system.db.domain.Address;
import com.example.student_mgmt_system.db.domain.Student;
import com.example.student_mgmt_system.db.domain.StudentInfoView;
import com.example.student_mgmt_system.db.repositories.AddressRepository;
import com.example.student_mgmt_system.db.repositories.StudentInfoViewRepository;
import com.example.student_mgmt_system.db.repositories.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentsController {

    private final StudentInfoViewRepository studentInfoViewRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentsController(StudentInfoViewRepository studentInfoViewRepository, StudentRepository studentRepository) {
        this.studentInfoViewRepository = studentInfoViewRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public String showList(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                           @RequestParam(value = "size", defaultValue = "10") int size) {
        Page<StudentInfoView> studentPage = studentInfoViewRepository.findAll(PageRequest.of(page, size));
        List<StudentInfoView> students = studentPage.getContent();
        int totalPages = studentPage.getTotalPages();
        int currentPage = studentPage.getNumber(); // Get the current page number
        model.addAttribute("pageUrl", "students");
        model.addAttribute("students", students);
        model.addAttribute("size", size);
        model.addAttribute("pageNumber", page);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("hasPreviousPage", currentPage > 0); // Check if previous page exists
        model.addAttribute("hasNextPage", currentPage < totalPages - 1); // Check if next page exists
        return "students";
    }

    @GetMapping("/create")
    public String showUpdateForm(Model model) {
        model.addAttribute("student", new Student());
        return "insert-student";
    }

    @PostMapping("/publish")
    public String update(@RequestParam("s_embg") String s_embg,
                         @RequestParam("s_name") String s_name,
                         @RequestParam("s_surname") String s_surname,
                         @RequestParam("s_date_of_birth") Date s_date_of_birth,
                         @RequestParam("s_email") String s_email,
                         @RequestParam("street_name") String street_name,
                         @RequestParam("street_num") int street_num,
                         @RequestParam("munic") String munic,
                         @RequestParam("city_name") String city_name,
                         @RequestParam("zip") int zip,
                         @RequestParam("country_name") String cuntry_name,
                         @RequestParam("s_study_program_name") String s_study_program_name,
                         @RequestParam("s_scholarship") int s_scholarship,
                         @RequestParam("s_group_name") String s_group_name)
    {
        studentRepository.student_insert(s_embg, s_name, s_surname, s_date_of_birth, s_email, street_name, street_num, munic, city_name, zip, cuntry_name, s_study_program_name, s_scholarship, s_group_name);
        return "redirect:/students";
    }

    //    @GetMapping("/edit/{id}")
//    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
//        Student student = studentRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid address ID:" + id));
//
//        model.addAttribute("student", student);
//        return "update-student";
//    }

//    @PostMapping("/update/{id}")
//    public String update(@PathVariable("id") Long id, @Valid Student student,
//                         BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            student.setId(id);
//            return "update-student";
//        }
//        studentRepository.save(student);
//        return "redirect:/students";
//    }

//    @GetMapping("/edit/{id}")
//    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
//        Student student = studentRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid address ID:" + id));
//
//        model.addAttribute("student", student);
//        return "update-student";
//    }

//    @PostMapping("/update/{id}")
//    public String update(@PathVariable("id") Long id, @Valid Student student,
//                         BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            student.setId(id);
//            return "update-student";
//        }
//        studentRepository.save(student);
//        return "redirect:/students";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable("id") Long id, Model model) {
//        Student student = studentRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid address ID:" + id));
//        studentRepository.delete(student);
//        return "redirect:/students";
//    }
}
