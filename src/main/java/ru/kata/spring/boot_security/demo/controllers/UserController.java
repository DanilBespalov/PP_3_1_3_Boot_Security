//package ru.kata.spring.boot_security.demo.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import ru.kata.spring.boot_security.demo.entity.User;
//
//@Controller
//@RequestMapping("/users")
//public class UserController {
//    private final UserServiceImpl userService;
//
//    @Autowired
//    public UserController(UserServiceImpl userService) {
//        this.userService = userService;
//    }
//    @GetMapping("/{id}")
//    public String showUserByID(Model model, @PathVariable("id") long id) {
//        model.addAttribute("allUsers", userService.findByUserID(id));
//        return "users/show";
//    }
//
////    @GetMapping("/all")
////    public String showAllUsers(Model model) {
////        List<User> allUsers = userService.();
////        model.addAttribute("allUsers", allUsers);
////        return "users/all-users";
////    }
//
//    @GetMapping("/new")
//    public String newUser(@ModelAttribute("user") User user) {
////        model.addAttribute("newUser", new User());
//        return "users/new";
//    }
//
//    @PostMapping()
//    public String createUser(@ModelAttribute("user") User user) {
//        userService.save(user);
//        return "redirect:/users/all";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String updateUser(Model model, @PathVariable("id") long id) {
//        model.addAttribute("user", userService.findByUserID(id));
//        return "users/edit";
//    }
//
////    @PatchMapping("/{id}")
////    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
////        userService.update(user,id);
////        return "redirect:/users/all";
////    }
//
////    @DeleteMapping("/{id}")
////    public String delete(@PathVariable("id") int id) {
////        userService.delete(id);
////        return "redirect:/users/all";
////    }
//}
