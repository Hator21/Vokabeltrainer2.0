package Components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import NewGui.MainFrame;

public class TimerLabel {

	private MainFrame		frame;
	private static int		counterValue;
	private static Timer	timer;
	private static int		min, sec;

	public TimerLabel(MainFrame frame, int starttimeMin, int starttimeSec) {
		this.frame = frame;

		this.counterValue = starttimeMin * 60 + starttimeSec;

	}

	public void startTimer() {
		TimerLabel.timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimerLabel.counterValue--;

				printTimer(counterValue);

				if (TimerLabel.counterValue == 0) {
					System.out.println("Counterdown ausgelaufen!");

					TimerLabel.timer.stop();
				}
			}
		});
		timer.start();
	}

	public void printTimer(int time) {
		String s;
		if (time > 60) {
			min = time / 60;
			sec = time % 60;
		}
		if (min < 10 && sec < 10)
			s = "0" + String.valueOf(min) + ":0" + String.valueOf(sec);
		else if (min < 10)
			s = "0" + String.valueOf(min) + ":" + String.valueOf(sec);
		else if (min < 10)
			s = String.valueOf(min) + ":0" + String.valueOf(sec);
		else
			s = String.valueOf(min) + ":" + String.valueOf(sec);
		frame.getHeadingbar().getHeadingLabelR().setText(String.valueOf(s));
	}
}
