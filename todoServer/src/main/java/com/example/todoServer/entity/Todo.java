package com.example.todoServer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Index;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @Enumerated(EnumType.STRING)
    private CompletionStatus status = CompletionStatus.NOT_STARTED;

    @Index(name = "idx_user_id")
    private Long userId;

}
