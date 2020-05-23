package allegro.application.domain;

public enum Source {

    ALLEGRO("allegro"),
    OLX("olx"),
    EBAY("ebay");

    String label;

    Source(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}