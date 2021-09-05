package io.hoanghai.pharmacy.controller.rest;

import io.hoanghai.pharmacy.model.User;
import io.hoanghai.pharmacy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api")
public class RegisterRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String save(@Valid @RequestBody User user, BindingResult bindingResult, RedirectAttributes redirect) {
        try {
            User get = userService.findByEmail(user.getEmail());
            if (get != null) bindingResult.rejectValue("email", "", "*Email đã được đăng kí!!");
            if (!user.getPassword().equals(user.getConfirmPassword()))
                bindingResult.rejectValue("password", "", "*Nhập lại mật khẩu không đúng!!");
            if (bindingResult.hasErrors()) return "xem lại email và password";
            else {
                userService.save(user);
                return "tạo tk thành công";
            }
        } catch (Exception e) {
            return null;
        }
    }
}
