package com.tram.way.rabat.Activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tram.way.rabat.R;
public class horaires_ramadan extends Fragment {



    public horaires_ramadan(){
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_horaires_ramadan,container,false);

    }
}