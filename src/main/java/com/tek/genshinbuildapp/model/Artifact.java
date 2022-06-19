package com.tek.genshinbuildapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Artifact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NonNull
    String artifactSet;
    @NonNull
    String slot;



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mainstat_id")
    private ArtifactMainstat mainstat;

    @ManyToMany
    @JoinTable(name = "artifact_substats",
            joinColumns = @JoinColumn(name = "artifact_id"),
            inverseJoinColumns = @JoinColumn(name = "substat_id"))
    private Set<ArtifactSubstat> substats = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "artifacts")
    private Set<Build> builds = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String addToBuilder = artifactSet + ", " + slot + ", " +
                mainstat.getStatName() + " " + mainstat.getStatValue();
        stringBuilder.append(addToBuilder);
        for(ArtifactSubstat artifactSubstat : substats) {
            addToBuilder = ", " + artifactSubstat.getStatName() + " " + artifactSubstat.getStatValue();
            stringBuilder.append(addToBuilder);
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artifact artifact = (Artifact) o;

        if (getId() != artifact.getId()) return false;
        if (!getArtifactSet().equals(artifact.getArtifactSet())) return false;
        if (!getSlot().equals(artifact.getSlot())) return false;
        return getMainstat().equals(artifact.getMainstat());
    }

    @Override
    public int hashCode() {
        long result = (getId() ^ (getId() >>> 31));
        result = 31 * result + getArtifactSet().hashCode();
        result = 31 * result + getSlot().hashCode();
        result = 31 * result + getMainstat().hashCode();
        return (int)result;
    }
}
