package enums;

public enum BotState {

    START;


    public static BotState fromString(String name) {
        for (BotState value : BotState.values()) {
            if (value.name().equals(name))
                return value;
        }
        return null;
    }
}

