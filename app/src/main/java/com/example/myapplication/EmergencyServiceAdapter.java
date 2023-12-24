package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import android.text.method.LinkMovementMethod;


public class EmergencyServiceAdapter extends FirebaseRecyclerAdapter<EmergencyService, EmergencyServiceAdapter.myViewHolder1> {

    public EmergencyServiceAdapter(@NonNull FirebaseRecyclerOptions<EmergencyService> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder1 holder, int position, @NonNull EmergencyService model) {
        holder.serviceNameTextView.setText(model.getServiceName());
        holder.serviceTypeTextView.setText(model.getServiceType());
        String contactString = String.valueOf(model.getContactNumber());
        holder.contactNumberTextView.setText(contactString);
        holder.contactNumberTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initiate a call when the TextView is clicked
                String phoneNumber = "tel:" + contactString;
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber));
                view.getContext().startActivity(dialIntent);
            }
        });
   /*
        holder.contactNumberTextView.setAutoLinkMask(Linkify.PHONE_NUMBERS);
        holder.contactNumberTextView.setMovementMethod(LinkMovementMethod.getInstance());
    */
    }

    @NonNull
    @Override
    public myViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_emergency_service, parent, false);
        return new myViewHolder1(view);
    }

    class myViewHolder1 extends RecyclerView.ViewHolder {
        TextView serviceNameTextView;
        TextView serviceTypeTextView;
         TextView contactNumberTextView;

        public myViewHolder1(@NonNull View itemView) {
            super(itemView);
            serviceNameTextView = (TextView) itemView.findViewById(R.id.serviceNameTextView);
            serviceTypeTextView = (TextView) itemView.findViewById(R.id.serviceTypeTextView);
            contactNumberTextView =(TextView) itemView.findViewById(R.id.contactNumberTextView);
        }
    }
}
