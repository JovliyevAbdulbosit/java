package com.example.payments.Repasitory;

import com.example.payments.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AccountRepository extends JpaRepository<Account , Long> {

}