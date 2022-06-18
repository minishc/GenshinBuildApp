package com.tek.genshinbuildapp.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArtifactDto {

    int artifactId;
    long userId;
    String set;
    String slot;
    String mainstatName;
    double mainstatValue;
    String[] substatNames;
    double[] substatValues;
}
