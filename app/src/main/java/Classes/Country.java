package Classes;

/**
 * Created by David on 01-May-17.
 */

public class Country {
    private int id;
    private String name;
    private int flag;
    private String capital;
    private String official_language;
    private Double surface;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getOfficial_language() {
        return official_language;
    }

    public void setOfficial_language(String official_language) {
        this.official_language = official_language;
    }

    public Double getSurface() {
        return surface;
    }

    public void setSurface(Double surface) {
        this.surface = surface;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public Country(int id, String name, int flag, String capital, String official_language, Double surface) {
        this.id = id;
        this.name = name;
        this.flag = flag;
        this.capital = capital;
        this.official_language = official_language;
        this.surface = surface;
    }
}

