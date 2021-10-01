package com.example.jenit.dyuthiapp.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.jenit.dyuthiapp.R;
import com.example.jenit.dyuthiapp.adapter.EventAdapter;
import com.example.jenit.dyuthiapp.api.ApiClient;
import com.example.jenit.dyuthiapp.api.ApiInterface;
import com.example.jenit.dyuthiapp.model.EventDetailsResponseBean;
import com.example.jenit.dyuthiapp.model.EventsDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventList extends AppCompatActivity {

    private static final String TAG = EventList.class.getSimpleName();
    public String url;

    private final static String API_KEY = "a780e4ca292bd0d419c740b86d62b4ea";
    private ProgressDialog progressDialog;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_eventlist);
        url = getIntent().getExtras().getString("url");
        progressDialog = new ProgressDialog(this);
        progressDialog.show();

        if (API_KEY.isEmpty()) {
        }

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.events_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<EventDetailsResponseBean> call = apiService.getEventDetails();
        call.enqueue(new Callback<EventDetailsResponseBean>() {
            @Override
            public void onResponse(Call<EventDetailsResponseBean> call, Response<EventDetailsResponseBean> response) {
                int statusCode = response.code();
                List<EventsDetails> events = response.body().getResult();
                recyclerView.setAdapter(new EventAdapter(events, R.layout.eventlist_layout, getApplicationContext()));
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<EventDetailsResponseBean> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }

}