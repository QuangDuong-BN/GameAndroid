package com.kma.GameAndroid.controller;

import com.kma.GameAndroid.entity.User;
import com.kma.GameAndroid.entityDto.LevelDataDto;
import com.kma.GameAndroid.entityDto.NameDto;
import com.kma.GameAndroid.entityDto.PasswordDto;
import com.kma.GameAndroid.entityDto.UserDto;
import com.kma.GameAndroid.repository.UserRepository;
import com.kma.GameAndroid.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/ChangeLevel")
    public ResponseEntity<String> changeLevel(HttpServletRequest request,
                                              @RequestParam("level") String level,
                                              @RequestParam("time") Double time) {
        String email = userService.getUsernameByToken(request);
        userService.changeLevel(email, level, time);
        return ResponseEntity.ok("success");
    }

    @GetMapping()
    public ResponseEntity<UserDto> getUsername(HttpServletRequest request) {
        return ResponseEntity.ok(userService.getUserDto(request));
    }

    @PutMapping("/changeName")
    public ResponseEntity<String> changeName(HttpServletRequest request,
                                             @RequestBody NameDto nameDto) {
        userService.changeName(request, nameDto.getName());
        return ResponseEntity.ok("success");
    }

    @PutMapping("/changePassword")
    public ResponseEntity<String> changePassword(HttpServletRequest request,
                                                 @RequestBody PasswordDto passwordDto) {
        userService.changePassword(request, passwordDto.getPassword());
        return ResponseEntity.ok("success");
    }
    @PutMapping("/changeInfo")
    public ResponseEntity<String> changeInfo(HttpServletRequest request,
                                             @RequestBody UserDto userDto) {

        userService.changeName(request, userDto.getName());
        userService.changePassword(request, userDto.getPassword());
        return ResponseEntity.ok("success");
    }



    @GetMapping("/getLevelData")
    public ResponseEntity<LevelDataDto> getLevelData(HttpServletRequest request) {
        String userName = userService.getUsernameByToken(request);
        LevelDataDto levelDataDto = userService.getLevelData(userName);
        return ResponseEntity.ok(levelDataDto);
    }

    @GetMapping("/rank1")
    public ResponseEntity<List<User>> rank1() {
        List<User> rank = userService.findTop6ByOrderByTime1ASC();
        return ResponseEntity.ok(rank);
    }

    @GetMapping("/rank2")
    public ResponseEntity<List<User>> rank2() {
        List<User> rank = userService.findTop6ByOrderByTime2ASC();
        return ResponseEntity.ok(rank);
    }

    @GetMapping("/rank3")
    public ResponseEntity<List<User>> rank3() {
        List<User> rank = userService.findTop6ByOrderByTime3ASC();
        return ResponseEntity.ok(rank);
    }

    @GetMapping("/rank4")
    public ResponseEntity<List<User>> rank4() {
        List<User> rank = userService.findTop6ByOrderByTime4ASC();
        return ResponseEntity.ok(rank);
    }

    @GetMapping("/rank5")
    public ResponseEntity<List<User>> rank5() {
        List<User> rank = userService.findTop6ByOrderByTime5ASC();
        return ResponseEntity.ok(rank);
    }

    @GetMapping("/rank6")
    public ResponseEntity<List<User>> rank6() {
        List<User> rank = userService.findTop6ByOrderByTime6ASC();
        return ResponseEntity.ok(rank);
    }

}
