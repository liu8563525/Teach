package com.kevin.utils;

import java.nio.charset.Charset;

import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;

public class MyStringHttpMessageConverter extends StringHttpMessageConverter {

    private static final MediaType utf8 = new MediaType("text", "plain", Charset.forName("UTF-8"));

    @Override
    protected MediaType getDefaultContentType(String dumy) {
        return utf8;
    }

}
