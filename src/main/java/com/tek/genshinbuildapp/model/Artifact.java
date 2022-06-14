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
    int id;
    String set;
    String slot;

    @ManyToOne(targetEntity = ArtifactMainstat.class)
    ArtifactMainstat mainstat;

    @ManyToMany(targetEntity = ArtifactSubstat.class)
    List<ArtifactSubstat> substats;

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
