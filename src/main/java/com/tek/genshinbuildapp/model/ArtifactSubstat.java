package com.tek.genshinbuildapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class ArtifactSubstat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String statName;
    double statValue;

    @ToString.Exclude
    @ManyToMany(mappedBy = "substats")
    List<Artifact> artifacts = new ArrayList<>();
}
