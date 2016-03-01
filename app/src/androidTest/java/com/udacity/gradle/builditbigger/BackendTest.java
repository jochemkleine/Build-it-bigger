package com.udacity.gradle.builditbigger;


/**
 * Created by Jochemkleine on 18-2-2016.
 */
import android.test.AndroidTestCase;

import com.udacity.gradle.builditbigger.ObtainJokeTask;

import junit.framework.Assert;
import junit.framework.TestCase;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runners.model.TestClass;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class BackendTest extends AndroidTestCase {


    public BackendTest () {}

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void verifyResponse () {
        String joke = "";
        System.out.println("VERIFY RESPONSE TEST RAN" ) ;
        try {
            joke = new ObtainJokeTask().execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        assertFalse(joke.equals(""));

    }
}
