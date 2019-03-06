package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/")
    public String booklist(Model model){

        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

    @GetMapping("/add")                              // adding the attributes and putting values to h2 database
    public String addBook(Model model) {

        model.addAttribute("book", new Book());
        return "bookform";
    }

        @PostMapping("/process")                        // Validation operation
        public String processForm(@Valid @ModelAttribute Book book, BindingResult result){

            if (result.hasErrors()){
                return "bookform";
            }

            bookRepository.save(book);
            return "redirect:/";
        }

    @RequestMapping("/detail/{id}")                             // display details
    public String showBook(@PathVariable("id") long id, Model model){

        model.addAttribute("book", bookRepository.findById(id).get());
        return "show";
    }


    @RequestMapping("/update/{id}")                             // update
    public String updateBook(@PathVariable("id") long id, Model model){

        model.addAttribute("book", bookRepository.findById(id));
        return "bookform";
    }


    @RequestMapping("/delete/{id}")                             // update
    public String delBook(@PathVariable("id") long id){

        bookRepository.deleteById(id);
        return "redirect:/";
    }
}