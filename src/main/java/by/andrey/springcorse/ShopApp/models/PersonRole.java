package by.andrey.springcorse.ShopApp.models;

public enum PersonRole {
    USER ("USER"),
    MANAGER ("MANAGER"),
    ADMIN ("ADMIN"),
    OWNER ("OWNER");


    private final String displayValue;

    PersonRole(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
