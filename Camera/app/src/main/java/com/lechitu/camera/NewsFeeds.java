package com.lechitu.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class NewsFeeds extends AppCompatActivity {

    private GridView gvFriends;
    private ArrayList<Friend> friendArrayList;
    private FriendsAdapter friendsAdapter;
    private EditText edtStatus;
    private ImageView profile_image;
    private Profile avt ;
    private ImageButton btnShare;
    private void Mapping(){
        gvFriends = (GridView) findViewById(R.id.gvFriends);
        edtStatus = (EditText) findViewById(R.id.edtStatus);
        profile_image = (ImageView) findViewById(R.id.profile_image);
        btnShare = (ImageButton) findViewById(R.id.btnShare);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feeds);

        Mapping();
        postStatus();
        setDataOnListMyFriends();
        toMyProfile();
        avt = new Profile(R.drawable.avt);
        profile_image.setImageResource(avt.getAvt());
        toFrProfile();
        toShareActivity();
    }

    private void toShareActivity() {
        Mapping();
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewsFeeds.this, ShareActivity.class);
                NewsFeeds.this.startActivity(intent);
            }
        });
    }

    private void setDataOnListMyFriends() {
        Mapping();
        friendArrayList = new ArrayList<>();
        friendArrayList.add(new Friend("Doraemon", "Mèo máy đến từ TK XXII, giúp đỡ Nobita",R.drawable.doraemon));
        friendArrayList.add(new Friend("Nobita", "Hậu đậu, tốt bụng",R.drawable.nobita));
        friendArrayList.add(new Friend("Xuka", "Thông minh, học giỏi, tốt bụng",R.drawable.xuka));
        friendArrayList.add(new Friend("Chaien", "To con, bắt nạt bạn bè, hát không hay",R.drawable.chaien));
        friendArrayList.add(new Friend("Xeko", "Nhà giàu, tinh ranh, nịnh bợ",R.drawable.xeko));
        friendArrayList.add(new Friend("Dekhi", "Học giỏi, thông minh, tốt bụng",R.drawable.dekhi));
        friendArrayList.add(new Friend("Conan", "Thông minh, phá án giỏi, thám tử tài ba",R.drawable.conan));
        friendArrayList.add(new Friend("Kid", "Thông minh, siêu trộm",R.drawable.kid));
        friendsAdapter = new FriendsAdapter(NewsFeeds.this, R.layout.line_friend, friendArrayList);
        gvFriends.setAdapter(friendsAdapter);

    }

    private void postStatus(){
        Mapping();
        edtStatus.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if((event.getAction()==KeyEvent.ACTION_DOWN)&&(keyCode==KeyEvent.KEYCODE_ENTER)&& !TextUtils.isEmpty(edtStatus.getText().toString())){
                    friendArrayList.add(0, new Friend("Lê Chí Tú", edtStatus.getText().toString(), profile_image.getDrawable()));
                    edtStatus.setText("");
                    return true;
                }
                return false;
            }
        });
    }

    private void toMyProfile(){
        Mapping();
        profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewsFeeds.this, MyProfile.class);
                intent.putExtra("myAvt", avt.getAvt());
                NewsFeeds.this.startActivity(intent);
            }
        });
    }
    private void toFrProfile(){
        Mapping();
        gvFriends.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NewsFeeds.this, FrProfileActivity.class);
                Friend friend = new Friend(friendArrayList.get(position).getName(), friendArrayList.get(position).getStatus(), friendArrayList.get(position).getAvatar());
                intent.putExtra("friend", friend);
                NewsFeeds.this.startActivity(intent);



            }
        });
    }
}
