package nc.prog1415.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private boolean firstImageShown = true;
    private boolean secondImageShown = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_image:
                startActivity(new Intent(this, SecondActivity.class));
                Toast.makeText(this, "Image", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_music:
                startActivity(new Intent(this, ThirdActivity.class));
                Toast.makeText(this, "Music", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_option:
                startActivity(new Intent(this, InputActivity.class));
                Toast.makeText(this, "Option", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void changeImage(View view) {
        ImageView firstImage = (ImageView) findViewById(R.id.imgMain);

        if ((firstImage != null) && (firstImageShown)) {
            firstImage.setImageResource(R.drawable.after_by_kanghyun);
            firstImageShown = false;
            Toast.makeText(this, "After NC", Toast.LENGTH_SHORT).show();
        } else {
            if (firstImage != null) firstImage.setImageResource(R.drawable.before);
            firstImageShown = true;
            Toast.makeText(this, "Before NC", Toast.LENGTH_SHORT).show();
        }

        ImageView secondImage = (ImageView) findViewById(R.id.imgMain2);
        if ((secondImage != null) && (secondImageShown)) {
            secondImage.setImageResource(R.drawable.after_by_kanghyun);
            secondImageShown = false;
            Toast.makeText(this, "After NC", Toast.LENGTH_SHORT).show();
        } else {
            if (secondImage != null) secondImage.setImageResource(R.drawable.before);
            secondImageShown = true;
            Toast.makeText(this, "Before NC", Toast.LENGTH_SHORT).show();
        }
        //ImageView img = (ImageView) findViewById(R.id.imgMain);
        //img.setImageResource(R.drawable.after_by_kanghyun);
        //changeImage(R.drawable.after_by_kanghyun);
    }
}
