package com.example.customedrawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;

/**
 * Created by Smile on 23-02-2015.
 */
public class MyDrawable extends Drawable {


    private Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private float[] value_degree;//={72.0f,144.0f,216.0f,288.0f,360};
    private int[] COLORS={Color.BLUE,Color.GREEN,Color.GRAY,Color.CYAN,Color.RED};
    RectF rectf = new RectF (0, 0, 150, 150);
    float temp=0;

    public MyDrawable(Context context, float[] values)
    {
        value_degree=new float[values.length]; 
        for(int i=0;i<values.length;i++)
        {
            value_degree[i]=values[i];
        }
    }

    @Override
    public void draw(Canvas canvas) {
      //Log.e("OnDraw is called", "OnDraw is called");
    	int centerX = 150 / 2;
        int centerY = 150 / 2;
        int radius = 150 / 2;
        for (int i = 0; i < value_degree.length; i++) {//values2.length; i++) {
            if (i == 0) {
                paint.setColor(COLORS[(0)]);
                canvas.drawArc(rectf, 0, value_degree[i], true, paint);
                
                canvas.save();
                paint.setColor(Color.BLACK);
                canvas.rotate((value_degree[i] / 2f)+2, 75,75); 
                canvas.drawText("     "+i+"your text here this is my text to display",75,75,paint);//,(float) (85+(radius * Math.cos(medianAngle))),(float)(85+(radius * Math.cos(medianAngle))), paint);
                
                canvas.restore();
                
                
//                paint.setColor(Color.BLACK); // set this to the text color.
//                float medianAngle = (temp + (value_degree[i] / 2f)) * (float)Math.PI / 180f; // this angle will place the text in the center of the arc.
//                canvas.drawText("Hello "+i, (float)(centerX + (radius * Math.cos(medianAngle))), (float)(centerY + (radius * Math.sin(medianAngle))), paint);

            }
            else
            {
                temp +=  value_degree[i - 1];
                paint.setColor(COLORS[(i%COLORS.length)]);
                canvas.drawArc(rectf, temp, value_degree[i], true, paint);
                
                canvas.save();
                paint.setColor(Color.BLACK);
                float medianAngle = (temp + (value_degree[i] / 2f)); // this angle will place the text in the center of the arc.
                canvas.rotate(medianAngle+2, 75,75); 
                canvas.drawText("     "+i+"your text here this is my text to display",75,75,paint);//,(float) (85+(radius * Math.cos(medianAngle))),(float)(85+(radius * Math.cos(medianAngle))), paint);
                
                canvas.restore();
                
//                canvas.save();
//                paint.setColor(Color.BLACK);
//                float medianAngle = (temp + (value_degree[i] / 2f)) * (float)Math.PI / 180f; // this angle will place the text in the center of the arc.
//                canvas.rotate(medianAngle, 85,85); 
//                canvas.drawText("your text here this is my text to display", 85,85, paint);
//                
//                canvas.restore();
                
//                paint.setColor(Color.BLACK); // set this to the text color.
//                float medianAngle = (temp + (value_degree[i] / 2f)) * (float)Math.PI / 180f; // this angle will place the text in the center of the arc.
//                canvas.drawText("Hello "+i, (float)(centerX + (radius * Math.cos(medianAngle))), (float)(centerY + (radius * Math.sin(medianAngle))), paint);

            }
        }
        temp=0.0f;
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter cf) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }
}
