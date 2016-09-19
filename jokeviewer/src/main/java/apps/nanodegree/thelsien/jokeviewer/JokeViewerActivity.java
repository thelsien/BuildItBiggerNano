package apps.nanodegree.thelsien.jokeviewer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeViewerActivity extends AppCompatActivity {

    public static final String INTENT_JOKE_STRING_EXTRA = "joke_string_extra";

    private TextView jokeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_viewer);

        jokeView = (TextView) findViewById(R.id.tv_joke);

        Intent intent = getIntent();
        if (intent != null) {
            jokeView.setText(intent.getStringExtra(INTENT_JOKE_STRING_EXTRA));
        }
    }
}
