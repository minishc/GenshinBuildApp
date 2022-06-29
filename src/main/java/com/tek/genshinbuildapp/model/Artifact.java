package com.tek.genshinbuildapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
public class Artifact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NotNull @NonNull
    String artifactSet;
    @NotNull @NonNull
    String slot;

    @NotNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "mainstat_id")
    private ArtifactMainstat mainstat;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "artifact_substats",
            joinColumns = @JoinColumn(name = "artifact_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "substat_id", referencedColumnName = "id"))
    private Set<ArtifactSubstat> substats = new LinkedHashSet<>();

    @ToString.Exclude
    @ManyToMany(mappedBy = "artifacts")
    private Set<Build> builds = new LinkedHashSet<>();

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

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
