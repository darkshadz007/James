package com.example.studentinformation;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends Activity implements OnClickListener, OnItemSelectedListener {
	EditText txtIdno,txtLastname,txtFirstname;
	Spinner cboCourse;
	RadioGroup grpGender;
	Button btnSave,btnCancel;
	private String selectedcourse;
	
	AlertDialog.Builder builder;
	private String sex;
	private String idno;
	private String lastname;
	private String firstname;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.txtIdno=(EditText) this.findViewById(R.id.idno);
        this.txtLastname=(EditText) this.findViewById(R.id.lastname);
        this.txtFirstname=(EditText) this.findViewById(R.id.firstname);
        this.cboCourse=(Spinner) this.findViewById(R.id.course);
        this.grpGender=(RadioGroup) this.findViewById(R.id.radioGroup1);
        this.btnSave=(Button) this.findViewById(R.id.save);
        this.btnCancel=(Button) this.findViewById(R.id.cancel);
        
        //event listener
        this.btnSave.setOnClickListener(this);
        this.btnCancel.setOnClickListener(this);
        
        this.cboCourse.setOnItemSelectedListener(this);
        
    }


	@Override
	public void onClick(View arg0) {
		int id=arg0.getId();
		switch(id){
		case R.id.save:
			builder=new AlertDialog.Builder(this);
			builder.setTitle("Student Information");
			builder.setNeutralButton("Okey", null);
			//get selected gender
			int genderButton=this.grpGender.getCheckedRadioButtonId();
			RadioButton gender=(RadioButton) this.findViewById(genderButton);
			sex=gender.getText().toString();
			
			
			//retrieve the typed data from the textfields
			idno=this.txtIdno.getText().toString();
			lastname=this.txtLastname.getText().toString();
			firstname=this.txtFirstname.getText().toString();
			
			String student="IDNO"+idno+"\nName:"+lastname+","+firstname+"\nCOURSE:"+selectedcourse+"\nGender:"+sex;
			
			builder.setMessage(student);
			
			AlertDialog dialog=builder.create();
			dialog.show();
			
			
		case R.id.cancel:
			this.txtIdno.setText("");
			this.txtLastname.setText("");
			this.txtFirstname.setText("");
			this.cboCourse.setSelection(0);
			this.grpGender.clearCheck();
			//set cursor position
			this.txtIdno.requestFocus();
				
		
		}
		
	}


	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		
		selectedcourse=this.cboCourse.getItemAtPosition(arg2).toString();
		
	}


	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
      
}
