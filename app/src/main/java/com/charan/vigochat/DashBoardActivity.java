package com.charan.vigochat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.charan.vigochat.databinding.ActivityDashBoardBinding;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class DashBoardActivity extends AppCompatActivity  {
    ActivityDashBoardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDashBoardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        URL serverUrl;
        try {
            serverUrl=new URL("https://meet.jit.si");

            JitsiMeetConferenceOptions defaultoptions =
                    new JitsiMeetConferenceOptions.Builder()
                            .setServerURL(serverUrl)
                            .setWelcomePageEnabled(false).build();
            JitsiMeet.setDefaultConferenceOptions(defaultoptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        binding.joinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JitsiMeetConferenceOptions options=
                        new JitsiMeetConferenceOptions.Builder()
                                .setRoom(binding.secretcodebox.getText().toString())
                                .setWelcomePageEnabled(false)
                                .build();

                JitsiMeetActivity.launch(DashBoardActivity.this,options);
            }
        });

    }
}