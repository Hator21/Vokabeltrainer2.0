package Trainer;

import NewGui.MainFrame;

public class Statistik {
	private MainFrame frame;

	public String NoteTest(){
		int right=frame.getVocabeltestPanel().getRight();
		String note="";
		right=100/10*right;
		if(right>=95){
			note="1";
		}if(right>=90&&right<95){
			note="1-";
		}if(right>=85&&right<90){
			note="2+";
		}if(right>=80&&right<85){
			note="2";
		}if(right>=75&&right<80){
			note="2-";
		}if(right>=70&&right<75){
			note="3+";
		}if(right>=65&&right<70){
			note="3";
		}if(right>=60&&right<65){
			note="3-";
		}if(right>=55&&right<60){
			note="4+";
		}if(right>=50&&right<55){
			note="4";
		}if(right>=45&&right<50){
			note="4-";
		}if(right>=38&&right<45){
			note="5+";
		}if(right>=31&&right<38){
			note="5";
		}if(right>=25&&right<31){
			note="5-";
		}if(right>=0&&right<25){
			note="6";
		}
		return note;
	}

}
