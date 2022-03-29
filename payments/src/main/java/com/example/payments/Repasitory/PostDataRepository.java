package com.example.payments.Repasitory;

import com.example.payments.entity.PostData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDataRepository extends JpaRepository<PostData,Long> {
}
