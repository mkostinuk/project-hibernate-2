package org.example;

public enum SpecialFeature {
//    set('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes')
    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes");
    private final String value;

    SpecialFeature(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
