public class Sorting{
    public static int sort(Creature creature){
        BooleanState isHumanoid = creature.getHumanoidStatus();
        String planet = creature.getPlanet();
        int age = creature.getAge();
        List<String> traits = creature.getTraits();

        if (isHumanoid == null || isHumanoid == BooleanState.FALSE) {
            if ("Kashyyyk".equalsIgnoreCase(planet) && age > 0 && traits != null && traits.contains("HAIRY")) {
                return 1;
            } else if ("Endor".equalsIgnoreCase(planet) && age > 0 && traits != null && traits.contains("HAIRY")) {
                return 1;
            }
        } else if (isHumanoid != null && isHumanoid == BooleanState.TRUE) {
            if ("Asgard".equalsIgnoreCase(planet) && age > 0 && traits != null && traits.contains("BLONDE")) {
                return 2;
            } else if ("Betelgeuse".equalsIgnoreCase(planet) && age > 0 && traits != null &&
                    (traits.contains("EXTRA_ARMS") || traits.contains("EXTRA_HEAD"))) {
                return 3;
            } else if ("Earth".equalsIgnoreCase(planet)) {
                if (traits != null) {
                    if (traits.contains("BLONDE") && traits.contains("POINTY_EARS")) {
                        return 4;
                    } else if (traits.contains("SHORT") && traits.contains("BULKY")) {
                        return 4;
                    }
                }
            }
        }

        if (planet == null || "UNKNOWN".equalsIgnoreCase(planet)) {
            if (isHumanoid == null || isHumanoid == BooleanState.FALSE) {
                if (age > 0 && traits != null && traits.contains("BULKY")) {
                    return 3;
                }
            } else if (isHumanoid != null && isHumanoid == BooleanState.TRUE) {
                if (traits != null && (traits.contains("EXTRA_ARMS") || traits.contains("EXTRA_HEAD"))) {
                    return 3;
                }
            }
        }

        if (traits != null) {
            if (traits.contains("GREEN") && (isHumanoid == null || isHumanoid == BooleanState.FALSE)) {
                return 3;
            } else if (traits.contains("HAIRY") && age > 0) {
                return 1;
            }
        }

        if (isHumanoid != null) {
            if (isHumanoid == BooleanState.TRUE) {
                return 2;
            } else {
                return 3;
            }
        }

        return -1;
    }


}