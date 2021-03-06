package yazlab1;

import static java.lang.System.out;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class b_oyuncusu extends oyuncular {

	public static char ad = 'B';
	public static int toplam_altin;
	public static int hamle_maliyeti;
	public static int hedef_belirleme_maliyeti;
	public static int harcanan_altin;
	public static int toplanan_altin;
	
	ArrayList<Integer> gidilen_yol = new ArrayList<Integer>(); 
	ArrayList<Integer> gidilecek_yol = new ArrayList<Integer>();
	List<List<Integer>> konum = new ArrayList<List<Integer>>();
	
	File file = new File("Btext.txt");
	
	public b_oyuncusu() {

		//super(ad, toplam_altin, hamle_maliyeti, hedef_belirleme_maliyeti);
	}
	
	
	public b_oyuncusu(int hamle_maliyeti ,int hedef_belirleme_maliyeti ,int toplam_altin ) {
		
		this.setHamle_maliyeti(hamle_maliyeti);
		this.setHedef_belirleme_maliyeti(hedef_belirleme_maliyeti);
		this.setToplam_altin(toplam_altin); 
		
		
	}
	

	public int getToplam_altin() {
		return toplam_altin;
	}


	public void setToplam_altin(int toplam_altin) {
		b_oyuncusu.toplam_altin = toplam_altin;
	}


	public int getHamle_maliyeti() {
		return hamle_maliyeti;
	}


	public void setHamle_maliyeti(int hamle_maliyeti) {
		b_oyuncusu.hamle_maliyeti = hamle_maliyeti;
	}


	public static int getHedef_belirleme_maliyeti() {
		return hedef_belirleme_maliyeti;
	}


	public static void setHedef_belirleme_maliyeti(int hedef_belirleme_maliyeti) {
		b_oyuncusu.hedef_belirleme_maliyeti = hedef_belirleme_maliyeti;
	}
	
	
	public ArrayList<Integer> izlenen_yol( List<List<Integer>> array , List<List<Integer>> normal_altinlar, int m) {
		
		if(konum.isEmpty()) {
			
			int altin =  array.get(normal_altinlar.get(0).get(0)).get(normal_altinlar.get(0).get(1));
			int maliyet = (Math.abs(0-normal_altinlar.get(0).get(0))+Math.abs(m-1-normal_altinlar.get(0).get(1)))*hamle_maliyeti+hedef_belirleme_maliyeti; 		
			int enKarli =altin-maliyet;
					
			
			gidilen_yol=(ArrayList<Integer>) normal_altinlar.get(0);
			
			for(int x=1; x<normal_altinlar.size(); x++) {
				 
				int altin1= array.get(normal_altinlar.get(x).get(0)).get(normal_altinlar.get(x).get(1));
				int maliyet1 =(Math.abs(0-normal_altinlar.get(x).get(0))+Math.abs(m-1-normal_altinlar.get(x).get(1)))*hamle_maliyeti+hedef_belirleme_maliyeti; 
				int hesap = altin1-maliyet1;
				
				if( hesap >= enKarli) {
					enKarli = hesap ; 
					altin=altin1;
					maliyet =maliyet1; 
					gidilen_yol=(ArrayList<Integer>) normal_altinlar.get(x);
				}
					
				
			}
	
			toplam_altin+=enKarli;
			harcanan_altin=maliyet;
			toplanan_altin=altin;
			normal_altinlar.remove(gidilen_yol);
			konum.add(gidilen_yol);
			
			out.println("b konum:"+konum);
			out.println("b harcanan altin:"+harcanan_altin);
			out.println("b toplanan altin:"+toplanan_altin);
			out.println("b kasadaki altin:"+toplam_altin);
			
			return gidilen_yol;
	
		
		}
		else {
			
			if(normal_altinlar.isEmpty()!=true && toplam_altin>0) {
				
				int altin =  array.get(normal_altinlar.get(0).get(0)).get(normal_altinlar.get(0).get(1));
				int maliyet =(Math.abs(konum.get(konum.size()-1).get(0)-normal_altinlar.get(0).get(0))
						+Math.abs(konum.get(konum.size()-1).get(1)-normal_altinlar.get(0).get(1)))*(hamle_maliyeti)+hedef_belirleme_maliyeti;
						
						
				int enKarli = altin - maliyet ;
						
			
			
				gidilen_yol=(ArrayList<Integer>) normal_altinlar.get(0);
				
				for(int x=1; x<normal_altinlar.size(); x++) {
					
					int altin1 = array.get(normal_altinlar.get(x).get(0)).get(normal_altinlar.get(x).get(1));
					int maliyet1 = (Math.abs(konum.get(konum.size()-1).get(0)-normal_altinlar.get(x).get(0))
							+Math.abs(konum.get(konum.size()-1).get(1)-normal_altinlar.get(x).get(1)))*(hamle_maliyeti)+hedef_belirleme_maliyeti;
					
						int sayi=altin1-maliyet1;
					
				if(sayi>=enKarli) {
					
					enKarli=sayi;
					altin=altin1;
					maliyet = maliyet1;
					
					gidilen_yol=(ArrayList<Integer>) normal_altinlar.get(x);
				
						
					}
						
					
				}
	

				
				if(toplam_altin>0) {
					
					toplam_altin+=enKarli;
					harcanan_altin=maliyet;
					toplanan_altin=altin;
				    normal_altinlar.remove(gidilen_yol);
					konum.add(gidilen_yol);
					out.println("b konum:"+konum);
					out.println("b harcanan altin:"+harcanan_altin);
					out.println("b toplanan altin:"+toplanan_altin);
					out.println("b kasadaki altin:"+toplam_altin);
					
				}
					if(toplam_altin<=0) {
						
						toplam_altin-=enKarli;
						out.println("b konum:"+konum);
						out.println("b harcanan altin:"+harcanan_altin);
						out.println("b toplanan altin:"+toplanan_altin);
						out.println("b kasadaki altin:"+toplam_altin);
				}
			
				
			}
			else {
				
				out.println("normal altin bitti");
			}
			
			
		}
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
			bw.write("B OYUNCUSUNUN :");
			    bw.newLine();
			    bw.write("b konum:"+konum);
			    bw.newLine();
			    bw.write("b harcanan altin:"+harcanan_altin);
			    bw.newLine();
			    bw.write("b toplanan altin:"+toplanan_altin);
		        bw.newLine();
			    bw.write("b kasadaki altin:"+toplam_altin);
			    bw.flush();
			} catch (IOException e) {
			    System.out.println("Unable to read file " +file.toString());
			}
		
		return gidilen_yol;
	
	}
	 
}
