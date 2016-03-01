/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.Jochemkleine.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.jochemkleine.JokeTeller;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.myapplication.Jochemkleine.example.com",
    ownerName = "backend.myapplication.Jochemkleine.example.com",
    packagePath=""
  )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back
    @ApiMethod(name = "sayHi")
    public MyBean sayi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Gegroet, " + name);

        return response;
    }
    */
    @ApiMethod(name = "sendJoke")
    public MyBean sendJoke() {
        MyBean response = new MyBean();
        JokeTeller teller = new JokeTeller();
        response.setData(teller.getJoke());

        return response;
    }

}
