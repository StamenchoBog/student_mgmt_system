package com.example.student_mgmt_system.controllers;

import com.example.student_mgmt_system.db.domain.Address;
import com.example.student_mgmt_system.db.repositories.AddressRepository;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/addresses")
public class AddressController {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping
    public String showAddressList(Model model,@RequestParam(value = "page", defaultValue = "0") int page,
                                  @RequestParam(value = "size", defaultValue = "10") int size) {
        Page<Address> addressPage = addressRepository.findAll(PageRequest.of(page, size));
        List<Address> addresses = addressPage.getContent();
        int totalPages = addressPage.getTotalPages();
        int currentPage = addressPage.getNumber(); // Get the current page number
        model.addAttribute("pageUrl", "addresses");
        model.addAttribute("addresses", addresses);
        model.addAttribute("size", size);
        model.addAttribute("pageNumber", page);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("hasPreviousPage", currentPage > 0); // Check if previous page exists
        model.addAttribute("hasNextPage", currentPage < totalPages - 1); // Check if next page exists
        return "addresses";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Address address = addressRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid address ID:" + id));

        model.addAttribute("address", address);
        return "update-address";
    }

    @PostMapping("/update/{id}")
    public String updateAddress(@PathVariable("id") Long id, @Valid Address address,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            address.setId(id);
            return "update-address";
        }
        addressRepository.save(address);
        return "redirect:/addresses";
    }

    @GetMapping("/delete/{id}")
    public String deleteAddress(@PathVariable("id") Long id, Model model) {
        Address address = addressRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid address ID:" + id));
        addressRepository.delete(address);
        return "redirect:/addresses";
    }
}
