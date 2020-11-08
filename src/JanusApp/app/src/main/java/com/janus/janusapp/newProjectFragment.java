package com.janus.janusapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.janus.janusapp.classes.Project;
import com.janus.janusapp.classes.User;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link newProjectFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class newProjectFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Spinner ctgr;
    private EditText projectName, projectGoal,projectDscr;
    private Button create;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public newProjectFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment newProjectFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static newProjectFragment newInstance(String param1, String param2) {
        newProjectFragment fragment = new newProjectFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_project, container, false);
        ctgr=(Spinner)view.findViewById(R.id.spinner_cat);
        projectGoal=(EditText)view.findViewById(R.id.editTextGoal);
        projectName=(EditText)view.findViewById(R.id.editTextTextProjectName);
        projectDscr=(EditText)view.findViewById(R.id.editTextDscr);
        String[] categorys = {"cat 1","cat 2", "cat 3", "Otro"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item,categorys);
        ctgr.setAdapter(adapter);
        create=(Button)view.findViewById(R.id.Crear);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String Pname = projectName.getText().toString();
                 int Pgoal = Integer.parseInt(projectGoal.getText().toString());
                 String Pdescription = projectDscr.getText().toString();
                 String Pcategory= ctgr.getSelectedItem().toString();
                 Project newProject = new Project(Pname, new User(), Pgoal,Pcategory,Pdescription);
                 Toast.makeText(getContext(),"Proyecto creado",Toast.LENGTH_LONG).show();
                 projectName.setText("");
                 projectGoal.setText("");
                 projectDscr.setText("");
            }
        });
        return view;
    }


}