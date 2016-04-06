package Trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class Run {

	public static void main(String[] args){
		String eingabe;
		ArrayList<Vokabeln>	list	= new ArrayList<Vokabeln>();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		Check check =new Check();
		
		list.add(new Vokabeln("1Apfel","1apple"));
		list.add(new Vokabeln("2Apfel","2apple"));
		list.add(new Vokabeln("3Apfel","3apple"));
		list.add(new Vokabeln("4Apfel","4apple"));
		list.add(new Vokabeln("5Apfel","5apple"));
		list.add(new Vokabeln("6Apfel","6apple"));
		list.add(new Vokabeln("7Apfel","7apple"));
		list.add(new Vokabeln("8Apfel","8apple"));
		list.add(new Vokabeln("9Apfel","9apple"));
		list.add(new Vokabeln("10Apfel","10apple"));
		list.add(new Vokabeln("11Apfel","11apple"));
		list.add(new Vokabeln("12Apfel","12apple"));
		list.add(new Vokabeln("13Apfel","13apple"));
		
		int rnd = (int)((Math.random()) * list.size());
		int rnd2 = (int)((Math.random()) * 2);
		String vokabel="lol";
		if(rnd2==0){
			vokabel =list.get(rnd).getausland();
		}else if (rnd2 ==1){
			vokabel=list.get(rnd).getinland();
		
		}
		
		System.out.println("Geben sie die Übersetzung von "+vokabel+" ein");
		try{
			eingabe = br.readLine();
		}catch(IOException e){
			return;
		}
		check.check(eingabe,vokabel, rnd, rnd2, list);
		
		
	}

}
