package com.example.activity;

import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;
import com.example.R;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Robolectric.clickOn;
import static org.robolectric.Robolectric.shadowOf;

@RunWith(RobolectricTestRunner.class)
public class HomeScreenActivityTest {

    private ImageView rssImage;
    private HomeScreenActivity activity;

    @Before
    public void setup(){
        activity = Robolectric.buildActivity(HomeScreenActivity.class).create().visible().get();
        rssImage = (ImageView)activity.findViewById(R.id.rss_icon);
    }

  @org.junit.Test
  public void clickImageStartsNewActivity() throws Exception {
    clickOn(rssImage);

      ShadowActivity shadowActivity = shadowOf(activity);
      Intent startedIntent = shadowActivity.getNextStartedActivity();
      ShadowIntent shadowIntent = shadowOf(startedIntent);
      assertThat(shadowIntent.getComponent().getClassName(), equalTo(RSSActivity.class.getName()));
  }
}
