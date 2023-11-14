package christmas.utils;

public class InputParser {

    public static String getMenu(String inputOrder) {
        String[] splitOrder = inputOrder.split("-");
        return splitOrder[0];
    }

    public static int getQuantity(String inputOrder) {
        String[] splitOrder = inputOrder.split("-");
        return Integer.parseInt(splitOrder[1]);
    }
}
