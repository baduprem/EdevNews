package com.example.designmodal.edevnews.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.designmodal.edevnews.Adapter.NewsRvAdapter;
import com.example.designmodal.edevnews.DataManager.ApiClient;
import com.example.designmodal.edevnews.DataManager.ApiInterface;
import com.example.designmodal.edevnews.Model.NewsModel;
import com.example.designmodal.edevnews.R;
import com.example.designmodal.edevnews.VerticalSpace;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by compware on 6/17/2018.
 */

public class NewsFragment extends Fragment
{
    RecyclerView recyclerView;
    String myValue;
    SwipeRefreshLayout mSwipe;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.news_recyclerview, container, false);
        Bundle args = getArguments();
         myValue = args.getString("category_id_Param");
        recyclerView = view.findViewById(R.id.news_rv);
        recyclerView.addItemDecoration(new VerticalSpace(10));
        mSwipe = view.findViewById(R.id.swipeRefreshLayout);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh() {
                LoadNews();
            }
        });
        LoadNews();

    }


    private void LoadNews()
    {
            ApiInterface service = ApiClient.getRetrofit().create(ApiInterface.class);
        Toast.makeText(getContext(), myValue, Toast.LENGTH_SHORT).show();
            Call<List<NewsModel>> call = service.getNews(myValue);

            call.enqueue(new Callback<List<NewsModel>>() {
                @Override
                public void onResponse(Call<List<NewsModel>> call, Response<List<NewsModel>> response) {
                    //Log.d("onResponse", response.message());

                    List<NewsModel> NewsList = response.body();
                    //layoutManager = new LinearLayoutManager(MainActivity.this);
                    NewsRvAdapter newsRvAdapter = new NewsRvAdapter(getContext(),NewsList);
                    recyclerView.setAdapter(newsRvAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                      mSwipe.setRefreshing(false);
                }
                @Override
                public void onFailure(Call<List<NewsModel>> call, Throwable t)
                {
                    Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
                    t.printStackTrace();
                }
            });
    }

}
