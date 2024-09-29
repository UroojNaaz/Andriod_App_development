package com.example.dataparsingapp;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String URL = "https://jsonplaceholder.typicode.com/users";
    private ArrayList<User> userList = new ArrayList<>();
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);

        // Initialize Volley request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // Create a JSON Array request
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            // Loop through the response
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject userObject = response.getJSONObject(i);
                                User user = new User();
                                user.setId(userObject.getInt("id"));
                                user.setName(userObject.getString("name"));
                                user.setUsername(userObject.getString("username"));
                                user.setEmail(userObject.getString("email"));

                                // Parse address
                                JSONObject addressObject = userObject.getJSONObject("address");
                                Address address = new Address();
                                address.setStreet(addressObject.getString("street"));
                                address.setSuite(addressObject.getString("suite"));
                                address.setCity(addressObject.getString("city"));
                                address.setZipcode(addressObject.getString("zipcode"));

                                // Parse geo
                                JSONObject geoObject = addressObject.getJSONObject("geo");
                                Geo geo = new Geo();
                                geo.setLat(geoObject.getString("lat"));
                                geo.setLng(geoObject.getString("lng"));
                                address.setGeo(geo);
                                user.setAddress(address);

                                // Parse phone, website, company
                                user.setPhone(userObject.getString("phone"));
                                user.setWebsite(userObject.getString("website"));

                                JSONObject companyObject = userObject.getJSONObject("company");
                                Company company = new Company();
                                company.setName(companyObject.getString("name"));
                                company.setCatchPhrase(companyObject.getString("catchPhrase"));
                                company.setBs(companyObject.getString("bs"));
                                user.setCompany(company);

                                // Add user to the list
                                userList.add(user);
                            }

                            // Notify adapter about data change
                            userAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley Error", error.toString());
                    }
                });

        // Add the request to the RequestQueue
        requestQueue.add(jsonArrayRequest);
    }
}
