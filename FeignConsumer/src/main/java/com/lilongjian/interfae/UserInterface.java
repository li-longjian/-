package com.lilongjian.interfae;

import com.lilongjian.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(value = "userProvider")
public interface UserInterface {

    @PostMapping("/user/login")
    Map<String, Object> UserLogin(@RequestParam("email") String email,@RequestParam("password") String password);

    @GetMapping("/user/getAll")
    List<User> getAllUser();

    @GetMapping("/user/get/{id}")
    User getUserById(@PathVariable("id") int id);

    @PostMapping("/user/getema")
    User getUserByEmail(@RequestParam("email") String email);

    @PostMapping("/user/register")
    Map<String, Object> register(@RequestBody User user);

    @PostMapping("/user/update")
    Map<String, String> updateUser(@RequestBody User user);

    @GetMapping("/user/del/{id}")
    Map<String, String> deleteUser(@PathVariable("id") int id);
}