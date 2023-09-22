package com.kma.GameAndroid.service;

import com.kma.GameAndroid.config.JwtService;
import com.kma.GameAndroid.entity.User;
import com.kma.GameAndroid.entityDto.LevelDataDto;
import com.kma.GameAndroid.entityDto.PasswordDto;
import com.kma.GameAndroid.entityDto.UserDto;
import com.kma.GameAndroid.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public LevelDataDto getLevelData(String email) {
        Optional<User> userName = userRepository.findByEmail(email);
        LevelDataDto levelDataDto = new LevelDataDto();
        levelDataDto.level1 = userName.get().getTime1();
        levelDataDto.level2 = userName.get().getTime2();
        levelDataDto.level3 = userName.get().getTime3();
        levelDataDto.level4 = userName.get().getTime4();
        levelDataDto.level5 = userName.get().getTime5();
        levelDataDto.level6 = userName.get().getTime6();
        return levelDataDto;
    }

    public String getUsernameByToken(HttpServletRequest request) {

        String token = request.getHeader("Authorization"); // Lấy token từ Header (thường được gửi trong header Authorization)
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7); // Loại bỏ "Bearer " từ token
            String username = jwtService.extractUsername(token); // Sử dụng JwtService để lấy username từ token
            return username;
        }
        return "Token not provided or invalid";
    }

    public UserDto getUserDto(HttpServletRequest request) {
        String email = getUsernameByToken(request);
        Optional<User> user = userRepository.findByEmail(email);
        UserDto userDto = new UserDto();
        userDto.name = user.get().getName();
        userDto.email = user.get().getEmail();
        return userDto;
    }

    public void changeName(HttpServletRequest request, String name) {
        String token = request.getHeader("Authorization"); // Lấy token từ Header (thường được gửi trong header Authorization)
        token = token.substring(7); // Loại bỏ "Bearer " từ token
        String email = jwtService.extractUsername(token); // Sử dụng JwtService để lấy username từ token
        userRepository.updateName(email, name);
    }

    public void changePassword(HttpServletRequest request, PasswordDto passwordDto) {
        String token = request.getHeader("Authorization"); // Lấy token từ Header (thường được gửi trong header Authorization)
        token = token.substring(7); // Loại bỏ "Bearer " từ token
        String email = jwtService.extractUsername(token); // Sử dụng JwtService để lấy username từ token
        userRepository.updatePassword(email, passwordEncoder.encode(passwordDto.getPassword()));
    }

    public List<User> findTop6ByOrderByTime1ASC() {
        return userRepository.findTop6ByOrderByTime1ASC();
    }

    public List<User> findTop6ByOrderByTime2ASC() {
        return userRepository.findTop6ByOrderByTime2ASC();
    }

    public List<User> findTop6ByOrderByTime3ASC() {
        return userRepository.findTop6ByOrderByTime3ASC();
    }

    public List<User> findTop6ByOrderByTime4ASC() {
        return userRepository.findTop6ByOrderByTime4ASC();
    }

    public List<User> findTop6ByOrderByTime5ASC() {
        return userRepository.findTop6ByOrderByTime5ASC();
    }

    public List<User> findTop6ByOrderByTime6ASC() {
        return userRepository.findTop6ByOrderByTime6ASC();
    }


    public void changeLevel(String email, String level, Double time) {
        if (level.equals("1")) {

            Double oldTime = userRepository.findByEmail(email).get().getTime1();
            if (oldTime == null) {
                userRepository.updateTime1(email, time);
            } else {
                if (oldTime > time)
                    userRepository.updateTime1(email, time);
            }
        }
        if (level.equals("2")) {
            Double oldTime = userRepository.findByEmail(email).get().getTime2();
            if (oldTime == null) {
                userRepository.updateTime2(email, time);
            } else {
                if (oldTime > time)
                    userRepository.updateTime2(email, time);
            }
        }
        if (level.equals("3")) {
            Double oldTime = userRepository.findByEmail(email).get().getTime3();
            if (oldTime == null) {
                userRepository.updateTime3(email, time);
            } else {
                if (oldTime > time)
                    userRepository.updateTime3(email, time);
            }
        }
        if (level.equals("4")) {
            Double oldTime = userRepository.findByEmail(email).get().getTime4();
            if (oldTime == null) {
                userRepository.updateTime4(email, time);
            } else {
                if (oldTime > time)
                    userRepository.updateTime4(email, time);
            }
        }
        if (level.equals("5")) {
            Double oldTime = userRepository.findByEmail(email).get().getTime5();
            if (oldTime == null) {
                userRepository.updateTime5(email, time);
            } else {
                if (oldTime > time)
                    userRepository.updateTime5(email, time);
            }
        }
        if (level.equals("6")) {
            Double oldTime = userRepository.findByEmail(email).get().getTime6();
            if (oldTime == null) {
                userRepository.updateTime6(email, time);
            } else {
                if (oldTime > time)
                    userRepository.updateTime6(email, time);
            }
        }
    }


}
