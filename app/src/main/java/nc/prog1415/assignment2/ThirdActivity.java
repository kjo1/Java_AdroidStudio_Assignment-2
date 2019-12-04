package nc.prog1415.assignment2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    static MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    public void play(View v) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.queen_we_will_rock_you);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        mediaPlayer.start();
        Toast.makeText(this, "Queen - We will rock you", Toast.LENGTH_SHORT).show();
    }

    public void pause(View v) {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            Toast.makeText(this, "Song paused", Toast.LENGTH_SHORT).show();
        }
    }

    public void stop(View v) {
        stopPlayer();
    }

    private void stopPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            Toast.makeText(this, "Song Stopped", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
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
                Toast.makeText(this, "Video", Toast.LENGTH_SHORT).show();
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
}