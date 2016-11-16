package com.example.pokevirus.graduation_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;

public class Doctors_View extends AppCompatActivity {

    DatabaseReference db;
    FirebaseHelper helper;
    RecyclerView rv;
    MyAdapter adapter;
    private RecyclerView Doctorslist;
    private DatabaseReference mdatabase;
    public com.firebase.client.core.Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_doctors__view);
        Firebase Ref = new Firebase("https://yourdocto.firebaseio.com/").child("categories");

      //  Ref.keepSynced(true);
        //FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        //mdatabase = FirebaseDatabase.getInstance().getReference();
       // mdatabase.keepSynced(true);
        // FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        // helper=new FirebaseHelper(db);

        Doctorslist = (RecyclerView) findViewById(R.id.doctor_list);
        Doctorslist.setHasFixedSize(true);
         Doctorslist.setLayoutManager(new LinearLayoutManager(this));

       FirebaseRecyclerAdapter<doctor_profile,Doctors_view> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<doctor_profile, Doctors_view>(
                 doctor_profile.class,
                 R.layout.row_view,
                 Doctors_view.class,
                 Ref)

         {
            @Override
            protected void populateViewHolder(Doctors_view doctors_view, doctor_profile doctors,final int i) {
                final String Doctor_id=getRef(i).getKey();
                doctors_view.setDoctorName(doctors.getName());

              //  Animation animation = AnimationUtils.loadAnimation(context,i);
               // doctors_view.mView.startAnimation(animation);

                doctors_view.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("postion","postion is "+i);
                        Toast.makeText(Doctors_View.this, Doctor_id, Toast.LENGTH_SHORT).show();
                    }
                });

            }

        };

        Doctorslist.setAdapter(firebaseRecyclerAdapter);

    }


    public void Search(View view) {
        EditText txt_search=(EditText)findViewById(R.id.et_search);
        String search_text=txt_search.getText().toString();
        Firebase Ref = (Firebase) new Firebase("https://yourdocto.firebaseio.com/").child("categories");
        FirebaseRecyclerAdapter<doctor_profile,Doctors_view> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<doctor_profile, Doctors_view>(
                doctor_profile.class,
                R.layout.row_view,
                Doctors_view.class,
                Ref)

        {
            @Override
            protected void populateViewHolder(Doctors_view doctors_view, doctor_profile doctors,final int i) {
                final String Doctor_id=getRef(i).getKey();
                doctors_view.setDoctorName(doctors.getName());


                doctors_view.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("postion","postion is "+i);
                        Toast.makeText(Doctors_View.this, Doctor_id, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
      com.firebase.client.Query queryRef = Ref.orderByChild("categories");

        Doctorslist.setAdapter(firebaseRecyclerAdapter);

    }

    public static class Doctors_view extends RecyclerView.ViewHolder{
        View mView;
        public Doctors_view(View itemView) {
            super(itemView);
            mView=itemView;
        }
        public  void setImage(String image)
        {
            ImageView img=(ImageView)mView.findViewById(R.id.img_doctor);

        }
        public  void setDoctorName(String Name)
        {
            TextView txt_DoctorName=(TextView)mView.findViewById(R.id.txt_docname);
            txt_DoctorName.setText(Name);
        }




    }
}
