package com.rmauction.roomservice.entities;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Nonnull
    private String roomName;

    @Nonnull
    private long creatorId;

    @Nonnull
    @JoinTable(
        name = "ROOM_USER",
        joinColumns = @JoinColumn(
                name = "roomId",
                referencedColumnName = "PID"
        ),
        inverseJoinColumns = @JoinColumn(
                name = "userId",
                referencedColumnName = "TID"
        )
)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "roomId")
    private List<RoomParticipator> participators;
}
