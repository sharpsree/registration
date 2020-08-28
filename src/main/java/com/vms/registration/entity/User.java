package com.vms.registration.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="Users", schema = "vms")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @Column(name="loginid")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer logInId;

    @Column(name="Password")
    private String password;

    @Column(name="Role")
    private String role;

    @Column(name="Enabled")
    private Integer enabled;
}
