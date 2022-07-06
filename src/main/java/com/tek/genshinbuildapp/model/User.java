package com.tek.genshinbuildapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NonNull
    @Column(unique = true, length = 20)
    String username;
    @NonNull
    @Setter(AccessLevel.NONE)
    String password;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Build> builds = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Artifact> artifacts = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "user_weapons",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "weapons_id", referencedColumnName = "id"))
    private Set<Weapon> weapons = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "user_characters",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "characters_id", referencedColumnName = "id"))
    private Set<Character> characters = new LinkedHashSet<>();

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder(4).encode(password);
    }

    public User(@NonNull String username, @NonNull String password) {
        this.username = username;
        this.password = new BCryptPasswordEncoder(4).encode(password);
    }

    public User(long id, @NonNull String username, @NonNull String password) {
        this.id = id;
        this.username = username;
        this.password = new BCryptPasswordEncoder(4).encode(password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + "'}";
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
