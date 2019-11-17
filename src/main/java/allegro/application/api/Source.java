package allegro.application.api;

public enum Source {

    ALLEGRO("allegro", 1L), OLX("olx", 2L), EBAY("ebay", 3L);

    String name;
    Long id;

    Source(String name, Long id) {
        this.name = name;
        this.id = id;
    }
}
