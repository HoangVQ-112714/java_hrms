package demo.hrms.controller;

import demo.hrms.domain.Role;
import demo.hrms.domain.User;
import demo.hrms.service.UploadService;
import demo.hrms.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UploadService uploadService;

    public UserController(UserService userService, PasswordEncoder passwordEncoder, UploadService uploadService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.uploadService = uploadService;
    }

    //user - danh sách
    @GetMapping("/user/list")
    public String getAdminCreatUserPage(Model model) {
        List<User> arrUser = this.userService.listAllUser();
        model.addAttribute("users", arrUser);
        return "user/user-list";
    }

    //user - tạo mới
    @GetMapping("/user/create")
    public String creatUser(Model model) {
        model.addAttribute("newUser", new User());
        List<Role> arrRole = this.userService.listAllRole();
        model.addAttribute("roles", arrRole);
        return "user/user-create";
    }

    @PostMapping(value = "/user/list")
    public String creatUserPost(@ModelAttribute("newUser") @Valid User user,
                                BindingResult newUserBindingResult) {
        if (newUserBindingResult.hasErrors()) {
            return "user/user-create";
        }
        String hashPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        user.setRole(this.userService.getRoleByName(user.getRole().getName()));
        user.setStatus("Active");
        user.setAvatar("avatar-default-1.jpg");
        this.userService.addNewUser(user);
        return "redirect:/user/list";
    }

    //user - chi tiết
    @GetMapping("/user/{id}")
    public String getUserDetail(Model model, @PathVariable long id) {
        User user = this.userService.loadUserById(id);
        model.addAttribute("user", user);
        return "user/user-detail";
    }

    //user - chỉnh sửa
    @RequestMapping("/user/{id}/update")
    public String updateUser(Model model, @PathVariable long id) {
        User user = this.userService.loadUserById(id);
        model.addAttribute("user", user);
        List<Role> arrRole = this.userService.listAllRole();
        model.addAttribute("roles", arrRole);
        return "user/user-update";
    }

    @PostMapping("/user/{id}")
    public String updateUserPost(Model model,
                                 @ModelAttribute("user") User userInfo,
                                 @PathVariable long id,
                                 @RequestParam("hrmsFile") MultipartFile file) {
        User user = this.userService.loadUserById(userInfo.getId());
        if (user != null) {
            user.setName(userInfo.getName());
            user.setEmail(user.getEmail());
            user.setPhone(userInfo.getPhone());
            user.setStatus(user.getStatus());
            user.setRole(this.userService.getRoleByName(user.getRole().getName()));

            String avatar = this.uploadService.handleSaveFileUploadFile(file, "avatar");
            user.setAvatar(avatar);

            if (user.getPassword() != null) {
                String hashPassword = this.passwordEncoder.encode(user.getPassword());
                user.setPassword(hashPassword);
            }
            this.userService.addNewUser(user);
        }
        return "redirect:/user/list";
    }

    //user - xoá
    @RequestMapping("/user/{id}/delete")
    public String deleteUser(Model model, @PathVariable long id) {
        User user = this.userService.loadUserById(id);
        if (user != null) {
            this.userService.deleteUser(id);
        }
        return "redirect:/user/list";
    }

    //user - đổi mật khẩu

    //user - đăng nhập
    @GetMapping("/user/login")
    public String loginUser(Model model) {
        return "user/user-login";
    }

//    @PostMapping(value = "/user/login/post")
//    public String loginUserPost(@ModelAttribute("newUser") @Valid User user,
//                                BindingResult newUserBindingResult) {
//        if (newUserBindingResult.hasErrors()) {
//            return "user/user-login";
//        }
//        String hashPassword = this.passwordEncoder.encode(user.getPassword());
//        user.setPassword(hashPassword);
//        user.setRole(this.userService.getRoleByName(user.getRole().getName()));
//        user.setStatus("Active");
//        user.setAvatar("avatar-default-1.jpg");
//        this.userService.addNewUser(user);
//        return "redirect:/user/list";
//    }
}
