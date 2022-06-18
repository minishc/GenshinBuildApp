package com.tek.genshinbuildapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @Column(unique = true, length = 20)
    String username;
    @Column(length = 32)
    String password;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Build> builds = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private Set<Artifact> artifacts = new LinkedHashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "user_weapons",
            joinColumns = @JoinColumn(name = "user_null"),
            inverseJoinColumns = @JoinColumn(name = "weapons_id"))
    private Set<Weapon> weapons = new LinkedHashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "user_characters",
            joinColumns = @JoinColumn(name = "user_null"),
            inverseJoinColumns = @JoinColumn(name = "characters_id"))
    private Set<Character> characters = new LinkedHashSet<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (getId() != user.getId()) return false;
        if (!getUsername().equals(user.getUsername())) return false;
        return getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getUsername().hashCode();
        result = 31 * result + getPassword().hashCode();
        return result;
    }
}
