package forminfor.com.example.forminfor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import services.UserService;

@Controller
public class FormInforController {
    public UserService service;
    public FormInforController(UserService service) {
        this.service = service;
    }
    @GetMapping("/user/new")
    public String showUserForm(Model model) {
        model.addAttribute("user", new UserDemo());
        return "form";
    }

    @PostMapping("/user")
    public String submitUser(@ModelAttribute UserDemo user) {
        var newUser = this.service.add(user);
        return "redirect:/user/" + newUser.getId();
    }

    @GetMapping("/user/{id}")
    public String getUserDetail(@PathVariable Integer id, Model model) {
        UserDemo user = this.service.getById(id);
        model.addAttribute("user", user);
        return "detail";
    }

    @GetMapping("/user/edit/{id}")
    public String editUser(@PathVariable Integer id, Model model) {
        UserDemo user = this.service.getById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable Integer id, @ModelAttribute UserDemo user) {
        var userFound = this.service.getById(id);
        if(userFound != null) {
            userFound.setEmail(user.getEmail());
            userFound.setAge(user.getAge());
            userFound.setName(user.getName());
        }
        return "redirect:/user/" + id;
    }
}