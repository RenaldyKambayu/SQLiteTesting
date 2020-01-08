package id.ac.poliban.mi.renaldykambayu.sqlitetesting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

public interface FriendDao {
    void insert(Friend f);
    void update(Friend f);
    void delete(int id);
    Friend getAFriendById(int id);
    List<Friend> getAllFriends();
}
