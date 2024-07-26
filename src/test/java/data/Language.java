package data;

public enum Language {
    EN("en","img.mw-logo-icon"),
    RU("ru","a.mw-wiki-logo"),
    SP("es","img.mw-logo-icon");

    public final String searchString;
    public final String cssSelector;


    Language(String searchString, String greeting){
        this.searchString = searchString;
        this.cssSelector = greeting;
    }
}
