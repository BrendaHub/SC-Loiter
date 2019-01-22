package com.example.orderdemo.utils;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class KeyUtilsTest {

    @Test
    public void getKey() {
        String randStr = KeyUtils.getKey();
        Assert.assertTrue(randStr != null);
    }
}