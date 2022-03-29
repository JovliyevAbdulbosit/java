package uz.demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.demo.demo.entity.Dictionary;


@Repository
public interface DictionaryRepostory extends JpaRepository<Dictionary, Long> {
}
