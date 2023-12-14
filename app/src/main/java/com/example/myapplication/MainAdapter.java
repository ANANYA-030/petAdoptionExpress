package com.example.myapplication;


import static com.google.android.gms.base.R.drawable;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;


   public class MainAdapter extends FirebaseRecyclerAdapter<Information,MainAdapter.myViewHolder>{

       /**
        * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
        * {@link FirebaseRecyclerOptions} for configuration options.
        *
        * @param options
        */
       public MainAdapter(@NonNull FirebaseRecyclerOptions<Information> options) {
           super(options);
       }

       @Override
       protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull Information model) {
           holder.name.setText(model.getBreed());
           Glide.with(holder.img.getContext())
                   .load(model.getImage())
                   .placeholder(drawable.common_google_signin_btn_icon_dark)
                   .circleCrop()
                   .error(drawable.common_google_signin_btn_icon_dark_normal)
                   .into(holder.img);

           holder.btn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   String info = model.getInfo();

                   String age = model.getAge();
                   String breed = model.getBreed();



                   Intent intent = new Intent(view.getContext(), MainActivity3.class);
                   intent.putExtra("INFO_KEY",info);
                   intent.putExtra("AGE_KEY",age);
                   intent.putExtra("BREED_KEY",breed);


                   view.getContext().startActivity(intent);



               }
           });

       }

       @NonNull
       @Override
       public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item1,parent,false);
           return new myViewHolder(view);
       }


    class myViewHolder extends RecyclerView.ViewHolder {

        CircleImageView img;
        TextView name;
        Button btn;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img=(CircleImageView) itemView.findViewById(R.id.dog1);
            name=(TextView) itemView.findViewById(R.id.nametext);
            btn = (Button) itemView.findViewById(R.id.button1);
        }
    }
}
