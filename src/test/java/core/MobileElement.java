package core;

public class MobileElement {
    public ElementBy By;
    public String selector;
    public String description;
    public boolean scroll = true;

    public MobileElement(ElementBy By, String selector, String description) {
        this.By = By;
        this.selector = selector;
        this.description = description;
    }

    public MobileElement(ElementBy By, String element, String description, boolean scroll) {
        this.By = By;
        this.selector = element;
        this.description = description;
        this.scroll = scroll;
    }
}
