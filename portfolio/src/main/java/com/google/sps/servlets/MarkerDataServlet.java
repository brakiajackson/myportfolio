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
// import com.google.sps.data.AddedMarker;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/marker-data")
//public class MarkerDataServlet extends HttpServlet {

  // private Collection<AddedMarker> AddedMarkers;

 // @Override
  //public void init() {
   // AddedMarkers = new ArrayList<>();

  //  Scanner scanner = new Scanner(getServletContext().getResourceAsStream("/WEB-INF/marker-data.csv"));
  //  while (scanner.hasNextLine()) {
  //    String line = scanner.nextLine();
   //   String[] cells = line.split(",");
//
 //     double lat = Double.parseDouble(cells[0]);
 //     double lng = Double.parseDouble(cells[1]);
//
  //    AddedMarkers.add(new AddedMarkers(lat, lng));
 //   }
  //  scanner.close();
 // }

 // @Override
  //public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
  //  response.setContentType("application/json");
   // Gson gson = new Gson();
   // String json = gson.toJson(AddedMarkers);
  //  response.getWriter().println(json);
 // }
//}