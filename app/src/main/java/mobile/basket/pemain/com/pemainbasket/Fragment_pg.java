package mobile.basket.pemain.com.pemainbasket;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



public class Fragment_pg extends Fragment {

    private String url = "https://ilyasyadamara.github.io/pemainbasket.json";

    private RecyclerView recyclerView;
    private Fragment fragment;

    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<PlayerItem> list;
    private RecyclerView.Adapter adapter;

    public Fragment_pg() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Posisi Point Guard");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_pg, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        list = new ArrayList<>();
        adapter = new ListViewAdapter(getContext(), list);

        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), linearLayoutManager.getOrientation());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);

        getData();

        return view;

    }

    // public interface OnItemClickListener {
    //    void onItemClick(List item);
    // }

    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {

                        JSONObject jsonObject = response.getJSONObject(i);
                         if ( jsonObject.getString("Position").equalsIgnoreCase("Point Guard")) {
                             PlayerItem player = new PlayerItem();
                             player.setName(jsonObject.getString("name"));
                             player.setTeam(jsonObject.getString("team"));
                             player.setPosition(jsonObject.getString("Position"));
                             player.setDeskripsi(jsonObject.getString("Deskripsi"));
                             player.setPoster(jsonObject.getString("Poster"));

                             list.add(player);
                         }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(jsonArrayRequest);
    }

    //@Override
   // public void onrowpemaincallback(PlayerItem playerItem) {

    //}
}

