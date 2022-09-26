package com.nseit.Atm.repository;

import com.nseit.Atm.modal.Amount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Amount,Integer> {
}
