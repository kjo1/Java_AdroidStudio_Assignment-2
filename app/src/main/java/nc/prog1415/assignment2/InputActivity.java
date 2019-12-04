package nc.prog1415.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class InputActivity extends AppCompatActivity {
    private Data getData = new Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        final ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) findViewById(R.id.txtToggle);
                getData.soundOn = !getData.soundOn;
                tv.setText(getData.soundOn ? "Sound is On" : "Sound is Off");
            }
        });

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressBar.setProgress(progress);
                ((TextView)findViewById(R.id.txtSeekBar)).setText("Speed:" + progress);
                getData.speed = seekBar.getProgress();
                seekBar.setSecondaryProgress((progress+seekBar.getMax())/2);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        Switch switch1 = (Switch) findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    Toast.makeText(getBaseContext(), "Setting is On", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getBaseContext(), "Setting is Off", Toast.LENGTH_SHORT).show();
                }
                getData.settingOn = isChecked;
            }
        });

        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.RadioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                TextView tv =(TextView) findViewById(R.id.txtDifficulty);
                if (checkedId != -1){
                    RadioButton rb = (RadioButton) findViewById(checkedId);
                    if(rb != null){
                        tv.setText("Difficulty: " + rb.getText());
                    }
                    else{
                        tv.setText("Difficulty:     ");
                    }
                }
                getData.difficulty = checkedId;
            }
        });

        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                getData.godModeOn = isChecked;
                checkBox.setText(isChecked ? "God Mode Enabled" : "God Mode Disabled");
            }
        });

        final RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                getData.rating = rating;
                ((TextView)findViewById(R.id.txtRating)).setText("Game Rating: " + rating);
            }
        });

        final EditText text = (EditText)findViewById(R.id.editTextFeedback);

        final Button buttonFeedback = (Button)findViewById(R.id.buttonFeedback);
        buttonFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.getText().toString().length() == 0){
                    text.setError("Please type any feedback");
                }else {
                    Toast.makeText(InputActivity.this, "Your Feedback ' " + text.getText() + " ' has sent", Toast.LENGTH_SHORT).show();
                    getData.feedback = text.toString();
                    text.setText("");
                }
            }
        });
    }

    public void moveMainActivity(View view) {
        startActivity(new Intent(this, MainActivity.class));
        Toast.makeText(this, "I will be back", Toast.LENGTH_SHORT).show();
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