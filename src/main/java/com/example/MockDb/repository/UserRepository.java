package com.example.MockDb.repository;

import com.example.MockDb.model.Pers;
import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Pers, Long> {
    @Query(value = "SELECT * from pers p where p.login = ?1 and p.password = ?2", nativeQuery = true)
    List<Pers> findByUser(@Param("login") String login,@Param("password") String password);

    @Modifying
    @Query(value = "INSERT INTO pers (login,password,content) VALUES(?1,?2,?3)",nativeQuery = true)
    List<Pers> createUser(@Param("login") String login,@Param("password") String password, @Param("content") JSONObject content);
}
