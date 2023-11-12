package christmas.model.enums;

public enum Menu {
    MUSHROOM_SOUP("양송이수프", "appetizer", 6000),
    TAPAS("타파스", "appetizer", 5500),
    CAESAR_SALAD("시저샐러드", "appetizer", 8000),
    T_BONE_STEAK("티본스테이크", "main", 55000),
    BARBECUE_RIBS("바비큐립", "main", 54000),
    SEAFOOD_PASTA("해산물파스타", "main", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", "main", 25000),
    CHOCOLATE_CAKE("초코케이크", "dessert", 15000),
    ICE_CREAM("아이스크림", "dessert", 5000),
    ZERO_COLA("제로콜라", "drink", 3000),
    RED_WINE("레드와인", "drink", 60000),
    CHAMPAGNE("샴페인", "drink", 25000);

    private String name;
    private String type;
    private int price;

    Menu(String name, String type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    private static Menu getMenuByName(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.name.equals(name)) {
                return menu;
            }
        }
        return null;
    }

    public static boolean isNotExistMenu(String name) {
        Menu menu = getMenuByName(name);
        return menu == null;
    }

    public static String getTypeByName(String name) {
        Menu menu = getMenuByName(name);
        return menu.type;
    }

    public static int getPriceByName(String name) {
        Menu menu = getMenuByName(name);
        return menu.price;
    }
}
