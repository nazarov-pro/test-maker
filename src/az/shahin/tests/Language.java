/*
 * Copyright 2015 Shaheen Group.
 *
 * Contact by : s0552676097@gmail.com
 * All rights reserved !
 */
package az.shahin.tests;

/**
 *
 * @author Shahin Nazarov <s0552676097@gmail.com>
 */
public enum Language {

    AFRIKAANS("af", 2),
    ALBANIAN("sq", 3),
    ARABIC("ar", 4),
    AZERBAIJANI("az", 5),
    BASQUE("eu", 6),
    BELARUSIAN("be", 7),
    BENGALI("bn", 8),
    BULGARIAN("bg", 9),
    CATALAN("ca", 10),
    CHINESE("zh-CN", 11),
    CROATIAN("hr", 12),
    CZECH("cs", 13),
    DANISH("da", 14),
    DUTCH("nl", 15),
    ENGLISH("en", 16),
    ESTONIAN("et", 17),
    FILIPINO("tl", 18),
    FINNISH("fi", 19),
    FRENCH("fr", 20),
    GALICIAN("gl", 21),
    GEORGIAN("ka", 22),
    GERMAN("de", 23),
    GREEK("el", 24),
    GUJARATI("gu", 25),
    HAITIAN_CREOLE("ht", 26),
    HEBREW("iw", 27),
    HINDI("hi", 28),
    HUNGARIAN("hu", 29),
    ICELANDIC("is", 30),
    INDONESIAN("id", 31),
    IRISH("ga", 32),
    ITALIAN("it", 33),
    JAPANESE("ja", 34),
    KANNADA("kn", 35),
    KOREAN("ko", 36),
    LATIN("la", 37),
    LATVIAN("lv", 38),
    LITHUANIAN("lt", 39),
    MACEDONIAN("mk", 40),
    MALAY("ms", 41),
    MALTESE("mt", 42),
    NORWEGIAN("no", 43),
    PERSIAN("fa", 44),
    POLISH("pl", 45),
    PORTUGUESE("pt", 46),
    ROMANIAN("ro", 47),
    RUSSIAN("ru", 48),
    SERBIAN("sr", 49),
    SLOVAK("sk", 50),
    SLOVENIAN("sl", 51),
    SPANISH("es", 52),
    SWAHILI("sw", 53),
    SWEDISH("sv", 54),
    TAMIL("ta", 55),
    TELUGU("te", 56),
    THAI("th", 57),
    TURKISH("tr", 58),
    UKRAINIAN("uk", 59),
    URDU("ur", 60),
    VIETNAMESE("vi", 61),
    WELSH("cy", 62),
    YIDDISH("yi", 63),
    CHINESE_SIMPLIFIED("zh-CN", 64),
    CHINESE_TRADITIONAL("zh-TW", 65);
    private String text;
    private int id;

    private Language(String text, int id) {
        this.text = text;
        this.id = id-2;
    }

    public int getId() {
        return id;
    }
    public String getText() {
        return text;
    }

}
