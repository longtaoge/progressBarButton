package com.example.buttondemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	int i=0;
	ProgressBar progressBar=null;
	Button downLoadBtn=null;
	Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 1:
				i+=5;
				progressBar.setProgress(i);
				if(i!=100){
					handler.sendEmptyMessageDelayed(new Message().what=1,500);
					downLoadBtn.setText(i+"%");
				}else if(i==100){
					downLoadBtn.setText("œ¬‘ÿÕÍ≥…");
				}
				break;

			default:
				break;
			}
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView tx = (TextView) findViewById(R.id.text);
		  progressBar=(ProgressBar) findViewById(R.id.progressBar);
		  downLoadBtn=(Button) findViewById(R.id.downLoadBtn);
		  downLoadBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 i= 0;
				handler.sendEmptyMessage(new Message().what=1);
			}
		});
	}

}
