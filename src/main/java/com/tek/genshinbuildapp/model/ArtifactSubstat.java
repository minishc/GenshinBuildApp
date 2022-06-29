package com.tek.genshinbuildapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class ArtifactSubstat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @NonNull
    String statName;
    @NonNull
    double statValue;

    @ToString.Exclude
    @ManyToMany(mappedBy = "substats")
    List<Artifact> artifacts = new ArrayList<>();
}
