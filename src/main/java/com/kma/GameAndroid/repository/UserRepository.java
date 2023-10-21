package com.kma.GameAndroid.repository;

import com.kma.GameAndroid.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    // tim kiem user theo email
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.time1 IS NOT NULL ORDER BY u.time1 ASC LIMIT 10")
    List<User> findTop6ByOrderByTime1ASC();

    @Query("SELECT u FROM User u  where u.time2 is not null ORDER BY u.time2 ASC LIMIT 10")
    List<User> findTop6ByOrderByTime2ASC();

    @Query("SELECT u FROM User u where u.time3 is not null ORDER BY u.time3 ASC LIMIT 10")
    List<User> findTop6ByOrderByTime3ASC();

    @Query("SELECT u FROM User u WHERE u.time4 IS NOT NULL ORDER BY u.time4 ASC LIMIT 10")
    List<User> findTop6ByOrderByTime4ASC();

    @Query("SELECT u FROM User u WHERE u.time5 IS NOT NULL ORDER BY u.time5 ASC LIMIT 10")
    List<User> findTop6ByOrderByTime5ASC();

    @Query("SELECT u FROM User u WHERE u.time6 IS NOT NULL ORDER BY u.time6 ASC LIMIT 10")
    List<User> findTop6ByOrderByTime6ASC();

    @Query("SELECT COUNT(u) FROM User u WHERE u.email = :email")
    Long countByEmail(@Param("email") String email);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.time1 = :newTime1 WHERE u.email = :email")
    void updateTime1(@Param("email") String email, @Param("newTime1") Double newTime1);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.time2 = :newTime WHERE u.email = :email")
    void updateTime2(@Param("email") String email, @Param("newTime") Double newTime);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.time3 = :newTime WHERE u.email = :email")
    void updateTime3(@Param("email") String email, @Param("newTime") Double newTime);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.time4 = :newTime WHERE u.email = :email")
    void updateTime4(@Param("email") String email, @Param("newTime") Double newTime);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.time5 = :newTime WHERE u.email = :email")
    void updateTime5(@Param("email") String email, @Param("newTime") Double newTime);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.time6 = :newTime WHERE u.email = :email")
    void updateTime6(@Param("email") String email, @Param("newTime") Double newTime);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.name = :name WHERE u.email = :email")
    void updateName(@Param("email") String email, @Param("name") String name);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.password = :password WHERE u.email = :email")
    void updatePassword(@Param("email") String email, @Param("password") String password);
}
