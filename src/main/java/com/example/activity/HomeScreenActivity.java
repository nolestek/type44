package com.example.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import com.example.HomeSelectionAdapter;
import com.example.R;
import com.example.RssItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeScreenActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
      this.requestWindowFeature(Window.FEATURE_NO_TITLE);

      //Remove notification bar
      this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

      setContentView(R.layout.home_screen);

      ListView selection_view = (ListView) findViewById(R.id.home_listview);

      String[] selections = getResources().getStringArray(R.array.selections);

      List<String> menu_items = Arrays.asList(selections);
      final HomeSelectionAdapter adapter = new HomeSelectionAdapter(menu_items);

      selection_view.setAdapter(adapter);

      selection_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

              switch(position){
                  case 0:
                    Intent intent1 = new Intent(getApplicationContext(), RSSActivity.class);
                    startActivity(intent1);
                      break;
                  case 2:
                      String uri = "https://www.facebook.com/CrossFitType44";
                      Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                      startActivity(intent2);
                      break;
              }
          }
      });

      /*ImageView rssImage = (ImageView)findViewById(R.id.rss_icon);
      rssImage.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(getApplicationContext(), RSSActivity.class);
              startActivity(intent);
          }
      });*/
  }
}
