package yazlab1;
import static java.lang.System.out;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
public class game_page extends JFrame {

	private JPanel contentPane;
	JButton [][] butarray;


	
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					game_page frame = new game_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	public game_page() {
		
	} */
	


	public game_page(List<List<Integer>> array , List<List<Integer>> gizli_altinlar , List<List<Integer>> normal_altinlar,
			int n , int m , List<Integer> silinecek_yol ) {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1041, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		butarray = new JButton[n][m];
		  for (int i = 0; i < n; i++) {
		        for (int j = 0; j < m; j++) {
		        	
		        	butarray[i][j] = new JButton();
		            getContentPane().add(butarray[i][j]);
		            if((i==0 && j==0) || (i==0 && j==m-1) || (i==n-1 && j==0) || (i==n-1 && j==m-1) ) {
		            	if(i==0 && j==0) {
		            		 butarray[i][j].setBackground(Color.GREEN);
		            	}
		            	if(i==0 && j==m-1) {
		            		 butarray[i][j].setBackground(Color.RED);
		            	}
		            	if(i==n-1 && j==0) {
		            		 butarray[i][j].setBackground(Color.BLUE);
		            	}
		            	if(i==n-1 && j==m-1) {
		            		 butarray[i][j].setBackground(Color.BLACK);
		            	}
		            			      
		            }
		            	
		            else
		            		butarray[i][j].setBackground(Color.WHITE);
		        }
		    }
		 
		
		  
		  for(int y=0; y<normal_altinlar.size();y++) {

		 butarray[normal_altinlar.get(y).get(0)][normal_altinlar.get(y).get(1)].setBackground(Color.lightGray);
		 butarray[normal_altinlar.get(y).get(0)][normal_altinlar.get(y).get(1)].setText(array.get(normal_altinlar.get(y).get(0)).get(normal_altinlar.get(y).get(1)).toString());
				
		
		 
		  }
		  
 
		  
		  if(!gizli_altinlar.isEmpty()) {
			  for(int y=0; y<gizli_altinlar.size();y++) {
				  
				  butarray[gizli_altinlar.get(y).get(0)][gizli_altinlar.get(y).get(1)].setText(array.get(gizli_altinlar.get(y).get(0)).get(gizli_altinlar.get(y).get(1)).toString());
				  butarray[gizli_altinlar.get(y).get(0)][gizli_altinlar.get(y).get(1)].setBackground(Color.YELLOW);
			  }
			
	
			 
		  }
		
		
	
		  
		/*  try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} */
		  
		  this.setVisible(true); 
		
	    
		  
		  this.setTitle("altin toplama oyunu"); 
		    getContentPane().setLayout(new GridLayout(n, m));
		    this.setSize(1041,800);
		   	   
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		    this.setResizable(false);
		   // this.repaint();
		  
	
			
		    
	}
	
	
	

}
