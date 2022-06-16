package com.tek.genshinbuildapp.utility;

import com.tek.genshinbuildapp.model.ArtifactSubstat;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public final class ArtifactUtility {

    private static double flatHpCeil   = 298.8;
    private static double flatAtkCeil  = 19.51;
    private static double flatDefCeil  = 23.2;
    private static double hpCeil       = 5.9;
    private static double atkCeil      = 5.9;
    private static double defCeil      = 7.3;
    private static double critCeil     = 23.4;
    private static double critDmgCeil  = 6.5;
    private static double emCeil       = 3.91;
    private static double erCeil       = 7.81;

    private ArtifactUtility() {
    }

    public static boolean validateSubstats(ArtifactSubstat[] artifactSubstats) {
        boolean result = true;
        int minLevels = 0;

        for(ArtifactSubstat substat : artifactSubstats) {
            if(result) {
                switch (substat.getStatName().toUpperCase()) {
                    case "HP": minLevels += computeMinLevel(flatHpCeil, substat.getStatValue());
                        break;
                    case "ATK": minLevels += computeMinLevel(flatAtkCeil, substat.getStatValue());
                        break;
                    case "DEF": minLevels += computeMinLevel(flatDefCeil, substat.getStatValue());
                        break;
                    case "HP PERCENT": minLevels += computeMinLevel(hpCeil, substat.getStatValue());
                        break;
                    case "ATK PERCENT": minLevels += computeMinLevel(atkCeil, substat.getStatValue());
                        break;
                    case "DEF PERCENT": minLevels += computeMinLevel(defCeil, substat.getStatValue());
                        break;
                    case "ELEMENTAL MASTERY": minLevels += computeMinLevel(emCeil, substat.getStatValue());
                        break;
                    case "ENERGY RECHARGE": minLevels += computeMinLevel(erCeil, substat.getStatValue());
                        break;
                    case "CRIT RATE": minLevels += computeMinLevel(critCeil, substat.getStatValue());
                        break;
                    case "CRIT DMG": minLevels += computeMinLevel(critDmgCeil, substat.getStatValue());
                        break;

                    default:
                        result = false;
                }
            }
        }

        if(minLevels > 5) {
            result = false;
        }

        return result;
    }

    private static int computeMinLevel(double statCeil, double statValue) {
        return (int)(statCeil / statValue);
    }
}
