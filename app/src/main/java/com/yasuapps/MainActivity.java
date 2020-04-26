package com.yasuapps;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.webkit.*;
import com.google.firebase.database.*;

public class MainActivity extends AppCompatActivity {
       private WebView webview;
	   private Toolbar toolbar;
	//private TextView texturl;
	private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
	private DatabaseReference reference=firebaseDatabase.getReference();
	private DatabaseReference childReference=reference.child("weburl");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
webview=findViewById(R.id.web);
	//texturl=findViewById(R.id.txtweb);
   webview.getSettings().setJavaScriptEnabled(true);
   webview.setWebViewClient(new WebViewClient());
}
	@Override
	protected void onStart()
	{
		// TODO: Implement this method
		super.onStart();
		childReference.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot){
				String weblink=dataSnapshot.getValue(String.class);
				toolbar.setTitle(weblink);
				webview.loadUrl(weblink);
				}
				public void onCancelled(DatabaseError databaseError) {
				
				}
				 }
				 );
    
    }
}
