package com.rainlf.ms.shopuser.adapter.web.facade;

import com.rainlf.ms.shopuser.adapter.web.dto.WebResponse;
import com.rainlf.ms.shopuser.application.UserAppService;
import com.rainlf.ms.shopuser.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : rain
 * @date : 2021/1/27 19:31
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserAppService userAppService;

    @PostMapping("/register")
    public WebResponse register(@RequestParam("username") String username, @RequestParam("password") String password) {
        userAppService.register(username, password);
        return WebResponse.ok("register success");
    }

    @PostMapping("/login")
    public WebResponse login(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = userAppService.login(username, password);
        return WebResponse.ok(user.getId(), "login success");
    }
}
