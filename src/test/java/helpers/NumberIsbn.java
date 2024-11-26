package helpers;

public class NumberIsbn {

    static public String getIsbn(String isbn) {
        return switch (isbn) {
            case "9781449365035" -> "Speaking JavaScript";
            case "9781449325862" -> "Git Pocket Guide";
            default -> throw new IllegalStateException("Unexpected value: " + isbn);
        };
    }
}
