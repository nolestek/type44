package com.example.activity;

import com.example.RssAdapter;
import com.example.RssItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class RssAdapterTest {

    @Test
    public void trimTextRemovesHTMLTags(){
        String input = "<a href=\"http://webcon-storage.s3.amazonaws.com/wp-content/uploads/sites/4/2013/11/crossfit-vancouver-funny.jpg\"></a> &#160;Hello";

        //String output = RssAdapter.removeCharacters(input, '<', '>');

       // assertThat(output, equalTo("&#160;"));
    }
}
