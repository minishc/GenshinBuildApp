package com.tek.genshinbuildapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Artifact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String set;
    String slot;

    @ManyToOne(targetEntity = ArtifactMainstat.class)
    ArtifactMainstat mainstat;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(referencedColumnName = "id", name = "artifact_id"),
                    inverseJoinColumns = @JoinColumn(referencedColumnName = "id", name = "substat_id"), name = "artifact_substats")
    List<ArtifactSubstat> substats = new java.util.ArrayList<>();

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String addToBuilder = set + ", " + slot + ", " +
                mainstat.getStatName() + " " + mainstat.getStatValue();
        stringBuilder.append(addToBuilder);
        for(ArtifactSubstat artifactSubstat : substats) {
            addToBuilder = ", " + artifactSubstat.getStatName() + " " + artifactSubstat.getStatValue();
            stringBuilder.append(addToBuilder);
        }
        return stringBuilder.toString();
    }
}
