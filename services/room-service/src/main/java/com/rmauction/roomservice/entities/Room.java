package com.rmauction.roomservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author Ranajit Roy on 3/28/2023
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @SequenceGenerator(name = "roomIdSequence", sequenceName = "roomIdSequence", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomIdSequence")
    private long roomId;

    @NonNull
    private String roomName;
}
