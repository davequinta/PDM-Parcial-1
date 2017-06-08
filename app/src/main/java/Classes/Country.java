package Classes;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by David on 01-May-17.
 */





public class Country implements Parcelable {
    public int id;
    public String name;
    public int flag;
    public String capital;
    public String official_language;
    public Double surface;


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



    public Country(Parcel source) {
        id = source.readInt();
        name = source.readString();
        flag = source.readInt();
        capital = source.readString();
        official_language = source.readString();
        surface = source.readDouble();
    }

    @Override
    public int describeContents() {
        return this.hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeInt(flag);
        parcel.writeString(capital);
        parcel.writeString(official_language);
        parcel.writeDouble(surface);
    }

    public static final Parcelable.Creator CREATOR
            = new Parcelable.Creator() {
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Object[] newArray(int i) {
            return new Country[i];
        }
    };
}
