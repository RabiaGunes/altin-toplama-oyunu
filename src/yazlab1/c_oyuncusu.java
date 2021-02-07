package yazlab1;

import static java.lang.System.out;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class c_oyuncusu extends oyuncular {

	public static char ad = 'C';
	public static int toplam_altin;
	public static int hamle_maliyeti;
	public static int hedef_belirleme_maliyeti;
	public static int c;
	public static int harcanan_altin;
	public static int toplanan_altin;

	ArrayList<Integer> gidilen_yol = new ArrayList<Integer>(); 
	ArrayList<Integer> gidilecek_yol = new ArrayList<Integer>();
	List<List<Integer>> konum = new ArrayList<List<Integer>>();

	File file = new File("Ctext.txt");
	
	public c_oyuncusu() {

		//super(ad, toplam_altin, hamle_maliyeti, hedef_belirleme_maliyeti);
	}
	
	
	
	public c_oyuncusu(int hamle_maliyeti ,int hedef_belirleme_maliyeti ,int toplam_altin ) {
		
		this.setHamle_maliyeti(hamle_maliyeti);
		this.setHedef_belirleme_maliyeti(hedef_belirleme_maliyeti);
		this.setToplam_altin(toplam_altin); 
		
	
		
	}
	

	public int getToplam_altin() {
		return toplam_altin;
	}


	public void setToplam_altin(int toplam_altin) {
		c_oyuncusu.toplam_altin = toplam_altin;
	}


	public int getHamle_maliyeti() {
		return hamle_maliyeti;
	}


	public void setHamle_maliyeti(int hamle_maliyeti) {
		c_oyuncusu.hamle_maliyeti = hamle_maliyeti;
	}


	public static int getHedef_belirleme_maliyeti() {
		return hedef_belirleme_maliyeti;
	}


	public static void setHedef_belirleme_maliyeti(int hedef_belirleme_maliyeti) {
		c_oyuncusu.hedef_belirleme_maliyeti = hedef_belirleme_maliyeti;
	}
	
	
	
	public ArrayList<Integer> izlenen_yol( List<List<Integer>> array , List<List<Integer>> normal_altinlar, List<List<Integer>> gizli_altinlar ,int n) {
		
		if(!gizli_altinlar.isEmpty() && gizli_altinlar.size()!=1) {
	
			for(int x=0 ; x<2 ; x++) {
				
				int enKucuk = Math.abs(n-1-gizli_altinlar.get(0).get(0))+Math.abs(0-gizli_altinlar.get(0).get(1));
				c=0;
				
				
				for(int i=1; i<gizli_altinlar.size(); i++) {
					
					int hesap = Math.abs(n-1-gizli_altinlar.get(i).get(0))+Math.abs(0-gizli_altinlar.get(i).get(1));
							
					if( hesap <= enKucuk) {
						
						enKucuk = hesap ; 
						c=i;
					}
						
					
				}
				
				normal_altinlar.add(gizli_altinlar.get(c));
				gizli_altinlar.remove(c);

			}
		
			
		}
		else if(gizli_altinlar.size()==1) {
			
			normal_altinlar.add(gizli_altinlar.get(0));
			gizli_altinlar.remove(0);
			
		}
		
		
		
		
		
		if(konum.isEmpty()) {
			
			int altin = array.get(normal_altinlar.get(0).get(0)).get(normal_altinlar.get(0).get(1));
			int maliyet = (Math.abs(n-1-normal_altinlar.get(0).get(0))+Math.abs(0-normal_altinlar.get(0).get(1)))*(hamle_maliyeti)+hedef_belirleme_maliyeti;
			int enKarli = altin - maliyet; 
					
						
			gidilen_yol=(ArrayList<Integer>) normal_altinlar.get(0);
			
			for(int x=1; x<normal_altinlar.size(); x++) {
				
				int altin1 =  array.get(normal_altinlar.get(x).get(0)).get(normal_altinlar.get(x).get(1));
				int maliyet1 = (Math.abs(n-1-normal_altinlar.get(x).get(0))+Math.abs(0-normal_altinlar.get(x).get(1)))*(hamle_maliyeti)+hedef_belirleme_maliyeti;
				
				int hesap = altin1 - maliyet1;
						
				
				if( hesap >= enKarli) {
					enKarli = hesap ;
					altin = altin1;
					maliyet = maliyet1;
					gidilen_yol=(ArrayList<Integer>) normal_altinlar.get(x);
				}
					
				
			}
	
			toplam_altin += enKarli;
			harcanan_altin = maliyet;
			toplanan_altin = altin;
			
			normal_altinlar.remove(gidilen_yol);
			konum.add(gidilen_yol);
			
			out.println("c konum:"+konum);
			out.println("c harcanan altin:"+harcanan_altin);
			out.println("c toplanan altin:"+toplanan_altin);
			out.println("c kasadaki altin:"+toplam_altin);
			
			return gidilen_yol;
	
		
		}
		else {
			
			if(!normal_altinlar.isEmpty() && toplam_altin>0) {
				
				int altin = array.get(normal_altinlar.get(0).get(0)).get(normal_altinlar.get(0).get(1));
				int maliyet =(Math.abs(konum.get(konum.size()-1).get(0)-normal_altinlar.get(0).get(0))
						+Math.abs(konum.get(konum.size()-1).get(1)-normal_altinlar.get(0).get(1)))*(hamle_maliyeti)+hedef_belirleme_maliyeti; 
				
				int enKarli = altin - maliyet;
			
				gidilen_yol=(ArrayList<Integer>) normal_altinlar.get(0);
				
				for(int x=1; x<normal_altinlar.size(); x++) {
				
					int altin1 = array.get(normal_altinlar.get(x).get(0)).get(normal_altinlar.get(x).get(1));
					int maliyet1 = (Math.abs(konum.get(konum.size()-1).get(0)-normal_altinlar.get(x).get(0))
							+Math.abs(konum.get(konum.size()-1).get(1)-normal_altinlar.get(x).get(1)))*(hamle_maliyeti)+hedef_belirleme_maliyeti;
		
					int sayi= altin1 - maliyet1;
							
				if(sayi>=enKarli) {
					
					enKarli=sayi;
					altin = altin1;
					maliyet = maliyet1;
					gidilen_yol=(ArrayList<Integer>) normal_altinlar.get(x);
				
						
					}
						
					
				}
	

				
				if(toplam_altin>0) {
					
					toplam_altin += enKarli;
					harcanan_altin = maliyet;
					toplanan_altin = altin;
				    normal_altinlar.remove(gidilen_yol);
					konum.add(gidilen_yol);
					
					out.println("c konum:"+konum);
					out.println("c harcanan altin:"+harcanan_altin);
					out.println("c toplanan altin:"+toplanan_altin);
					out.println("c kasadaki altin:"+toplam_altin);
					
					
				}
					if(toplam_altin<=0) {
						
						toplam_altin-=enKarli;
						
						out.println("c konum:"+konum);
						out.println("c harcanan altin:"+harcanan_altin);
						out.println("c toplanan altin:"+toplanan_altin);
						out.println("c kasadaki altin:"+toplam_altin);
				}
			
				
			}
			else {
				
				out.println("normal altin bitti");
			}

			try(BufferedWriter cw = new BufferedWriter(new FileWriter(file))){
				cw.write("C OYUNCUSUNUN :");
				    cw.newLine();
				    cw.write("c konum:"+konum);
				    cw.newLine();
				    cw.write("c harcanan altin:"+harcanan_altin);
				    cw.newLine();
				    cw.write("c toplanan altin:"+toplanan_altin);
			        cw.newLine();
				    cw.write("c kasadaki altin:"+toplam_altin);
				    cw.flush();
				} catch (IOException e) {
				    System.out.println("Unable to read file " +file.toString());
				}
			
		} 
		
		return gidilen_yol;
	
	}
	
}