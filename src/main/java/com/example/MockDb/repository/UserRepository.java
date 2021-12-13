package com.example.MockDb.repository;

import com.example.MockDb.model.Pers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Pers, Long> {
//    @Query(value = "SELECT content FROM pers p WHERE p.login in:login and p.password in:password", nativeQuery = true)
    @Query(value = "SELECT * from pers p where p.login = ?1 and p.password = ?2", nativeQuery = true)
    List<Pers> findByUser(@Param("login") String login,@Param("password") String password);
}
