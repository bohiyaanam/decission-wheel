package com.example.customedrawable;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    float values[]={1,1,1,1,1,1,1};
    Button button1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView1=(ImageView)findViewById(R.id.imageView1);
        button1=(Button)findViewById(R.id.button1);
        values=calculateData(values);
        imageView1.setImageDrawable(new MyDrawable(getApplicationContext(),values));
        TextView textView1=(TextView)findViewById(R.id.textView1);
        textView1.setText("<--");
        button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub 
				ImageView imageView1=(ImageView)(v.getRootView()).findViewById(R.id.imageView1);
				imageView1.setImageDrawable(new MyDrawable(getApplicationContext(),values));
				//Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotator);
				Random r = new Random();
				final int i1 = r.nextInt(360);
				 Animation rotate = new RotateAnimation(0, 7200+i1,
		                  Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,0.5f);
				 rotate.setRepeatCount(0);
				 rotate.setDuration(5000);
				rotate.setFillAfter(true);
				
				imageView1.startAnimation(rotate);
				
				rotate.setAnimationListener(new AnimationListener() {
					
					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
						Log.e("Animation has started","animation has started");
						button1.setClickable(false);
					}
					
					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub
						Log.e("Animation has repeated","animation has repeated");
						
					}
					
					@Override
					public void onAnimationEnd(Animation animation) {
						// TODO Auto-generated method stub
						Log.e("Animation has finished ","angle : "+i1);
						for(int i=1;i<values.length+1;i++)
						{
							if(i1<(values[0]*(i)))
							{
								Toast.makeText(getApplicationContext(), "selected is : "+(i-values.length), Toast.LENGTH_LONG).show();;
								break;
							}
						}
						button1.setClickable(true);
					}
				});
				
			}
		});
    }
    

    private float[] calculateData(float[] data) {
        // TODO Auto-generated method stub
        float total=0;
        for(int i=0;i<data.length;i++)
        {
            total+=data[i];
        }
        for(int i=0;i<data.length;i++)
        {
        data[i]=360*(data[i]/total);            
        }
        return data;

    }
}
