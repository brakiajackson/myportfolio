// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;


import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;
import java.util.List;
import java.util.Arrays;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {


    @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
      // Gets Input
      String Com = getParameter(request, "comment-input", "");
      String name1= getParameter(request, "name-input", "");
      long timestamp = System.currentTimeMillis();
      


      String[] words = name1.split("\\s*,\\s*");

      Entity commentEntity = new Entity("Comment");
      commentEntity.setProperty("body", Com);
      commentEntity.setProperty("name", words[0]);
      commentEntity.setProperty("timestamp", timestamp);

      DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
      datastore.put(commentEntity);

      response.setContentType("text/html;");
   

      response.sendRedirect("response.html");

      // Get the input from the form.
  
    }

    private String getParameter(HttpServletRequest request, String name, String defaultValue) {
        String value = request.getParameter(name);
        if (value == null) {
            return defaultValue;
        }
        return value;
    }
  
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query("Comments").addSort("timestamp", SortDirection.DESCENDING);

    PreparedQuery results = datastore.prepare(query);

    ArrayList<ArrayList> comment = new ArrayList<>();

    for (Entity entity : results.asIterable()) {
        String name = (String) entity.getProperty("name");
        String body = (String) entity.getProperty("body");
        long id = entity.getKey().getId();
        long timestamp = (long) entity.getProperty("timestamp");
        

        ArrayList<Object> info= new ArrayList<>();

        info.add(name);
        info.add(body);
        info.add(id);

        comment.add(info);
    }


    String json=convertToJsonUsingGson(comment);

    // Send the JSON as the response   

    
    response.setContentType("application/json;");
    response.getWriter().println(json);   
   
    }

    private String convertToJsonUsingGson(ArrayList messages) {
        Gson gson = new Gson();
        String json = gson.toJson(messages);
        return json;
  
    }
    


}