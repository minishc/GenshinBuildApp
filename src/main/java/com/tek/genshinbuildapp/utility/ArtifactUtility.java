package com.tek.genshinbuildapp.utility;

import com.tek.genshinbuildapp.model.ArtifactSubstat;
import com.tek.genshinbuildapp.dto.ArtifactDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is a utility class for the various artifact
 * related methods that I needed that didn't really fit in
 * the MVC style of the project
 */
@Component
@Slf4j
public final class ArtifactUtility {

    private static final double FLAT_HP_CEIL = 298.8;
    private static final double FLAT_ATK_CEIL = 19.51;
    private static final double FLAT_DEF_CEIL = 23.2;
    private static final double HP_CEIL = 5.9;
    private static final double ATK_CEIL = 5.9;
    private static final double DEF_CEIL = 7.3;
    private static final double CRIT_CEIL = 23.4;
    private static final double CRIT_DMG_CEIL = 6.5;
    private static final double EM_CEIL = 3.91;
    private static final double ER_CEIL = 7.81;

    //don't want any instantiation of this class since it is a utility
    private ArtifactUtility() {
    }

    /**
     * Method for advanced validation logic relating to artifact substats. Checks to ensure
     * that substats fall within the possible levels using Genshin Impact's rules for artifact
     * leveling.
     *
     * @param artifactSubstats an array of ArtifactSubstats containing the substats of an artifact to check
     * @return a boolean for whether the passed substats are valid
     */
    public static boolean validateSubstats(ArtifactSubstat[] artifactSubstats) {
        boolean result = true;
        int minLevels = 0;

        for(ArtifactSubstat substat : artifactSubstats) {
            if(result) {
                switch (substat.getStatName().toUpperCase()) {
                    case "HP": minLevels += computeMinLevel(FLAT_HP_CEIL, substat.getStatValue());
                        break;
                    case "ATK": minLevels += computeMinLevel(FLAT_ATK_CEIL, substat.getStatValue());
                        break;
                    case "DEF": minLevels += computeMinLevel(FLAT_DEF_CEIL, substat.getStatValue());
                        break;
                    case "HP%": minLevels += computeMinLevel(HP_CEIL, substat.getStatValue());
                        break;
                    case "ATK%": minLevels += computeMinLevel(ATK_CEIL, substat.getStatValue());
                        break;
                    case "DEF%": minLevels += computeMinLevel(DEF_CEIL, substat.getStatValue());
                        break;
                    case "ELEMENTAL MASTERY": minLevels += computeMinLevel(EM_CEIL, substat.getStatValue());
                        break;
                    case "ENERGY RECHARGE": minLevels += computeMinLevel(ER_CEIL, substat.getStatValue());
                        break;
                    case "CRIT RATE": minLevels += computeMinLevel(CRIT_CEIL, substat.getStatValue());
                        break;
                    case "CRIT DMG": minLevels += computeMinLevel(CRIT_DMG_CEIL, substat.getStatValue());
                        break;

                    default:
                        result = false;
                }
            }
        }
        //5-star artifacts in the game can have a maximum of 5 stat upgrades
        if(minLevels > 5) {
            result = false;
        }

        return result;
    }

    //simple helper function for computing the number of upgrades
    private static int computeMinLevel(double statCeil, double statValue) {
        return (int)(statCeil / statValue);
    }

    /**
     * Method for parsing a csv file into a list of dtos for saving into the database
     *
     * @param file A MultipartFile uploaded through a form to Spring
     * @return a list of ArtifactDtos for persisting to the database
     */
    public static List<ArtifactDto> parseFile(MultipartFile file, long id) {
        List<ArtifactDto> artifactDtos = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            String line;
            String[] separated;
            while((line = reader.readLine()) != null) {
                separated = line.split(",");
                ArtifactDto dto = new ArtifactDto();
                dto.setSet(separated[0]);
                dto.setSlot(separated[1]);

                int nameValuePair = 0;
                String[] statNames = new String[5];
                double[] statValues = new double[5];
                for(int i = 2; i < separated.length; i += 2) {
                    statNames[nameValuePair] = separated[i];
                    statValues[nameValuePair] = Double.parseDouble(separated[i + 1]);
                    nameValuePair += 1;
                }

                dto.setStatNames(statNames);
                dto.setStatValues(statValues);
                dto.setUserId(id);
                artifactDtos.add(dto);
            }

            reader.close();
            return artifactDtos;
        }
        catch(IOException exc) {
            throw new RuntimeException("There was an error reading or parsing the file");
        }

    }
}
