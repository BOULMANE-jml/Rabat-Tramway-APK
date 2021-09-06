package com.tram.way.rabat.Activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tram.way.rabat.R;


public class horaires_normal extends Fragment {



    public horaires_normal(){
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_horaires_normal,container,false);

    }
}