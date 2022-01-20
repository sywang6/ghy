package org.kurniawan.howtotomcatwork.ex03.pyrmont;

import org.kurniawan.howtotomcatwork.ex03.pyrmont.connector.http.HttpRequest;
import org.kurniawan.howtotomcatwork.ex03.pyrmont.connector.http.HttpResponse;
import java.io.IOException;

public class StaticResourceProcessor {

  public void process(HttpRequest request, HttpResponse response) {
    try {
      response.sendStaticResource();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

}
