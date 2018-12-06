package me.imjamin;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controll {

    @Reference(version = "1.0.0", timeout = 10000, retries = 0)
    public UserService userService;

    @RequestMapping("/getAll")
    public String[] getAll(){
        return userService.selectName();
    }
}
