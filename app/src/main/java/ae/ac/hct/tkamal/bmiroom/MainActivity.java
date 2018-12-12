package ae.ac.hct.tkamal.bmiroom;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText etName;
    private EditText etHeight;
    private EditText etWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
    }

    public void addPerson(View view) {
        String strName = etName.getText().toString();
        String strHeight = etHeight.getText().toString();
        String strWeight = etWeight.getText().toString();

        double height = Double.parseDouble(strHeight);
        double weight = Double.parseDouble(strWeight);

        Person person = new Person(strName, height, weight);

        PersonDatabase personDatabase = PersonDatabase.getPersonDatabase(this.getApplicationContext());
        PersonDAO personDAO = personDatabase.getPersonDAO();

        long status = personDAO.insert(person);

        if (status == 1) {
            Toast.makeText(this, strName + " record added!!!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, strName + "add failed!!!", Toast.LENGTH_SHORT).show();
        }
    }

    public void findPerson(View view) {
        String strName = etName.getText().toString();

        PersonDatabase personDatabase = PersonDatabase.getPersonDatabase(this.getApplicationContext());
        PersonDAO personDAO = personDatabase.getPersonDAO();

        Person person = personDAO.getPersonByName(strName);

        if (person != null) {
            etHeight.setText(person.getHeight() +"");
            etWeight.setText(person.getWeight() + "");
            Toast.makeText(this, strName + " found", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, strName + " not found", Toast.LENGTH_SHORT).show();
        }
    }
}
