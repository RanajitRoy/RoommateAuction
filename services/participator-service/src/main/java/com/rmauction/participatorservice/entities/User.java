package com.rmauction.participatorservice.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ranajit Roy on 3/29/2023
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    private long userId;
    
    @Nonnull
    private String userName;

    @Nonnull
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "participators")
    @JsonIgnore
    private List<Room> rooms;
}
