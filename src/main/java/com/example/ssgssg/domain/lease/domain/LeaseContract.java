package com.example.ssgssg.domain.lease.domain;

import com.example.ssgssg.domain.user.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LeaseContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "deposit", nullable = false)
    private Long deposit;

    @Column(name = "down_payment", nullable = false)
    private Long downPayment;

    @Column(name = "progress_payment")
    private Long progressPayment;

    @Column(name = "balance")
    private Long balance;

}
