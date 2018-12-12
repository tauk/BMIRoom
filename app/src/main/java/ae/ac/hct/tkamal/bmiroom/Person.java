package ae.ac.hct.tkamal.bmiroom;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "person")
public class Person {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name="name")
    private String name;

    @NonNull
    @ColumnInfo(name="height")
    private double height;

    @NonNull
    @ColumnInfo(name="weight")
    private double weight;

    public Person(String name, double height, double weight ) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public double getHeight() {
        return height;
    }

    @NonNull
    public double getWeight() {
        return weight;
    }
}
