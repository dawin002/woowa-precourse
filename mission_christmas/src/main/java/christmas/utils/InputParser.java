package christmas.utils;

public class InputParser {
    private final static String SEPARATOR = "-";
    private final static int MENU_INDEX = 0;
    private final static int QUANTITY_INDEX = 1;

    public static String getMenu(String inputOrder) {
        String[] splitOrder = inputOrder.split(SEPARATOR);
        return splitOrder[MENU_INDEX];
    }

    public static int getQuantity(String inputOrder) {
        String[] splitOrder = inputOrder.split(SEPARATOR);
        return Integer.parseInt(splitOrder[QUANTITY_INDEX]);
    }
}
