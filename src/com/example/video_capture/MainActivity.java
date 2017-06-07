package com.example.video_capture;



import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

public class MainActivity extends Activity implements OnClickListener{
	VideoView vv;
	Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btn=(Button)findViewById(R.id.button1);
        vv=(VideoView)findViewById(R.id.videoView1);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
    	// TODO Auto-generated method stub
    	Intent i=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
    	startActivityForResult(i, 0);    	
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	// TODO Auto-generated method stub
    	super.onActivityResult(requestCode, resultCode, data);
    	if(requestCode==0 && resultCode==RESULT_OK){
    		Uri u=data.getData();
    		vv.setVideoURI(u);
    		vv.start();
    	}
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
