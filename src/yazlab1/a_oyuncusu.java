package yazlab1;

import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
 
public class a_oyuncusu {
	
	public static char ad = 'A';
	public  static int toplam_altin ;
	public static int hamle_maliyeti ;
	public  static int hedef_belirleme_maliyeti;

	ArrayList<Integer> gidilen_yol = new ArrayList<Integer>(); 
	ArrayList<Integer> gidilecek_yol = new ArrayList<Integer>();
	List<List<Integer>> konum = new ArrayList<List<Integer>>();
	
	public static int maliyet;
	public static int altin;
	public static int harcanan_altin;
	public static int toplanan_altin;
	
	File file = new File("Atext.txt");
	
	public a_oyuncusu() {
		//super(ad, toplam_altin, hamle_maliyeti, hedef_belirleme_maliyeti);	
	} 
	
	
	public a_oyuncusu(int hamle_maliyeti ,int hedef_belirleme_maliyeti ,int toplam_altin ) {
	
		this.setHamle_maliyeti(hamle_maliyeti);
		this.setHedef_belirleme_maliyeti(hedef_belirleme_maliyeti);
		this.setToplam_altin(toplam_altin); 
		
		
	}
	

	public int getToplam_altin() {
		return toplam_altin;
	}


	public void setToplam_altin(int toplam_altin) {
		a_oyuncusu.toplam_altin = toplam_altin;
	}


	public int getHamle_maliyeti() {
		return hamle_maliyeti;
	}


	public void setHamle_maliyeti(int hamle_maliyeti) {
		a_oyuncusu.hamle_maliyeti = hamle_maliyeti;
	}


	public static int getHedef_belirleme_maliyeti() {
		return hedef_belirleme_maliyeti;
	}


	public static void setHedef_belirleme_maliyeti(int hedef_belirleme_maliyeti) {
		a_oyuncusu.hedef_belirleme_maliyeti = hedef_belirleme_maliyeti;
	}


	public ArrayList<Integer> izlenen_yol( List<List<Integer>> array , List<List<Integer>> normal_altinlar) {
		
		if(konum.isEmpty()) {
			
			gidilen_yol = new ArrayList<Integer>(); 
			
			int enKucuk = normal_altinlar.get(0).get(0)+normal_altinlar.get(0).get(1);
			gidilen_yol=(ArrayList<Integer>) normal_altinlar.get(0);
			
			for(int x=1; x<normal_altinlar.size(); x++) {
				
				if( (normal_altinlar.get(x).get(0)+normal_altinlar.get(x).get(1)) <= enKucuk) {
					enKucuk=(normal_altinlar.get(x).get(0)+normal_altinlar.get(x).get(1));
					gidilen_yol=(ArrayList<Integer>) normal_altinlar.get(x);
				}
					
				
			}
			
			int altin = array.get(gidilen_yol.get(0)).get(gidilen_yol.get(1));
			
			int maliyet = (hamle_maliyeti)*enKucuk + hedef_belirleme_maliyeti;
			
			harcanan_altin=maliyet;
			toplam_altin=toplam_altin-maliyet+altin;
			toplanan_altin=altin;
			
			normal_altinlar.remove(gidilen_yol);
			konum.add(gidilen_yol);

			out.println("a konum:"+konum);
			out.println("a harcanan altin:"+harcanan_altin);
			out.println("a toplanan altin:"+toplanan_altin);
			out.println("a kasadaki altin:"+toplam_altin);
			
			
			return gidilen_yol;
			
			
		}
		else {
			
			if(normal_altinlar.isEmpty()!=true && toplam_altin>0) {
				
				int enKucuk = Math.abs(konum.get(konum.size()-1).get(0)-normal_altinlar.get(0).get(0))+ Math.abs(konum.get(konum.size()-1).get(1)-normal_altinlar.get(0).get(1));
				
				out.println("enKucuk:"+enKucuk);
				gidilen_yol=(ArrayList<Integer>) normal_altinlar.get(0);
				
				for(int x=1; x<normal_altinlar.size(); x++) {
					
				int sayi=Math.abs(konum.get(konum.size()-1).get(0)-normal_altinlar.get(x).get(0))+ Math.abs(konum.get(konum.size()-1).get(1)-normal_altinlar.get(x).get(1));
					if(sayi<=enKucuk) {
						enKucuk=sayi;
						gidilen_yol=(ArrayList<Integer>) normal_altinlar.get(x);
					}
						
					
				}
		
				 
				
				if(toplam_altin>0) {
				
					
					 altin = array.get(gidilen_yol.get(0)).get(gidilen_yol.get(1));
					
					 maliyet = (hamle_maliyeti)*enKucuk + hedef_belirleme_maliyeti;
					 harcanan_altin=maliyet;
					toplam_altin=toplam_altin-maliyet+altin;
					toplanan_altin=altin;
					
					normal_altinlar.remove(gidilen_yol);
					konum.add(gidilen_yol);

					out.println("a konum:"+konum);
					out.println("a harcanan altin:"+harcanan_altin);
					out.println("a toplanan altin:"+toplanan_altin);
					out.println("a kasadaki altin:"+toplam_altin);
					
					
				}
				if(toplam_altin<=0) {
					
					toplam_altin=toplam_altin+maliyet-altin;
					out.println("a konum:"+konum);
					out.println("a harcanan altin:"+harcanan_altin);
					out.println("a kasadaki altin:"+toplam_altin);
					out.println("a kasadaki altin:"+toplam_altin);
				}
			
				
			}
			else {
				
				out.println("normal altin bitti");
			}
		
			try(BufferedWriter aw = new BufferedWriter(new FileWriter(file))){
				aw.write("A OYUNCUSUNUN :");
				    aw.newLine();
				    aw.write("a konum:"+konum);
				    aw.newLine();
				    aw.write("a harcanan altin:"+harcanan_altin);
				    aw.newLine();
				    aw.write("a toplanan altin:"+toplanan_altin);
			        aw.newLine();
				    aw.write("a kasadaki altin:"+toplam_altin);
				    aw.flush();
				} catch (IOException e) {
				    System.out.println("Unable to read file " +file.toString());
				}
			
			return gidilen_yol;
		}
		 		
	}
		
}
