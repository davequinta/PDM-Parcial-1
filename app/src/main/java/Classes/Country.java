package Classes;

/**
 * Created by David on 01-May-17.
 */

public class Country {
    private String name;
    private String flag;
    private String capital;
    private String official_language;
    private Double surface;

    public Country(String name, String flag, String capital, String official_language, Double surface){
        this.name = name;
        this.flag = flag;
        this.capital = capital;
        this.official_language = official_language;
        this.surface = surface;
    }
}

