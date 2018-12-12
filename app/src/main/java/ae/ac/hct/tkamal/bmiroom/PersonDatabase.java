package ae.ac.hct.tkamal.bmiroom;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Person.class}, version = 1)
public abstract class PersonDatabase extends RoomDatabase {

    public abstract PersonDAO getPersonDAO();

    private static volatile PersonDatabase INSTANCE;

    static PersonDatabase getPersonDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PersonDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PersonDatabase.class, "persondb")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
