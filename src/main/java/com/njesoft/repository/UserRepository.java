package com.njesoft.repository;

import com.njesoft.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("FROM User WHERE userName=:username")
    User findByUsername(@Param("username") String username);

}
