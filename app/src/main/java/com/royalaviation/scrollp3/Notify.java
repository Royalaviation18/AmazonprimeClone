package com.royalaviation.scrollp3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.util.Date;

public class Notify extends AppCompatActivity {

    Button btnNotify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
        getSupportActionBar().hide();

        btnNotify = findViewById(R.id.btnNotify);

        btnNotify.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MovieRec.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_IMMUTABLE);

//                File root = Environment.getExternalStorageDirectory();
//                Bitmap bMap = BitmapFactory.decodeFile(root + "drawable/ic_baseline_notifications_24.xml");

                createNotificationChannel();
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "CHANNEL_ID")
                        .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
                        .setContentTitle("Hey, Come Back! \n")
                        .setContentText("Checkout new Movies")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                        .setColor(R.drawable.bmbackgroundtwo)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.alexanot))
                        //timestamp
                        .setWhen((new Date()).getTime())
                        .setShowWhen(true)
                        .setColorized(true)
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.alexanot)))
                        // Set the intent that will fire when the user taps the notification
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);


                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
//                NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
//                bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.alexanot)).build();


// notificationId is a unique int for each notification that you must define
                notificationManager.notify(1, builder.build());
            }
        });

    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel() {

        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel("CHANNEL_ID", "Rohit", importance);
        channel.setDescription("Click");

        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }
}