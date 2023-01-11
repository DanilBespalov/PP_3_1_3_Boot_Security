package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
//    @GetMapping("/{id}")
//    public String showUserByID(Model model, @PathVariable("id") int id) {
//        model.addAttribute("allUsers", userService.showUserByID(id));
//        return "users/show";
//    }
//
//    @GetMapping("/all")
//    public String showAllUsers(Model model) {
//        List<User> allUsers = userService.getAllUsers();
//        model.addAttribute("allUsers", allUsers);
//        return "users/all-users";
//    }
//
//    @GetMapping("/new")
//    public String newUser(@ModelAttribute("user") User user) {
////        model.addAttribute("newUser", new User());
//        return "users/new";
//    }
//
//    @PostMapping()
//    public String createUser(@ModelAttribute("user") User user) {
//        userService.add(user);
//        return "redirect:/users/all";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String updateUser(Model model, @PathVariable("id") int id) {
//        model.addAttribute("user", userService.showUserByID(id));
//        return "users/edit";
//    }
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
//        userService.update(user,id);
//        return "redirect:/users/all";
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") int id) {
//        userService.delete(id);
//        return "redirect:/users/all";
//    }
}
