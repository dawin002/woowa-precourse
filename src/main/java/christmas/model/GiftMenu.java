package christmas.model;

import christmas.model.enums.Menu;

public class GiftMenu {
    private String name;
    private int quantity;

    public GiftMenu(int totalPrice) {
        this.name = null;
        this.quantity = 0;
        setPresent(totalPrice);
    }

    private void setPresent(int totalPrice) {
        if (isChampagne(totalPrice)) {
            setChampagne();
        }
    }

    private boolean isChampagne(int totalPrice) {
        return totalPrice >= 120000;
    }

    private void setChampagne() {
        this.name = Menu.CHAMPAGNE.getName();
        this.quantity = 1;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
