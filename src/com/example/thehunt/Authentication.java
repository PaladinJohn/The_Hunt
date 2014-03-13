import android.content.Intent;
import android.net.Uri;

import com.temboo.Library.Facebook.OAuth.FinalizeOAuth;
import com.temboo.Library.Facebook.OAuth.FinalizeOAuth.FinalizeOAuthInputSet;
import com.temboo.Library.Facebook.OAuth.FinalizeOAuth.FinalizeOAuthResultSet;
import com.temboo.Library.Facebook.OAuth.InitializeOAuth;
import com.temboo.Library.Facebook.OAuth.InitializeOAuth.InitializeOAuthInputSet;
import com.temboo.Library.Facebook.OAuth.InitializeOAuth.InitializeOAuthResultSet;
import com.temboo.Library.Google.OAuth.*;
import com.temboo.Library.Google.OAuth.InitializeOAuth.*;
import com.temboo.Library.Google.OAuth.FinalizeOAuth.*;
import com.temboo.core.TembooException;
import com.temboo.core.TembooSession;
import com.cloudmine.api.CMApiCredentials;

// Johanna Oberto
// Android Project
// Authentication for 
// Google Maps API
// CloudMine
// Facebook

public class Authentication {

	static String appID = "08ad4b9acfb641a2a0bc0b9a971b1ea3";
	static String username = "jroberto";
	static String tappKeyName = "DropboxMover";
	
	static String fbKey = "1377799809162334";
	static String fbSecret = "8455d61efb31636ae5a256ab318236aa";
	
	static String CloudID = "bc917fe6ee7942d78e421e2ab6dcfb46";
	static String CloudKey = "6701f1a00ea8471eaa315f3535c107d1";
	
	//static String GoogleID = "866379528400-h6lkru6374jipeql9mtmh0iiebk8rj31.apps.googleusercontent.com";
	//static String GoogleScope = "https://www.googleapis.com/auth/maps";
	
	
	// CLOUDMINE
	public static void CMAuth()
	{
		CMApiCredentials.initialize(CloudID, CloudKey, getApplicationContext());
	}
	
	// FACEBOOK
	public static String FacebookAuth(TembooSession session, String appID, String username, String tappKeyName, String facebookappKey, String facebookappSecret)
	{	
		String fbAccessToken = "";
		try {
			
			InitializeOAuth initializeOAuthChoreo = new InitializeOAuth(session);
			InitializeOAuthInputSet initializeOAuthInputs = initializeOAuthChoreo.newInputSet();
			//facebook app key:
			initializeOAuthInputs.set_AppID(facebookappKey);
			
			InitializeOAuthResultSet initializeOAuthResults = initializeOAuthChoreo.execute(initializeOAuthInputs);
			
			String authUrl = initializeOAuthResults.get_AuthorizationURL();
			String fcallback = initializeOAuthResults.get_CallbackID();
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(authUrl));
			startActivity(browserIntent);
			
			FinalizeOAuth finalizeOAuthChoreo = new FinalizeOAuth(session);
			FinalizeOAuthInputSet finalizeOAuthInputs = finalizeOAuthChoreo.newInputSet();
			finalizeOAuthInputs.set_CallbackID(fcallback);
			finalizeOAuthInputs.set_AppSecret(facebookappSecret);
			finalizeOAuthInputs.set_AppID(facebookappKey);
			FinalizeOAuthResultSet finalizeOAuthResults = finalizeOAuthChoreo.execute(finalizeOAuthInputs);
			fbAccessToken = finalizeOAuthResults.get_AccessToken();
			System.out.println(fbAccessToken);
			
		} catch (TembooException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fbAccessToken;
	}
	
	public static void main(String[] args)
	{
		TembooSession session;
		try {
			session = new TembooSession(username, tappKeyName, appID);
			CMAuth();
		} catch (TembooException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}