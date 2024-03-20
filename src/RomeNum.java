
enum RomeNum {
    I, II, III, IV, V, VI, VII, VIII, IX, X;
    public static RomeNum findByName(String name) {
        RomeNum result = null;
        for (RomeNum direction : values()) {
            if (direction.name().equalsIgnoreCase(name)) {
                result = direction;
                break;
            }
        }
        return result;
    }
    }