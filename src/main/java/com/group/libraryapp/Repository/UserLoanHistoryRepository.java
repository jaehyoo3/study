package com.group.libraryapp.Repository;

import com.group.libraryapp.domain.UserLoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {
    boolean existsByBookNameAndIsReturn(String name, boolean isReturn);
    Optional<UserLoanHistory> findByUserIdAndBookName(long userId, String bookName);
}
