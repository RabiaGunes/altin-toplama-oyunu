package yazlab1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import static java.lang.System.out;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.SystemColor; 

public class oyun_tahtasi extends JFrame {

	 private JPanel contentPane;
	 private JTable table;
	 private JButton buton[][];
	private JTextField n_text;
	private JTextField m_text;
	ArrayList<Integer> numbers;
	List<List<Integer>> gizli_altinlar;
	List<List<Integer>> normal_altinlar;
	 List<List<Integer>> array = new ArrayList<List<Integer>>();
	 List<Integer> silinecek_yol = new ArrayList<Integer>();
	 private JTextField a_hamle;
	 private JTextField a_hedef;
	 private JTextField a_altin;
	 private JTextField b_hamle;
	 private JTextField c_hamle;
	 private JTextField d_hamle;
	 private JTextField b_hedef;
	 private JTextField b_altin;
	 private JTextField c_hedef;
	 private JTextField c_altin;
	 private JTextField d_hedef;
	 private JTextField d_altin;
	public	 int xa,ya,za,xb,yb,zb,xc,yc,zc,xd,yd,zd;
	private JLabel lblNewLabel_4;
	 
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					oyun_tahtasi frame = new oyun_tahtasi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	

	  
	  
	public oyun_tahtasi() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 611);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		n_text = new JTextField();
		n_text.setBackground(SystemColor.inactiveCaption);
		n_text.setFont(new Font("Tahoma", Font.BOLD, 17));
		n_text.setBounds(104, 476, 56, 22);
		contentPane.add(n_text);
		n_text.setColumns(10);
	
	
		m_text = new JTextField();
		m_text.setBackground(SystemColor.inactiveCaption);
		m_text.setFont(new Font("Tahoma", Font.BOLD, 17));
		m_text.setBounds(346, 476, 56, 22);
		contentPane.add(m_text);
		m_text.setColumns(10);
		
		
		
		a_hamle = new JTextField();
		a_hamle.setBackground(SystemColor.menu);
		a_hamle.setBounds(130, 172, 102, 22);
		contentPane.add(a_hamle);
		a_hamle.setColumns(10);
		
		a_hedef = new JTextField();
		a_hedef.setColumns(10);
		a_hedef.setBackground(SystemColor.menu);
		a_hedef.setBounds(280, 172, 102, 22);
		contentPane.add(a_hedef);
		
		a_altin = new JTextField();
		a_altin.setColumns(10);
		a_altin.setBackground(SystemColor.menu);
		a_altin.setBounds(432, 172, 102, 22);
		contentPane.add(a_altin);
		
		b_hamle = new JTextField();
		b_hamle.setColumns(10);
		b_hamle.setBackground(SystemColor.menu);
		b_hamle.setBounds(130, 224, 102, 22);
		contentPane.add(b_hamle);
		
		c_hamle = new JTextField();
		c_hamle.setColumns(10);
		c_hamle.setBackground(SystemColor.menu);
		c_hamle.setBounds(130, 291, 102, 22);
		contentPane.add(c_hamle);
		
		d_hamle = new JTextField();
		d_hamle.setColumns(10);
		d_hamle.setBackground(SystemColor.menu);
		d_hamle.setBounds(130, 354, 102, 22);
		contentPane.add(d_hamle);
		
		b_hedef = new JTextField();
		b_hedef.setColumns(10);
		b_hedef.setBackground(SystemColor.menu);
		b_hedef.setBounds(280, 224, 102, 22);
		contentPane.add(b_hedef);
		
		b_altin = new JTextField();
		b_altin.setColumns(10);
		b_altin.setBackground(SystemColor.menu);
		b_altin.setBounds(432, 224, 102, 22);
		contentPane.add(b_altin);
		
		c_hedef = new JTextField();
		c_hedef.setColumns(10);
		c_hedef.setBackground(SystemColor.menu);
		c_hedef.setBounds(279, 291, 102, 22);
		contentPane.add(c_hedef);
		
		c_altin = new JTextField();
		c_altin.setColumns(10);
		c_altin.setBackground(SystemColor.menu);
		c_altin.setBounds(432, 291, 102, 22);
		contentPane.add(c_altin);
		
		d_hedef = new JTextField();
		d_hedef.setColumns(10);
		d_hedef.setBackground(SystemColor.menu);
		d_hedef.setBounds(280, 354, 102, 22);
		contentPane.add(d_hedef);
		
		d_altin = new JTextField();
		d_altin.setColumns(10);
		d_altin.setBackground(SystemColor.menu);
		d_altin.setBounds(432, 354, 102, 22);
		contentPane.add(d_altin);
		
		
		
		
		JButton btnNewButton = new JButton("play");
		btnNewButton.setBackground(new Color(51, 153, 153));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!n_text.getText().isEmpty() && !m_text.getText().isEmpty() && 
					!a_hamle.getText().isEmpty() && !a_hedef.getText().isEmpty() && !a_altin.getText().isEmpty()&&
					!b_hamle.getText().isEmpty() && !b_hedef.getText().isEmpty() && !b_altin.getText().isEmpty()&&
					!c_hamle.getText().isEmpty() && !c_hedef.getText().isEmpty() && !c_altin.getText().isEmpty()&&
					!d_hamle.getText().isEmpty() && !d_hedef.getText().isEmpty() && !d_altin.getText().isEmpty()) {
					
					String ny = n_text.getText().toString();
					String my = m_text.getText().toString();
					
					int n = Integer.parseInt(ny);
					int m = Integer.parseInt(my);
					
					String aha = a_hamle.getText().toString();
					String ahe = a_hedef.getText().toString();
					String alt = a_altin.getText().toString();
					
					String bha = b_hamle.getText().toString();
					String bhe = b_hedef.getText().toString();
					String blt = b_altin.getText().toString();
					
					String cha = c_hamle.getText().toString();
					String che = c_hedef.getText().toString();
					String clt = c_altin.getText().toString();
					
					String dha = d_hamle.getText().toString();
					String dhe = d_hedef.getText().toString();
					String dlt = d_altin.getText().toString();
					
					 xa = Integer.parseInt(aha);
					 ya = Integer.parseInt(ahe);
					 za = Integer.parseInt(alt);
					
					 xb = Integer.parseInt(bha);
					 yb = Integer.parseInt(bhe);
					 zb = Integer.parseInt(blt);
					 
					 xc = Integer.parseInt(cha);
					 yc = Integer.parseInt(che);
					 zc = Integer.parseInt(clt);
					 
					 xd = Integer.parseInt(dha);
					 yd = Integer.parseInt(dhe);
					 zd = Integer.parseInt(dlt);
					 
					array_olustur(n,m);
					
					
				}
				
				else {
					
					xa=5;ya=5;za=200;
					xb=5;yb=10;zb=200;
					xc=5;yc=15;zc=200;
					xd=5;yd=20;zd=200;
					
					array_olustur(20,20);
				}
				

				
			}
		});
		btnNewButton.setBounds(159, 511, 122, 25);
		contentPane.add(btnNewButton);
		
	
		JLabel satir = new JLabel("row :");
		satir.setFont(new Font("Tahoma", Font.BOLD, 17));
		satir.setBounds(36, 479, 56, 16);
		contentPane.add(satir);
		
		JLabel lblSutun = new JLabel("column :");
		lblSutun.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSutun.setBounds(243, 479, 90, 16);
		contentPane.add(lblSutun);
		
		JLabel lblNewLabel = new JLabel("A oyuncusu:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 174, 122, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblBOyuncusu = new JLabel("B oyuncusu:");
		lblBOyuncusu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBOyuncusu.setBounds(12, 226, 122, 16);
		contentPane.add(lblBOyuncusu);
		
		JLabel lblCOyuncusu = new JLabel("C oyuncusu:");
		lblCOyuncusu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCOyuncusu.setBounds(12, 293, 122, 16);
		contentPane.add(lblCOyuncusu);
		
		JLabel lblDOyuncusu = new JLabel("D oyuncusu:");
		lblDOyuncusu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDOyuncusu.setBounds(12, 356, 122, 16);
		contentPane.add(lblDOyuncusu);
		
		JLabel lblNewLabel_1 = new JLabel("hamle maliyeti");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(130, 127, 122, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblHedefMaliyeti = new JLabel("hedef maliyeti");
		lblHedefMaliyeti.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHedefMaliyeti.setBounds(280, 127, 122, 16);
		contentPane.add(lblHedefMaliyeti);
		
		JLabel lblToplamAltin = new JLabel("toplam altin");
		lblToplamAltin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblToplamAltin.setBounds(429, 127, 122, 16);
		contentPane.add(lblToplamAltin);
		
	
		
		JLabel lblNewLabel_2 = new JLabel("oyuncu ozellikleri girdiyseniz tahta boyutunu giriniz");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblNewLabel_2.setBounds(36, 397, 498, 38);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Varsayilan ozellikleri degistirmek istiyorsaniz parametleri giriniz");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblNewLabel_3.setBounds(12, 13, 557, 38);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("ozellikleri degistirirseniz tablo boyutunu da giriniz");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblNewLabel_4.setBounds(12, 66, 498, 38);
		contentPane.add(lblNewLabel_4);
		
	
		
		
	}
	
	
	
	public void array_olustur(int n , int m) {
		
		for (int i = 0; i < n; i++) {

			List<Integer> list = new ArrayList<Integer>();
			array.add(list);
			for (int j = 0; j < m; j++) {

				// int x = (int)(Math.random()*((2-0)+1))+0;
				list.add(0);

			}
			// out.println( list );

		}
		
		numbers = new ArrayList<Integer>();
		gizli_altinlar = new ArrayList<List<Integer>>();
		normal_altinlar = new ArrayList<List<Integer>>();

		numbers.add(5);
		numbers.add(10);
		numbers.add(15);
		numbers.add(20);
	
		

		int count = 0, count2 = 0, count3 = 0, count4 = 0;

		for (int sayac = 0; sayac < ((m * n * 20) / 100) + count; sayac++) {

			int satir = ((int) (Math.random() * n));
			int sutun = ((int) (Math.random() * m));

			if ((satir != 0 || sutun != 0) && (satir != n - 1 || sutun != 0) && (satir != m - 1 || sutun != 0)
					&& (satir != n - 1 && sutun != m - 1)) {
				if (array.get(satir).get(sutun) == 0) {
					array.get(satir).set(sutun, numbers.get(((int) (Math.random() * 4))));

					List<Integer> list = new ArrayList<Integer>();
					list.add(satir);
					list.add(sutun);
					normal_altinlar.add(list);
					count2++;
				} else {
					count++;
				}
			} else {
				count++;
			}
		}

		// gizli altin belirlemek icin

		int say, counter = 0;
		out.println(normal_altinlar);
	
		for (int k = 0; k < (m * n * 2) / 100; k++) {

			if (gizli_altinlar.isEmpty()) {
				say = (int) (Math.random() * ((m * n * 20) / 100-1));
				gizli_altinlar.add(normal_altinlar.get(say));
				normal_altinlar.remove(say);

			} else {
				say = (int) (Math.random() * (normal_altinlar.size()));
				
				for (int i = 0; i < gizli_altinlar.size(); i++) {
					if (normal_altinlar.get(say) != gizli_altinlar.get(i))
						counter++;
				}

				if (counter == gizli_altinlar.size()) {
					gizli_altinlar.add(normal_altinlar.get(say));
					normal_altinlar.remove(say);
				}

			}
			//(m * n * 20) / 100-1)
			counter = 0;

		}

		out.println("gizli altinlar: " + gizli_altinlar);
//	        out.println("count3:"+count3 + "--"+"count4:" + count4);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				out.print(array.get(i).get(j));
			}
			out.print("\n");
		}
		out.print("count1:" + count + "  count2:" + count2);
		out.println("\nnormal altinlar:" + normal_altinlar);
		out.println("gizliler:" + gizli_altinlar);
		
	
	//	game_page page ; 
		//page = new game_page(array,gizli_altinlar,normal_altinlar,n,m,silinecek_yol);
		
		oyuncu_olustur(n,m);

	}
	
	
	
	public void oyuncu_olustur(int n , int m ) {
		
		
			a_oyuncusu a = new a_oyuncusu(xa,ya,za);
		    b_oyuncusu b = new b_oyuncusu(xb,yb,zb);
			c_oyuncusu c = new c_oyuncusu(xc,yc,zc);
			d_oyuncusu d = new d_oyuncusu(xd,yd,zd);
			
			out.println("A.GET:"+a.getHamle_maliyeti());
			out.println("hamle_mal:"+a.getHamle_maliyeti());
			out.println("hedef_mal:"+a.hedef_belirleme_maliyeti);
			out.println("alt:"+a.getToplam_altin());
			 
			game_page page;
			page = new game_page(array, gizli_altinlar, normal_altinlar, n, m, silinecek_yol );
			
		while(normal_altinlar.isEmpty()!=true ) {
			
			if(a.toplam_altin>0) {
				
				silinecek_yol = a.izlenen_yol(array,normal_altinlar);
				out.println("silinecek: "+silinecek_yol); 
				
				page = new game_page(array, gizli_altinlar, normal_altinlar, n, m, silinecek_yol );
				//  page.setVisible(true);
				
			}
			
		
			if(b.toplam_altin>0) {
				silinecek_yol = b.izlenen_yol(array, normal_altinlar, m);
				out.println("silinecek: "+silinecek_yol); 
				page = new game_page(array, gizli_altinlar, normal_altinlar, n, m, silinecek_yol );
				 
			//	  page.setVisible(true);
			
			}
			
			if(c.toplam_altin>0) {
				silinecek_yol = c.izlenen_yol(array, normal_altinlar, gizli_altinlar,n);
				out.println("silinecek: "+silinecek_yol); 	
				page = new game_page(array, gizli_altinlar, normal_altinlar, n, m, silinecek_yol );
			//	page.setVisible(true);
			
			}
			
			if(d.toplam_altin>0) {
				silinecek_yol = d.izlenen_yol(array, normal_altinlar,m,n);
				out.println("silinecek: "+silinecek_yol); 	
				page = new game_page(array, gizli_altinlar, normal_altinlar, n, m, silinecek_yol );
				//  page.setVisible(true);
			
			}
			
	    	out.println("a Altin:"+a.toplam_altin); 
	    	out.println("b Altin:"+b.toplam_altin); 
			out.println("c Altin:"+c.toplam_altin); 
			out.println("d Altin:"+d.toplam_altin); 
			
								
		} 
        
	

		// page = new game_page(array, gizli_altinlar, normal_altinlar, n, m, silinecek_yol );
	
		//(array,gizli_altinlar,normal_altinlar,n,m);
		
		
		
		
	}
	
	
}
