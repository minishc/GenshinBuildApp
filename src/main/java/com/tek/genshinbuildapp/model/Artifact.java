package com.tek.genshinbuildapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Artifact implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    //Every artifact must be part of an artifact set and have a specific equip slot
    @NotNull @NonNull
    String artifactSet;
    @NotNull @NonNull
    String slot;

    /*
        Each artifact has a single mainstat, a single mainstat can appear on several different
        artifacts
     */
    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "mainstat_id")
    private ArtifactMainstat mainstat;

    /*
        Since all artifacts are assumed to be 5 stars at level 20 all artifacts should have
        4 and only 4 substats, substats can appear on multiple artifacts.
     */
    @Size(min = 4, max = 4)
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "artifact_substats",
            joinColumns = @JoinColumn(name = "artifact_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "substat_id", referencedColumnName = "id"))
    private Set<ArtifactSubstat> substats = new LinkedHashSet<>();

    /*
        Each build can have 0-5 artifacts (most likely 5). Each artifact can appear on any number
        of builds
     */
    @ToString.Exclude
    @ManyToMany(mappedBy = "artifacts")
    private Set<Build> builds = new LinkedHashSet<>();

    //Each artifact MUST be attached to a user, a user can have many artifacts
    @NotNull
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //auto generated equals and hashcode
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
