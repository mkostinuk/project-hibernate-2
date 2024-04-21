package org.example.enums;

import lombok.Getter;

@Getter
public enum LanguageName {
    ENGLISH("English"),
    ITALIAN("Italian"),
    JAPANESE("Japanese"),
    MANDARIN("Mandarin"),
    FRENCH("French"),
    GERMAN("German");
    private final String value;

    LanguageName(String value) {
        this.value = value;
    }
}
