package com.payment.test.Repository;


import entity.AccountCardUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountCardUserRepository extends JpaRepository<AccountCardUser, Long> {
}
