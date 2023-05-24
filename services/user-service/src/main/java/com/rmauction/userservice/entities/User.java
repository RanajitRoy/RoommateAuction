package com.rmauction.userservice.entities;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Ranajit Roy on 3/29/2023
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(name = "userIdSequence", sequenceName = "userIdSequence", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdSequence")
    private long userId;
    
    @Nonnull
    private String userName;
}
