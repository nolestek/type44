package com.example.activity;

import com.example.Type44RssParser;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.io.InputStream;

@RunWith(RobolectricTestRunner.class)
public class Type44RssParserTest {
    private Type44RssParser parser;
    private InputStream inputStream;

    @Before
    public void setup(){
        parser = new Type44RssParser();

    }

}
