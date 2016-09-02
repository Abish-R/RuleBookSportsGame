package abish.rulebooksportsgame;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import abish.rulebooksportsgame.R;

public class AAAAA extends AppCompatActivity implements OnClickListener {
	TextView t1,t2,t3,t4;
	Button bcross,b2,b3,b4,b5,b6,b7,b8,b9,bplus,bminus,bdivide,bmultiply;
	String operationValues = "";
	double outputValue=0;
	int outputIntValue=0;
	boolean fromOperator=false;
	private boolean wonLostStatus;
	private final Handler mHandler = new Handler(Looper.getMainLooper());
	Animation shake1;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aaaaa_activity);
        
        t1= (TextView)findViewById(R.id.t1);
        t2= (TextView)findViewById(R.id.t2);
        t3= (TextView)findViewById(R.id.t3);
        t4= (TextView)findViewById(R.id.t4);
        b2= (Button)findViewById(R.id.b2);
        b3= (Button)findViewById(R.id.b3);
        b4= (Button)findViewById(R.id.b4);
        b5= (Button)findViewById(R.id.b5);
        b6= (Button)findViewById(R.id.b6);
        b7= (Button)findViewById(R.id.b7);
        b8= (Button)findViewById(R.id.b8);
        b9= (Button)findViewById(R.id.b9);
        bcross= (Button)findViewById(R.id.bcross);
        bplus= (Button)findViewById(R.id.bplus);
        bminus= (Button)findViewById(R.id.bminus);
        bdivide= (Button)findViewById(R.id.bdivide);
        bmultiply= (Button)findViewById(R.id.bmultiply);
        
        bcross.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        bplus.setOnClickListener(this);
        bminus.setOnClickListener(this);
        bdivide.setOnClickListener(this);
        bmultiply.setOnClickListener(this);
        
        outputValue= Integer.parseInt(t1.getText().toString());
        outputIntValue= Integer.parseInt(t1.getText().toString());
    }

	@Override
	public void onClick(View v) {
		if(wonLostStatus)
			Toast.makeText(getApplicationContext(),"Game Over!!", Toast.LENGTH_SHORT).show();
		else if(v==b2){
			doOperation(2);
		}else if(v==b3){
			doOperation(3);
		}else if(v==b4){
			doOperation(4);
		}else if(v==b5){
			doOperation(5);
		}else if(v==b6){
			doOperation(6);
		}else if(v==b7){
			doOperation(7);
		}else if(v==b8){
			doOperation(8);
		}else if(v==b9){
			doOperation(9);
		}else if(v==bcross){
			setOperator("x");
		}else if(v==bplus){
			setOperator("+");
		}else if(v==bminus){
			setOperator("-");
		}else if(v==bdivide){
			setOperator("/");
		}else if(v==bmultiply){
			setOperator("*");
		}
		
	}

	private void setOperator(String val) {
		operationValues=val;
		if(operationValues.equals("x"))
			Toast.makeText(getApplicationContext(),"Don't worry press operator!!", Toast.LENGTH_SHORT).show();
		else{
			t2.setText(operationValues);
			helpAnimation(true);
		}
	}

	private void doOperation(int val) {
		
		if(!checkOperatorEmpty())
			Toast.makeText(getApplicationContext(),"Select operator First!!", Toast.LENGTH_SHORT).show();
		else if(operationValues.equals("+"))
			addition(val);
		else if(operationValues.equals("-"))
			subtraction(val);
		else if(operationValues.equals("/"))
			division(val);
		else if(operationValues.equals("*"))
			multiplication(val);
		else if(operationValues.equals("x"))
			Toast.makeText(getApplicationContext(),"Don't worry press operator!!", Toast.LENGTH_SHORT).show();
	}

	private void multiplication(int val) {
		t3.setText(val+"  =");
		int mainValuInt=getMainValueInteger();
		if(mainValuInt>1){
			outputValue *= val;
			outputIntValue *= val;
			setTextInViews();
		}
		else if (mainValuInt==1){
			wonLostStatus=true;
			Toast.makeText(getApplicationContext(),"Oops you lost!!", Toast.LENGTH_SHORT).show();
		}
		else if (mainValuInt==0){
			wonLostStatus=true;
			Toast.makeText(getApplicationContext(),"Hey you won!!", Toast.LENGTH_SHORT).show();
		}
	}

	private int getMainValueInteger() {
		String mainValue = t1.getText().toString();
		//int mainValuInt=0;
		if(mainValue==null || mainValue.length()<1)
			return 0;
		else
			return Integer.parseInt(mainValue);
		
	}

	private void division(int val) {
		t3.setText(val+"  =");
		int mainValuInt=getMainValueInteger();
		if(mainValuInt>1){
			outputValue /= val;
			outputIntValue /= val;
			setTextInViews();
		}
		else if (mainValuInt==1){
			wonLostStatus=true;
			Toast.makeText(getApplicationContext(),"Oops you lost!!", Toast.LENGTH_SHORT).show();
		}
		else if (mainValuInt==0){
			wonLostStatus=true;
			Toast.makeText(getApplicationContext(),"Hey you won!!", Toast.LENGTH_SHORT).show();
		}
		
	}

	private void subtraction(int val) {
		t3.setText(val+"  =");
		int mainValuInt=getMainValueInteger();
		if(mainValuInt>1){
			outputValue -= val;
			outputIntValue -= val;
			setTextInViews();
		}
		else if (mainValuInt==1){
			wonLostStatus=true;
			Toast.makeText(getApplicationContext(),"Oops you lost!!", Toast.LENGTH_SHORT).show();
		}
		else if (mainValuInt==0){
			wonLostStatus=true;
			Toast.makeText(getApplicationContext(),"Hey you won!!", Toast.LENGTH_SHORT).show();
		}
		
	}

	private void addition(int val) {
		t3.setText(val+"  =");
		int mainValuInt=getMainValueInteger();
		if(mainValuInt>1){
			outputValue += val;
			outputIntValue += val;
			setTextInViews();
		}
		else if (mainValuInt==1){
			wonLostStatus=true;
			Toast.makeText(getApplicationContext(),"Oops you lost!!", Toast.LENGTH_SHORT).show();
		}
		else if (mainValuInt==0){
			wonLostStatus=true;
			Toast.makeText(getApplicationContext(),"Hey you won!!", Toast.LENGTH_SHORT).show();
		}
		
	}
	
	

	private void setTextInViews() {
		operationValues="";
		if(outputValue > outputIntValue){
			outputValue = Math.round(outputValue * 10)/10;
			t4.setText(outputValue+"");
			wonLostStatus=true;
			Toast.makeText(getApplicationContext(),"You lost. Decimal Output found!!", Toast.LENGTH_SHORT).show();
		}else if(outputValue==0){
			t4.setText(outputIntValue+"");
			t1.setText(outputIntValue+"");
			wonLostStatus=true;
			Toast.makeText(getApplicationContext(),"Hey Congrats, You Won!!", Toast.LENGTH_SHORT).show();
		}else{
			t4.setText(outputIntValue+"");
			t1.setText(outputIntValue+"");
			helpAnimation(false);
		}
		//t2.setText("");
		//t3.setText("");
	}

	private boolean checkOperatorEmpty() {
		if(operationValues=="" || operationValues==null)
			return false;
		else
			return true;
	}
	
	private void helpAnimation(boolean boo){
		fromOperator=boo;
		mHandler.post(SCROLLING_RUNNABLE);
		shake1 = AnimationUtils.loadAnimation(this, R.anim.shake);
	}
	
	private final Runnable SCROLLING_RUNNABLE = new Runnable() {
        @Override
        public void run() {
        	
        	ArrayList<Button> btnList = new ArrayList<Button>();
        	if(fromOperator){
	        	btnList.add(b2);btnList.add(b3);btnList.add(b4);btnList.add(b5);btnList.add(b6);
	        	btnList.add(b7);btnList.add(b8);btnList.add(b9);
        	}else{
        		btnList.add(bplus);btnList.add(bminus);btnList.add(bdivide);btnList.add(bmultiply);
        	}
        	
        	
            final int duration = 1500;
            //final int pixelsToMove = 10;
            for(int i=0;i<btnList.size();i++){
            	
            	btnList.get(i).startAnimation(shake1);
            	//btnList.get(i).setBackgroundColor(getResources().getColor(R.color.mycolor2));
	            //record_recycler_controller.smoothScrollBy(pixelsToMove, 0);
	            mHandler.postDelayed(this, duration);
	            //btnList.get(i).setBackgroundColor(getResources().getColor(R.color.mycolor1));
            }
            mHandler.removeCallbacks(SCROLLING_RUNNABLE);
        }
    };
}
