package nc.prog1415.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
/* Modified by Kanghyun Jo
* 2019-10-18 ~ 20
* Assignment 2
*/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void moveThirdActivity(View view) {
        startActivity(new Intent(this, SecondActivity.class));
        Toast.makeText(this, "Image", Toast.LENGTH_SHORT).show();
    }

    public void moveSecondActivity(View view) {
        startActivity(new Intent(this, ThirdActivity.class));
        Toast.makeText(this, "Music", Toast.LENGTH_SHORT).show();
    }

    public void moveInputActivity(View view) {
        startActivity(new Intent(this, InputActivity.class));
        Toast.makeText(this, "Option", Toast.LENGTH_SHORT).show();
    }
}
