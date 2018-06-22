package com.example.designmodal.edevnews.Activities;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;


import com.example.designmodal.edevnews.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FcmMessagingService extends FirebaseMessagingService {

    public  void onMessageReceived(RemoteMessage remoteMessage){
        String title= remoteMessage.getNotification().getTitle();
        String message= remoteMessage.getNotification().getBody();

        Intent intent =new Intent (this, PushNotifactionActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent= PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder notifiactionBuilder= new NotificationCompat.Builder(this);
        notifiactionBuilder.setContentTitle(title);
        notifiactionBuilder.setContentText(message);
        notifiactionBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notifiactionBuilder.setAutoCancel(true);
        notifiactionBuilder.setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notifiactionBuilder.build());


        super.onMessageReceived(remoteMessage);

    }

}
