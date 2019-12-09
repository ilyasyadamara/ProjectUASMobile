package mobile.basket.pemain.com.pemainbasket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailPemain extends AppCompatActivity {

    ImageView img_photo;
    TextView tv_posisi, tv_name;
    TextView tv_detail, tv_team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pemain);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String position = intent.getStringExtra("Position");
        String deskripsi = intent.getStringExtra("Deskripsi");
        String team = intent.getStringExtra("team");
        String poster = intent.getStringExtra("Poster");

        //id
        img_photo = findViewById(R.id.img_item_photo);
        tv_name = findViewById(R.id.tv_item_name);
        tv_posisi = findViewById(R.id.tv_item_posisi);
        tv_detail = findViewById(R.id.tv_item_detail);
        tv_team = findViewById(R.id.tv_item_lahir);

        tv_name.setText(name)
        ;
        tv_posisi.setText(position);
        tv_detail.setText(deskripsi);
        tv_team.setText(team);


        Glide.with(this)
                .load(poster)
//                .apply(new RequestOptions().override(100, 100))
                .into(img_photo);
    }
}
