package com.janus.janusapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;

import com.janus.janusapp.classes.User;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link profileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class profileFragment extends Fragment{



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private User MainUser;
    TextView userName, fullName,Email, Gender,birthdate;
    Button fl;

    /** Bueno, en esta sección hago las animaciones de los botopnes para la edición del perfil,
     * así que por eso declaro las siguientes 4 ANIMACIONES, y los 3 botones*/

    private Animation rotateOpen ;//= AnimationUtils.loadAnimation(this.getContext(),R.anim.rotate_open_anim);
    private Animation rotateClose ;//= AnimationUtils.loadAnimation( this.getContext(),R.anim.rotate_close_anim);
    private Animation fromBottom ;//= AnimationUtils.loadAnimation(this.getContext(),R.anim.from_bottom_anim);
    private Animation toBottom ;//= AnimationUtils.loadAnimation( this.getContext(),R.anim.to_bottom_anim);


    private FloatingActionButton more_buttons;
    private FloatingActionButton edit_profile_picture;
    private FloatingActionButton edit_profile;
    private boolean clicked = false;

    /**=======================================================================================================*/



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public profileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment profileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static profileFragment newInstance(String param1, String param2) {
        profileFragment fragment = new profileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainUser=Inicio.MainUser;
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    private void deployMoreButtons(){
        setVisibility(clicked);
        setAnimation(clicked);
        clicked = !clicked;
    }

    private void setVisibility(boolean clicked){
        if(clicked){
            edit_profile.setVisibility(View.INVISIBLE);
            edit_profile_picture.setVisibility(View.INVISIBLE);
        }
        else {
            edit_profile.setVisibility(View.VISIBLE);
            edit_profile_picture.setVisibility(View.VISIBLE);
        }
    }

    private void setAnimation(boolean clicked){
        if(clicked){
            edit_profile_picture.startAnimation(toBottom);
            edit_profile.startAnimation(toBottom);
            more_buttons.startAnimation(rotateClose);
        }
        else {
            edit_profile_picture.startAnimation(fromBottom);
            edit_profile.startAnimation(fromBottom);
            more_buttons.startAnimation(rotateOpen);
        }
    }


    private void setClickable(boolean clicked){
        if (clicked){
            edit_profile_picture.setClickable(true);
            edit_profile.setClickable(true);
        }
        else {
            edit_profile_picture.setClickable(false);
            edit_profile.setClickable(false);
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_profile, container, false);
        userName=view.findViewById(R.id.username);
        fullName=view.findViewById(R.id.fullname);
        Email= view.findViewById(R.id.email);
        birthdate=view.findViewById(R.id.birthdate);
        Gender=view.findViewById(R.id.gender);
        userName.setText(MainUser.username);
        fullName.setText(MainUser.firstName+" "+MainUser.lastName);
        Email.setText(MainUser.email);
        birthdate.setText(MainUser.birthDate);
        Gender.setText(MainUser.gender);
        rotateOpen = AnimationUtils.loadAnimation(getActivity(),R.anim.rotate_open_anim);
        rotateClose = AnimationUtils.loadAnimation( getActivity(),R.anim.rotate_close_anim);
        fromBottom = AnimationUtils.loadAnimation(getActivity(),R.anim.from_bottom_anim);
        toBottom = AnimationUtils.loadAnimation( getActivity(),R.anim.to_bottom_anim);

        more_buttons = view.findViewById(R.id.buttons_to_edit);
        edit_profile =  view.findViewById(R.id.edit_profile);
        edit_profile_picture = view.findViewById(R.id.edit_profile_picture);


        more_buttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deployMoreButtons();
            }
        });
        edit_profile_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return view;
    }
    
}/** Aquí declaro los "Clicklisteners" de los 3 botones, el que despliega ambos,
 * y el que edita el perfil, como el que edita sólo la foto */