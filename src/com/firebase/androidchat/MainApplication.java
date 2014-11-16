package com.firebase.androidchat;

import android.app.ListActivity;

import com.parse.*;
import android.app.Application;
import android.util.Log;
public class MainApplication extends Application {
	@SuppressWarnings("deprecation")
	public void onCreate()
	{
		Parse.initialize(this, "y4nN85uyrEW3BvTKJTCquU7S9zVl4Cfut2zJ1oMU", "4rX69A4sejqgFCASwSkChTwdYpHqvz7oRVcLsIkq");
		  // Also in this method, specify a default Activity to handle push notifications
		  PushService.setDefaultPushCallback(this, MainActivity.class);
		  ParseInstallation.getCurrentInstallation().saveInBackground();
		 // ParseInstallation installation = ParseInstallation.getCurrentInstallation();
		//  installation.put("user",ParseUser.getCurrentUser());
		//  installation.saveInBackground();
		  ParsePush.subscribeInBackground("Mafia", new SaveCallback() {
			  @Override
			  public void done(ParseException e) {
			    if (e == null) {
			      Log.d("com.parse.push", "successfully subscribed to the mafia channel.");
			    } else {
			      Log.e("com.parse.push", "failed to subscribe for push", e);
			    }
			  }
			});
	}
}
