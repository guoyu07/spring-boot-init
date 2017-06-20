package com.kyee.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name =  "user")
public class User {
    @Id
    private String userName;
    private String passWord;

    @Enumerated(EnumType.STRING)
    private Role role;
}
