package net.bellbind.alcsearch;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class AlcSearch extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        Intent intent = getIntent();
        String action = intent.getAction();
        if (action.equals(Intent.ACTION_SEND)) {
            Bundle extras = intent.getExtras();
            CharSequence data = extras.getCharSequence(Intent.EXTRA_TEXT);
            //String url = "https://encrypted.google.com/#q=" + data;
            String url = "http://eow.alc.co.jp/" + data + "/UTF-8/?ref=sa";
            Uri uri = Uri.parse(url);
            Intent sender = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(sender);
        }
        finish();
    }
}
