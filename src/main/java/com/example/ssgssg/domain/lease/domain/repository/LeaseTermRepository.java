package com.example.ssgssg.domain.lease.domain.repository;

import com.example.ssgssg.domain.lease.domain.LeaseTerm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaseTermRepository extends JpaRepository<LeaseTerm,Long> {
}
