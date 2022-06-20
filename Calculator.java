package CalcCode;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

//Version-1



public class Calculator implements ActionListener {
	
	boolean flg_CleanState=true; // Used to identify whether it is the first digit in display , to replace the initial '0'
	boolean flg_DotinDisplay=false;
	float F_Value=0f;
	float S_Value=0f;
	boolean ActionPerformed=false;
	
	float Result;
	int OperationIdentifier=0;// 1-> Addition 2->Multiplication 3->Division 4-> Subtraction 5-> Equal
	JFrame jf;
	JLabel displayLabel;
	JButton Sevenbtn;
	JButton Eightbtn;
	JButton Ninebtn;
	JButton Fourbtn;
	JButton Fivebtn;
	JButton Sixbtn;
	JButton Onebtn;
	JButton Twobtn;
	JButton Threebtn;
	JButton Dotbtn;
	JButton Zerobtn;
	JButton Eqlbtn;
	JButton Divbtn;
	JButton Multbtn;
	JButton Minusbtn;
	JButton Plsbtn;
	JButton Clrbtn;
	
	public Calculator() {
		jf=new JFrame("Calculator");
		jf.setLayout(null);
		jf.setSize(600, 600);
		jf.setLocation(300,150);
		
		displayLabel= new JLabel("0");
		displayLabel.setBounds(30,50, 540, 40);
		displayLabel.setBackground(Color.gray);
		displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		displayLabel.setForeground(Color.white);
		displayLabel.setFont(displayLabel.getFont().deriveFont(40.0f));
		displayLabel.setOpaque(true);
		jf.add(displayLabel);

		//Buttons
		Sevenbtn=new JButton("7");
		Sevenbtn.setBounds(30,130,80,80);
		Sevenbtn.setFont( new Font("Arial",Font.PLAIN,40));
		Sevenbtn.addActionListener(this);
		jf.add(Sevenbtn);
		
		Eightbtn=new JButton("8");
		Eightbtn.setBounds(130,130,80,80);
		Eightbtn.setFont( new Font("Arial",Font.PLAIN,40));
		Eightbtn.addActionListener(this);
		jf.add(Eightbtn);
		
		Ninebtn=new JButton("9");
		Ninebtn.setBounds(230,130,80,80);
		Ninebtn.setFont( new Font("Arial",Font.PLAIN,40));
		Ninebtn.addActionListener(this);
		jf.add(Ninebtn);
		
		Fourbtn=new JButton("4");
		Fourbtn.setBounds(30,230,80,80);
		Fourbtn.setFont( new Font("Arial",Font.PLAIN,40));
		Fourbtn.addActionListener(this);
		jf.add(Fourbtn);
		
		Fivebtn=new JButton("5");
		Fivebtn.setBounds(130,230,80,80);
		Fivebtn.setFont( new Font("Arial",Font.PLAIN,40));
		Fivebtn.addActionListener(this);
		jf.add(Fivebtn);
		
		Sixbtn=new JButton("6");
		Sixbtn.setBounds(230,230,80,80);
		Sixbtn.setFont( new Font("Arial",Font.PLAIN,40));
		Sixbtn.addActionListener(this);
		jf.add(Sixbtn);
		
		Onebtn=new JButton("1");
		Onebtn.setBounds(30,330,80,80);
		Onebtn.setFont( new Font("Arial",Font.PLAIN,40));
		Onebtn.addActionListener(this);
		jf.add(Onebtn);
		
		Twobtn=new JButton("2");
		Twobtn.setBounds(130,330,80,80);
		Twobtn.setFont( new Font("Arial",Font.PLAIN,40));
		Twobtn.addActionListener(this);
		jf.add(Twobtn);
		
		Threebtn=new JButton("3");
		Threebtn.setBounds(230,330,80,80);
		Threebtn.setFont( new Font("Arial",Font.PLAIN,40));
		Threebtn.addActionListener(this);
		jf.add(Threebtn);
		
		
		Dotbtn=new JButton(".");
		Dotbtn.setBounds(30,430,80,80);
		Dotbtn.setFont( new Font("Arial",Font.PLAIN,40));
		Dotbtn.addActionListener(this);
		jf.add(Dotbtn);
		
		Zerobtn=new JButton("0");
		Zerobtn.setBounds(130,430,80,80);
		Zerobtn.setFont( new Font("Arial",Font.PLAIN,40));
		Zerobtn.addActionListener(this);
		jf.add(Zerobtn);
		
		Eqlbtn=new JButton("=");
		Eqlbtn.setBounds(230,430,80,80);
		Eqlbtn.setFont( new Font("Arial",Font.PLAIN,40));
		Eqlbtn.addActionListener(this);
		jf.add(Eqlbtn);
		
		Divbtn=new JButton("/");
		Divbtn.setBounds(330,130,80,80);
		Divbtn.setFont( new Font("Arial",Font.PLAIN,40));
		Divbtn.addActionListener(this); 
		jf.add(Divbtn);
		
		Multbtn=new JButton("x");
		Multbtn.setBounds(330,230,80,80);
		Multbtn.setFont( new Font("Arial",Font.PLAIN,40));
		Multbtn.addActionListener(this);
		jf.add(Multbtn);
		
		Minusbtn=new JButton("-");
		Minusbtn.setBounds(330,330,80,80);
		Minusbtn.setFont( new Font("Arial",Font.PLAIN,40));
		Minusbtn.addActionListener(this);
		jf.add(Minusbtn);
		
		Plsbtn=new JButton("+");
		Plsbtn.setBounds(330,430,80,80);
		Plsbtn.setFont( new Font("Arial",Font.PLAIN,40));
		Plsbtn.addActionListener(this);
		jf.add(Plsbtn);
		
		Clrbtn=new JButton("C");
		Clrbtn.setBounds(430,430,80,80);
		Clrbtn.setFont( new Font("Arial",Font.PLAIN,40));
		Clrbtn.addActionListener(this);
		jf.add(Clrbtn);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton jb= new JButton();
	}

	
	
	
	public static void main(String[] args) {
		new Calculator();
	}




	@Override // Digit Buttons
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== Sevenbtn) {
			if(flg_CleanState) {
				displayLabel.setText("7");	
				flg_CleanState=false;
			}else {
				displayLabel.setText(displayLabel.getText()+"7");
			}

		}else if(e.getSource()== Eightbtn) {
			if(flg_CleanState) {
				displayLabel.setText("8");	
				flg_CleanState=false;
			}else {
				displayLabel.setText(displayLabel.getText()+"8");
			}

		}else if(e.getSource()== Ninebtn) {
			if(flg_CleanState) {
				displayLabel.setText("9");	
				flg_CleanState=false;
			}else {
				displayLabel.setText(displayLabel.getText()+"9");
			}

		}else if(e.getSource()== Fourbtn) {
			if(flg_CleanState) {
				displayLabel.setText("4");	
				flg_CleanState=false;
			}else {
				displayLabel.setText(displayLabel.getText()+"4");
			}

		}else if(e.getSource()== Fivebtn) {
			if(flg_CleanState) {
				displayLabel.setText("5");	
				flg_CleanState=false;
			}else {
				displayLabel.setText(displayLabel.getText()+"5");
			}

		}else if(e.getSource()== Sixbtn) {
			if(flg_CleanState) {
				displayLabel.setText("6");	
				flg_CleanState=false;
			}else {
				displayLabel.setText(displayLabel.getText()+"6");
			}

		}else if(e.getSource()== Onebtn) {
			if(flg_CleanState) {
				displayLabel.setText("1");	
				flg_CleanState=false;
			}else {
				displayLabel.setText(displayLabel.getText()+"1");
			}

		}else if(e.getSource()== Twobtn) {
			if(flg_CleanState) {
				displayLabel.setText("2");	
				flg_CleanState=false;
			}else {
				displayLabel.setText(displayLabel.getText()+"2");
			}

		}else if(e.getSource()== Threebtn) {
			if(flg_CleanState) {
				displayLabel.setText("3");	
				flg_CleanState=false;
			}else {
				displayLabel.setText(displayLabel.getText()+"3");
			}

		}else if(e.getSource()== Zerobtn) {
			if(flg_CleanState) {
				displayLabel.setText("0");	
				
			}else {
				if(flg_DotinDisplay || flg_CleanState==false)
				displayLabel.setText(displayLabel.getText()+"0");
			}

		}else if(e.getSource()== Dotbtn) {
			if(flg_CleanState) {
				displayLabel.setText("0.");	
				flg_CleanState=false;
				flg_DotinDisplay=true;
			}else {
				if(!flg_DotinDisplay) {
				displayLabel.setText(displayLabel.getText()+".");
				flg_DotinDisplay=true;
				}
			}

		}else if(e.getSource()== Clrbtn) {

				displayLabel.setText("0");
				flg_CleanState=true;
				flg_DotinDisplay=false;
				Result=0f;
				OperationIdentifier=0;
				F_Value=0;
				S_Value=0;
				
				
				
//Operator Buttons				
		}else if(e.getSource()== Plsbtn) { //Addition
			
			if(OperationIdentifier!=1 && F_Value!=0 && !flg_CleanState)
				  Func_FinalResultMaker();
			 
				OperationIdentifier=1;
				if(!flg_CleanState)
				Func_FinalResultMaker();

	  }else if(e.getSource()== Multbtn) { //Multiplication
		  if(OperationIdentifier!=2 && F_Value!=0 && !flg_CleanState)
			  Func_FinalResultMaker();
		  
			OperationIdentifier=2;
			if(!flg_CleanState)
				Func_FinalResultMaker();
	  }else if(e.getSource()== Divbtn) { //Division

		  if(OperationIdentifier!=3 && F_Value!=0 && !flg_CleanState)
			  Func_FinalResultMaker();
		  
			OperationIdentifier=3;
			if(!flg_CleanState)
				Func_FinalResultMaker();

	  }else if(e.getSource()== Minusbtn) { //Subtraction

		  if(OperationIdentifier!=4 && F_Value!=0 && !flg_CleanState)
			  Func_FinalResultMaker();
			OperationIdentifier=4;
			if(!flg_CleanState)
				Func_FinalResultMaker();
	  }else if(e.getSource()== Eqlbtn) { //Equal
		  	Func_FinalResultMaker();
		  	OperationIdentifier=5;
	  }
		
}
	
	
	
	//Main Calculation function
	void Func_FinalResultMaker() {
		switch(OperationIdentifier) {
	  	case 1://Add
	  		if (Result != 0)
	  			F_Value = Result;
	  		
	  		if (F_Value ==0)
	  			F_Value = Float.parseFloat(displayLabel.getText());
	  		else
	  			S_Value = Float.parseFloat(displayLabel.getText());
	  			
	  		if (S_Value!=0) {
	  			ActionPerformed=true;
	  			Result=F_Value+S_Value;
	  			displayLabel.setText("" + fmt(Result));
	  		}
	  		else {
	  			ActionPerformed=false;
	  			displayLabel.setText("" + fmt(F_Value));
	  		}

	  		S_Value=0f;
	  		break;
	  	case 2://Multiplication
	  		if (Result != 0)
	  			F_Value = Result;
	  		
	  		if (F_Value ==0)
	  			F_Value = Float.parseFloat(displayLabel.getText());
	  		else
	  			S_Value = Float.parseFloat(displayLabel.getText());
	  		

	  		if(S_Value !=0.0f) // To avoid Multiplication with 0 at initial stage
	  			Result=F_Value * S_Value;
	  		else
	  			Result=F_Value;

	  		if (S_Value!=0) {
	  			ActionPerformed=true;
	  			Result=F_Value*S_Value;
	  			displayLabel.setText("" + fmt(Result));
	  		}
	  		else {
	  			ActionPerformed=false;
	  			displayLabel.setText("" + fmt(F_Value));
	  		}
	  		S_Value=0;
	  		break;
	  		
	  	case 3://Div
	  		if (Result != 0)
	  			F_Value = Result;
	  		
	  		if (F_Value ==0)
	  			F_Value = Float.parseFloat(displayLabel.getText());
	  		else
	  			S_Value = Float.parseFloat(displayLabel.getText());
	  		

  		
	  		
	  		if (F_Value!=0 && S_Value!=0) {
	  			Result=F_Value/S_Value;
	  			displayLabel.setText("" + fmt(Result));

	  	  		if (S_Value!=0) {
	  	  			ActionPerformed=true;
	  	  		}
	  	  		else
	  	  			ActionPerformed=false;

	  		}
	  		S_Value=0f;
	  		break;
	  		
	  	case 4://Subtraction
	  		if (Result != 0)
	  			F_Value = Result;
	  		
	  		if (F_Value ==0)
	  			F_Value = Float.parseFloat(displayLabel.getText());
	  		else
	  			S_Value = Float.parseFloat(displayLabel.getText());

	  		if (S_Value!=0) {
	  			ActionPerformed=true;
	  			Result=F_Value-S_Value;
	  			displayLabel.setText("" + fmt(Result));
	  		}
	  		else {
	  			ActionPerformed=false;
	  			displayLabel.setText("" + fmt(F_Value));
	  		}

	  		S_Value=0f;
	  		break;
	 	}
		flg_CleanState=true;
		flg_DotinDisplay=false;
	
	  	
	}
	
	
	//Function for Formatting , unwanted decimal Zeros if required (for eg, 5+2 = will be 5.0, this modifies as 5 )
	public static String fmt(double d)
	{
	    if(d == (long) d)
	        return String.format("%d",(long)d);
	    else
	        return String.format("%s",d);
	}


	}

