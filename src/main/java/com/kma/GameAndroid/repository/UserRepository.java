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
    Optional<User> findByEmail(String email);
    @Query("SELECT u FROM User u ORDER BY u.time1 ASC")
    List<User> findTop6ByOrderByTime1ASC();
    @Query("SELECT u FROM User u ORDER BY u.time2 ASC")
    List<User> findTop6ByOrderByTime2ASC();
    @Query("SELECT u FROM User u ORDER BY u.time3 ASC")
    List<User> findTop6ByOrderByTime3ASC();
    @Query("SELECT u FROM User u ORDER BY u.time4 ASC")
    List<User> findTop6ByOrderByTime4ASC();
    @Query("SELECT u FROM User u ORDER BY u.time5 ASC")
    List<User> findTop6ByOrderByTime5ASC();
    @Query("SELECT u FROM User u ORDER BY u.time6 ASC")
    List<User> findTop6ByOrderByTime6ASC();

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.time1 = :newTime1 WHERE u.email = :email")
    int updateTime1(@Param("email") String email, @Param("newTime1") Double newTime1);

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



}
