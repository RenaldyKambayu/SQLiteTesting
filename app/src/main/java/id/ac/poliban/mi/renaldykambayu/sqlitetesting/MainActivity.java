package id.ac.poliban.mi.renaldykambayu.sqlitetesting;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Friend> data = new ArrayList<>();
    {
        data.add(new Friend("Ahmad Irfan", "Kampung Arab, Banjarmasin", "0812224"));
        data.add(new Friend("Akhmad Indrawan", "HKSN, Banjarmasin", "0812225"));
        data.add(new Friend("Andre Ramadhandy", "Sungai Andai, Banjarmasin", "0812226"));
        data.add(new Friend("Andri Sudarman", "Kayutangi, Banjarmasin", "0812227"));
    }


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar()!=null) getSupportActionBar().setTitle("SQLite I Demo");

        //views to objects
        EditText etId = findViewById(R.id.etID);

        Button btUpgrade= findViewById(R.id.btUpgrade);
        Button btInsert= findViewById(R.id.btInsert);
        Button btUpdate= findViewById(R.id.btUpdate);
        Button btDelete= findViewById(R.id.btDelete);
        Button btGetAFriend= findViewById(R.id.btGetAFriend);
        Button btGetAllFriend= findViewById(R.id.btGetAllFriend);

        FriendDaoImplSQLite db = new FriendDaoImplSQLite(this);

        //event handler

        btUpgrade.setOnClickListener(v -> {
            db.onUpgrade(db.getReadableDatabase(), 1, 2);
            Toast.makeText(this, "Upgrade Successed!", Toast.LENGTH_SHORT).show();
        });

        btInsert.setOnClickListener(v -> {
            data.forEach(o-> db.insert(o));
            Toast.makeText(this, "Inserted OK!", Toast.LENGTH_SHORT).show();
        });

        btGetAllFriend.setOnClickListener(v -> {
            db.getAllFriends().forEach(o-> System.out.println(o));
            Toast.makeText(this, "Showing Data OK! Check in 'Run' Monitor!", Toast.LENGTH_SHORT).show();
        });

        btUpdate.setOnClickListener(v -> {
            int id = Integer.parseInt(etId.getText().toString());
            db.update(new Friend(id, "XXX", "XXX", "XXX"));
            Toast.makeText(this, "Update Success! Check in 'Run' Monitor!", Toast.LENGTH_SHORT).show();
        });

        btDelete.setOnClickListener(v -> {
            int id = Integer.parseInt(etId.getText().toString());
            db.delete(id);
            Toast.makeText(this, "Delete Success! Check in 'Run' Monitor!", Toast.LENGTH_SHORT).show();
        });

        btGetAFriend.setOnClickListener(v -> {
            int id = Integer.parseInt(etId.getText().toString());
            Friend f = db.getAFriendById(id);
            Toast.makeText(this, "Get A Friend Success! Check in 'Run' Monitor!", Toast.LENGTH_SHORT).show();
        });

    }
}
