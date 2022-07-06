package com.tek.genshinbuildapp.dto;

import com.tek.genshinbuildapp.model.AuthGroup;
import com.tek.genshinbuildapp.model.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserAuthGroupDto {

    User user;
    List<AuthGroup> authGroups;
}
