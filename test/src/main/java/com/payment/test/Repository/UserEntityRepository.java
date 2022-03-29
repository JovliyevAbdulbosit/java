package com.payment.test.Repository;

import entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity , Long> {
       UserEntity findByUsername(String name);
        boolean existsByUsername( String userName);
}