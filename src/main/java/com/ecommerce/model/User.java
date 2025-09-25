package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users") // ตั้งชื่อตารางว่า 'users'
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    private LocalDateTime createdAt;

    @OneToMany(
            mappedBy = "user", // 1. บอกว่าความสัมพันธ์นี้ถูกจัดการโดย field 'user' ใน Class Order
            cascade = CascadeType.ALL, // 2. ถ้า User ถูกลบ ให้ลบ Order ทั้งหมดของ User นี้ไปด้วย
            orphanRemoval = true // 3. ถ้า Order ถูกลบออกจาก List นี้ ให้ลบ Order นั้นจาก DB ด้วย
    )
    private List<Order> orders = new ArrayList<>();


    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}