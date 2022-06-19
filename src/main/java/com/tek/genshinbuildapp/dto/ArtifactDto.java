package com.tek.genshinbuildapp.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArtifactDto {

    long userId;
    String set;
    String slot;
    String[] statNames;
    double[] statValues;
}
