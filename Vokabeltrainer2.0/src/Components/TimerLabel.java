package Components;

import javax.swing.Timer;

import NewGui.MainFrame;

public class TimerLabel {

	private MainFrame		frame;
	private static int		counterValue;
	private static Timer	timer;
	private static int		min, sec;
	private boolean			stopper;

	public TimerLabel(MainFrame frame, int starttimeMin, int starttimeSec) {
		this.frame = frame;

		counterValue = (starttimeMin * 60) + starttimeSec;

	}

	public void startTimer() {
		TimerLabel.timer = new Timer(1000, e -> {
			System.err.println(counterValue);
			TimerLabel.counterValue--;
			System.err.println(counterValue);
			TimerLabel.this.printTimer(counterValue);

			if ((TimerLabel.counterValue == 0) || (TimerLabel.this.stopper == true)) {
				frame.getVocabeltestPanel().getNext().doClick();
				// this.frame.getVocabeltestPanel().setRight(this.frame.getCheck().check(this.frame.getVocabeltestPanel().getSpeech2Text().getText(), this.frame.getVocabeltestPanel().getSpeech1Text().getText(), this.frame.getVocabeltestPanel().getRight()));
				// this.frame.getVocabeltestPanel().setRight(this.frame.getVocabeltestPanel().getRight() - this.frame.getVocabeltestPanel().getCounts());
				// TimerLabel.this.frame.getVocabeltestPanel().setCounts(0);
				// TimerLabel.this.frame.getVocabeltestPanel().getSpeech1Text().setText("");
				// TimerLabel.this.frame.getVocabeltestPanel().getSpeech2Text().setText("");
				// TimerLabel.this.frame.getVocabeltestPanel().getSpeech2Text().setEditable(false);
				// frame.getStats().retDateForTable();
				// for (JPanel p : frame.getPanelList()) {
				// p.setVisible(false);
				// }
				// frame.getPanelList().get(11).setVisible(true);
				// frame.getHeadingbar().getHeadingLabelL().setText("Statistik");
				// frame.getHeadingbar().getHeadingLabelR().setText("");
				System.out.println("Counterdown ausgelaufen!");
				TimerLabel.timer.stop();
			}
		});
		timer.start();
	}

	public void printTimer(int time) {
		String s;
		if (time >= 60) {
			min = time / 60;
			sec = time % 60;
		} else {
			min = 0;
			sec = time;
		}
		System.out.println("min: " + min + " sec: " + sec);
		if ((min < 10) && (sec < 10)) {
			s = "0" + String.valueOf(min) + ":0" + String.valueOf(sec);
		} else if (min < 10) {
			s = "0" + String.valueOf(min) + ":" + String.valueOf(sec);
		} else if (sec < 10) {
			s = String.valueOf(min) + ":0" + String.valueOf(sec);
		} else {
			s = String.valueOf(min) + ":" + String.valueOf(sec);
		}
		this.frame.getVocabeltestPanel().getTimerLabel().setText("Übrige Zeit: " + String.valueOf(s));
	}

	public void stopTimer() {
		System.out.println("stopTimer");
		this.setStopper(true);
	}

	public void setTimer(int starttimeMin, int starttimeSec) {
		counterValue = (starttimeMin * 60) + starttimeSec;
	}

	public boolean isStopper() {
		return this.stopper;
	}

	public void setStopper(boolean stopper) {
		System.out.println("setStopperw	");
		this.stopper = stopper;
	}

	public static int getCounterValue() {
		return counterValue;
	}

}
