package ae.ac.hct.tkamal.bmiroom;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface PersonDAO {
    @Insert
    public long insert(Person person);

    @Query("SELECT * FROM person")
    public List<Person> getAllPersons();

    @Query("SELECT * FROM person WHERE name=:personName")
    public Person getPersonByName(String personName);

    @Update
    public int update(Person person);

    @Query("DELETE FROM person WHERE name=:personName")
    public int deletePersonByName(String personName);
}
