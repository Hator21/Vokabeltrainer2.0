package NewGui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Components.TransparentButton;
import Components.TransparentLabel;
import Trainer.Vokabel;

@SuppressWarnings("serial")
public class SpellingPanel extends JPanel {
	private MainFrame			frame;
	private BufferedImage		image;
	private TransparentLabel	vocabel, infoLabel;
	private TransparentButton	voc1, voc2, voc3, voc4;
	Random						random	= new Random();

	public SpellingPanel(MainFrame frame) {
		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);
		try {
			this.image = ImageIO.read(new File("img/internalLection.png"));
		} catch (IOException ex) {}
		createLabel();
		createButton();
	}

	public void createLabel() {
		setVocabel(TransparentLabel.createLabel("Vokabel", 115, 300, 200, 50, 20, this));
		setInfoLabel(TransparentLabel.createLabel("Wie wird das denn nun geschrieben?!", 10, 50, 500, 50, 30, this));
		frame.getLabels().add(getVocabel());
		frame.getLabels().add(getInfoLabel());
	}

	public void createButton() {
		setVoc1(TransparentButton.createButton("Vokabell", 10, 360, 200, 50, 20, 0, new Color(10, 10, 10, 20), (e -> {

		}), this));
		frame.getButtons().add(getVoc1());
		setVoc2(TransparentButton.createButton("Vukabel", 220, 360, 200, 50, 20, 0, new Color(10, 10, 10, 20), (e -> {

		}), this));
		frame.getButtons().add(getVoc2());
		setVoc3(TransparentButton.createButton("Vokabel", 10, 410, 200, 50, 20, 0, new Color(10, 10, 10, 20), (e -> {

		}), this));
		frame.getButtons().add(getVoc3());
		setVoc4(TransparentButton.createButton("Vukabell", 220, 410, 200, 50, 20, 0, new Color(10, 10, 10, 20), (e -> {

		}), this));
		frame.getButtons().add(getVoc4());
	}

	@Override
	public void paintComponent(Graphics g_) {
		super.paintComponent(g_);
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawImage(this.image, 0, 0, null);
	}

	public MainFrame getFrame() {
		return frame;
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	public TransparentLabel getVocabel() {
		return vocabel;
	}

	public void setVocabel(TransparentLabel vocabel) {
		this.vocabel = vocabel;
	}

	public TransparentLabel getInfoLabel() {
		return infoLabel;
	}

	public void setInfoLabel(TransparentLabel infoLabel) {
		this.infoLabel = infoLabel;
	}

	public TransparentButton getVoc1() {
		return voc1;
	}

	public void setVoc1(TransparentButton voc1) {
		this.voc1 = voc1;
	}

	public TransparentButton getVoc2() {
		return voc2;
	}

	public void setVoc2(TransparentButton voc2) {
		this.voc2 = voc2;
	}

	public TransparentButton getVoc3() {
		return voc3;
	}

	public void setVoc3(TransparentButton voc3) {
		this.voc3 = voc3;
	}

	public TransparentButton getVoc4() {
		return voc4;
	}

	public void setVoc4(TransparentButton voc4) {
		this.voc4 = voc4;
	}

	public String generateVocabel(String vocabel) {
		String voc = vocabel;
		int whileCounter = 0;
		int index = 0;
		boolean ouBoolean = false;
		int removeDoubleIndex = 0;
		boolean containsDoubleL = false;
		boolean containsH = false;
		boolean EreEar = false;
		boolean iei = false;
		boolean notAllowedToUse = false;
		List<Character> chars = voc.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
		int randomCount = zufallszahl(1, 3);
		while (whileCounter < randomCount) {

			switch (index) {
				case 1:
					if (containsDoubleL == false) {
						if (chars.contains('l')) {
							index = chars.indexOf('l');
							chars.add((index + 1), 'l');
							removeDoubleIndex = index + 1;
						}
					} else
						notAllowedToUse = true;
					break;
				case 2:
					if (ouBoolean == false) {
						if (chars.contains('o')) {
							index = chars.indexOf('o');
							chars.add((index + 1), 'u');
							ouBoolean = true;
						}
					} else
						notAllowedToUse = true;
					break;
				case 3:
					if (ouBoolean == false) {
						if (chars.contains('o')) {
							index = chars.indexOf('o');
							chars.set((index), 'u');
							ouBoolean = true;
						}
					} else
						notAllowedToUse = true;
					break;
				case 4:
					if (ouBoolean == false) {
						if (chars.contains('u')) {
							index = chars.indexOf('u');
							chars.set((index), 'o');
							ouBoolean = true;
						}
					} else
						notAllowedToUse = true;
					break;
				case 5:
					if (EreEar == false) {
						if (chars.contains('e') && chars.contains('r')) {
							for (int i = 0; i < chars.size() - 2; i++) {
								if (chars.get(i) == 'e' && chars.get(i + 1) == 'r' && chars.get(i + 2) == 'e') {
									chars.set((i + 1), 'a');
									chars.set((i + 2), 'r');
									EreEar = true;
								}
							}
						}
					} else
						notAllowedToUse = true;
					break;
				case 6:
					if (containsH == false) {
						if (chars.contains('t')) {
							index = chars.indexOf('t');
							chars.add((index + 1), 'h');
							containsH = true;
						}
					} else
						notAllowedToUse = true;
					break;
				case 7:
					if (chars.contains('s') && chars.contains('h')) {
						for (int i = 0; i < chars.size() - 1; i++) {
							if (chars.get(i) == 's' && chars.get(i + 1) == 'h') {
								chars.add((i + 1), 'c');

							}
						}
					}
					break;
				case 8:
					if (chars.contains('s') && chars.contains('c') && chars.contains('h')) {
						for (int i = 0; i < chars.size() - 2; i++) {
							if (chars.get(i) == 's' && chars.get(i + 1) == 'c' && chars.get(i + 2) == 'h') {
								chars.remove((i + 1));

							}
						}
					}
					break;
				case 9:
					for (int i = removeDoubleIndex; i < chars.size() - 1; i++) {
						if (chars.get(i) == chars.get(i + 1)) {
							chars.remove((i + 1));
							removeDoubleIndex = i;
							if (chars.get(i) == 'l')
								containsDoubleL = true;
						} else
							notAllowedToUse = true;
					}
					break;
				case 10:
					if (containsH == false) {
						if (chars.contains('h')) {
							index = chars.indexOf('h');
							if (index > 0)
								if (chars.get(index - 1) != 's' || chars.get(index - 1) != 'c' || chars.get(index - 1) != 't') {
									chars.remove(index);
									containsH = true;
								}
						}
					} else
						notAllowedToUse = true;
					break;
				case 11:
					if (iei == false) {
						if (chars.contains('i')) {
							index = chars.indexOf('i');
							if (index < chars.size() - 1) {
								if (chars.get(index + 1) != 'e') {
									chars.add(index + 1, 'e');
									iei = true;
								}
							} else {
								chars.add(index + 1, 'e');
								iei = true;
							}
						}
					} else
						notAllowedToUse = true;
					break;
				case 12:
					if (iei == false) {
						if (chars.contains('i') && chars.contains('e')) {
							for (int i = 0; i < chars.size() - 1; i++) {
								if (chars.get(i) == 'i' && chars.get(i + 1) == 'e') {
									chars.remove(i + 1);
									iei = true;
								}
							}
						}
					} else
						notAllowedToUse = true;
					break;
				case 13:
					if (EreEar == false) {
						if (chars.contains('e') && chars.contains('r') && chars.contains('a')) {
							for (int i = 0; i < chars.size() - 2; i++) {
								if (chars.get(i) == 'e' && chars.get(i + 1) == 'a' && chars.get(i + 2) == 'r') {
									chars.set((i + 1), 'r');
									chars.set((i + 2), 'e');
									EreEar = true;
								}
							}
						}
					} else
						notAllowedToUse = true;
					break;
				case 14:
					if (chars.contains('y')) {
						index = chars.indexOf('y');
						chars.set(index, 'i');

					} else
						notAllowedToUse = true;
					break;
				case 15:
					if (chars.contains('w')) {
						index = chars.indexOf('w');
						chars.set(index, 'v');

					} else
						notAllowedToUse = true;
					break;
				case 16:
					if (chars.contains('f')) {
						index = chars.indexOf('f');
						chars.set(index, 'v');

					} else
						notAllowedToUse = true;
					break;
				case 17:
					chars.set(index, 'v');
					break;
				case 18:
					chars.remove(index);
					break;
				case 19:
					chars.set(index, 'z');
					break;
				case 20:
					chars.set(index, 'e');
					chars.set(index + 1, 'i');
					break;
			}
			if (!notAllowedToUse)
				whileCounter++;
		}

		return chars.stream().map(e -> e.toString()).reduce((acc, e) -> acc + e).get();
	}

	public int zufallszahl(int min, int max) {
		return this.random.nextInt((max - min) + 1) + min;
	}

	public ArrayList<Point> retNumberOfUsefullManipulation(List<Character> chars) {
		ArrayList<Point> numbers = new ArrayList<Point>();
		int index = 0;
		if (chars.contains('a')) {
			index = chars.indexOf('a');
			if (chars.get(index + 1) == 'y')
				numbers.add(new Point(20, index));
		}
		if (chars.contains('b')) {
			index = chars.indexOf('b');
			if (chars.get(index - 1) != 'b' || chars.get(index + 1) != 'b')
				numbers.add(new Point(16, index));
		}
		if (chars.contains('c')) {
			index = chars.indexOf('c');
			if (chars.get(index - 1) == 's' && chars.get(index + 1) == 'h')
				numbers.add(new Point(17, index));
			if (chars.get(index - 1) != 's' && chars.get(index + 1) != 'h')
				numbers.add(new Point(17, index));

		}
		if (chars.contains('d')) {
			index = chars.indexOf('e');
		}
		if (chars.contains('e')) {
			index = chars.indexOf('e');
			// if(chars.get(index-1) == 'i')
			// numbers.
		}
		if (chars.contains('f')) {
			index = chars.indexOf('f');
			if (chars.get(index - 1) != 'f' || chars.get(index + 1) != 'f')
				numbers.add(new Point(16, index));
		}
		if (chars.contains('g')) {
			index = chars.indexOf('e');
		}
		if (chars.contains('h')) {
			index = chars.indexOf('e');
		}
		if (chars.contains('i')) {
			index = chars.indexOf('i');
			if (chars.get(index + 1) == 'e')
				numbers.add(new Point(2, index + 1));
		}
		if (chars.contains('j')) {
			index = chars.indexOf('e');
		}
		if (chars.contains('k')) {
			index = chars.indexOf('e');
		}
		if (chars.contains('l')) {
			index = chars.indexOf('l');
			if (chars.get(index - 1) != 'l' || chars.get(index + 1) != 'l')
				numbers.add(new Point(1, index));
			else if (chars.get(index - 1) == 'l')
				numbers.add(new Point(9, index - 1));
			else if (chars.get(index + 1) == 'l')
				numbers.add(new Point(9, index));
		}
		if (chars.contains('m')) {
			index = chars.indexOf('e');
		}
		if (chars.contains('n')) {
			index = chars.indexOf('e');
		}
		if (chars.contains('o')) {
			index = chars.indexOf('e');
		}
		if (chars.contains('p')) {
			index = chars.indexOf('e');
		}
		if (chars.contains('q')) {
			index = chars.indexOf('e');
		}
		if (chars.contains('r')) {
			index = chars.indexOf('e');
		}
		if (chars.contains('s')) {
			index = chars.indexOf('e');
		}
		if (chars.contains('t')) {
			index = chars.indexOf('e');
		}
		if (chars.contains('u')) {
			index = chars.indexOf('e');
		}
		if (chars.contains('v')) {
			index = chars.indexOf('e');
		}
		if (chars.contains('w')) {
			index = chars.indexOf('e');
		}
		if (chars.contains('x')) {
			index = chars.indexOf('e');
		}
		if (chars.contains('y')) {
			index = chars.indexOf('e');
		}
		if (chars.contains('z')) {
			index = chars.indexOf('e');
		}
		return numbers;
	}

//	public void setButtonTexts() {
//		Vokabel v = frame.getCheck().vok(1).get(0);
//		System.out.println(v);
//		System.out.println(getVocabel());
//		getVocabel().setText(v.getVocabOrigin());
//		int randomButton = zufallszahl(1, 4);
//		switch (randomButton) {
//			case 1:
//				getVoc1().setText(v.getVocabTranslation());
//				getVoc2().setText(generateVocabel(v.getVocabTranslation()));
//				getVoc3().setText(generateVocabel(v.getVocabTranslation()));
//				getVoc4().setText(generateVocabel(v.getVocabTranslation()));
//				break;
//			case 2:
//				getVoc1().setText(generateVocabel(v.getVocabTranslation()));
//				getVoc2().setText(v.getVocabTranslation());
//				getVoc3().setText(generateVocabel(v.getVocabTranslation()));
//				getVoc4().setText(generateVocabel(v.getVocabTranslation()));
//				break;
//			case 3:
//				getVoc1().setText(generateVocabel(v.getVocabTranslation()));
//				getVoc2().setText(generateVocabel(v.getVocabTranslation()));
//				getVoc3().setText(v.getVocabTranslation());
//				getVoc4().setText(generateVocabel(v.getVocabTranslation()));
//				break;
//			case 4:
//				getVoc1().setText(generateVocabel(v.getVocabTranslation()));
//				getVoc2().setText(generateVocabel(v.getVocabTranslation()));
//				getVoc3().setText(generateVocabel(v.getVocabTranslation()));
//				getVoc4().setText(v.getVocabTranslation());
//				break;
//			default:
//				System.out.println("fail");
//				break;
//
//		}
//	}
}
