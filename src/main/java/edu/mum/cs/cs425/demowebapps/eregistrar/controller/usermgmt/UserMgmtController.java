package edu.mum.cs.cs425.demowebapps.eregistrar.controller.usermgmt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.demowebapps.eregistrar.model.User;
import edu.mum.cs.cs425.demowebapps.eregistrar.service.RoleService;
import edu.mum.cs.cs425.demowebapps.eregistrar.service.UserService;

import javax.validation.Valid;

@Controller
public class UserMgmtController {
    private UserService userService;
    private RoleService roleService;

    public UserMgmtController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = { "/secured/admin/usrmgmt/list", "/eregistrar/secured/admin/usrmgmt/list" })
    public ModelAndView displayUsersList() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("users", userService.getAllUsers());
        // mav.addObject("users", new ArrayList<User>()); // to test empty list
        mav.setViewName("secured/admin/usrmgmt/list");
        return mav;
    }

    @GetMapping(value = { "/secured/admin/usrmgmt/user/new",
            "/eregistrar/secured/admin/usrmgmt/user/new" })
    public ModelAndView displayNewUserForm() {
        ModelAndView mav = new ModelAndView();
        User user = new User();
        mav.addObject("user", user);
        mav.addObject("roles", roleService.getAllRoles());
        mav.setViewName("secured/admin/usrmgmt/newuser");
        return mav;
    }

    @PostMapping(value = { "/secured/admin/usrmgmt/user/new",
            "/eregistrar/secured/admin/usrmgmt/user/new" })
    public String addNewUser(@Valid @ModelAttribute("user") User user,
            Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/admin/usrmgmt/newuser";
        }
        User newAddedUser = userService.saveUser(user);
        return "redirect:/eregistrar/secured/admin/usrmgmt/list";
    }

    @GetMapping(value = { "/secured/admin/usrmgmt/user/edit/{userId}",
            "/eregistrar/secured/admin/usrmgmt/user/edit/{userId}" })
    public String editUser(@PathVariable Integer userId, Model model) {
        User user = userService.getUserById(userId);
        if (user != null) {
            user.setPassword("");
            model.addAttribute("user", user);
            model.addAttribute("roles", roleService.getAllRoles());
            return "secured/admin/usrmgmt/edituser";
        }
        return "secured/admin/usrmgmt/list";
    }

    @PostMapping(value = { "/secured/admin/usrmgmt/user/edit",
            "/eregistrar/secured/admin/usrmgmt/user/edit" })
    public String updateUser(@Valid @ModelAttribute("user") User user,
            Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/admin/usrmgmt/edituser";
        }
        user = userService.saveUser(user);
        return "redirect:/secured/admin/usrmgmt/list";
    }
}
