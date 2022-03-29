package uz.demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.demo.demo.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
