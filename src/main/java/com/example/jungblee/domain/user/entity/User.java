package com.example.jungblee.domain.user.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 10, nullable = false)
    private String username;

    @Column(name = "account_id", length = 20, nullable = false)
    private String accountId;

    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @Builder
    public User(String username, String accountId, String password) {
        this.username = username;
        this.accountId = accountId;
        this.password = password;
    }
}
