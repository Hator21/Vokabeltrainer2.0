package NewGui;

import java.awt.Color;
import java.awt.Component;
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
	private Random				random		= new Random();
	private String				pr�1, pr�2;
	private ArrayList<Integer>	usedIndex	= new ArrayList<Integer>();
	private int					a			= 0;
	Vokabel						v			= null;
	private TransparentButton	nextButton;

	public SpellingPanel(MainFrame frame) {
		this.setFrame(frame);
		this.setLayout(null);
		this.setBounds(251, 75, 1028, 644);
		try {
			this.image = ImageIO.read(new File("img/internalLection.png"));
		} catch (IOException ex) {}
		createLabel();
		createButton();
		setNextButton((TransparentButton.createButton("Weiter", 115, 470, 200, 50, 20, 0, (e -> {
			for (Component c : this.getComponents()) {
				if (!((TransparentButton) (e.getSource())).equals(c))
					this.remove(c);
			}
			this.revalidate();
			createButton();
			createLabel();
			setButtonTexts(pr�1, pr�2);
			this.repaint();

		}), this)));
		frame.getButtons().add(getNextButton());
		createHelp();
	}

	public void createLabel() {
		setVocabel(TransparentLabel.createLabel("Vokabel", 115, 300, 200, 50, 20, this));
		setInfoLabel(TransparentLabel.createLabel("Wie wird das denn nun geschrieben?!", 10, 50, 500, 50, 30, this));
		frame.getLabels().add(getVocabel());
		frame.getLabels().add(getInfoLabel());
	}

	public void createButton() {
		setVoc1(TransparentButton.createButton("Vokabell", 10, 360, 200, 50, 20, 0, new Color(10, 10, 10, 20), (e -> {
			System.out.println("Voc1");
			if (getVoc1().getText().equalsIgnoreCase(v.getVocabTranslation()))
				getVoc1().setBackgroundColor(Color.GREEN);
			else
				getVoc1().setBackgroundColor(Color.RED);
			this.repaint();
		}), this));
		frame.getButtons().add(getVoc1());
		setVoc2(TransparentButton.createButton("Vukabel", 220, 360, 200, 50, 20, 0, new Color(10, 10, 10, 20), (e -> {
			System.out.println("Voc2");
			if (getVoc2().getText().equalsIgnoreCase(v.getVocabTranslation()))
				getVoc2().setBackgroundColor(Color.GREEN);
			else
				getVoc2().setBackgroundColor(Color.RED);
			this.repaint();
		}), this));
		frame.getButtons().add(getVoc2());
		setVoc3(TransparentButton.createButton("Vokabel", 10, 410, 200, 50, 20, 0, new Color(10, 10, 10, 20), (e -> {
			System.out.println("Voc3");
			if (getVoc3().getText().equalsIgnoreCase(v.getVocabTranslation()))
				getVoc3().setBackgroundColor(Color.GREEN);
			else
				getVoc3().setBackgroundColor(Color.RED);
			this.repaint();
		}), this));
		frame.getButtons().add(getVoc3());
		setVoc4(TransparentButton.createButton("Vukabell", 220, 410, 200, 50, 20, 0, new Color(10, 10, 10, 20), (e -> {
			System.out.println("Voc4");
			if (getVoc4().getText().equalsIgnoreCase(v.getVocabTranslation()))
				getVoc4().setBackgroundColor(Color.GREEN);
			else
				getVoc4().setBackgroundColor(Color.RED);
			this.repaint();
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
		voc = voc.toLowerCase();
		voc = voc.replaceAll("\\s+", "");
		System.err.println(voc);
		boolean b = false;
		Point p = null;
		int index = 0;
		int number = 0;
		List<Character> chars = voc.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
		ArrayList<Point> numbers = retNumberOfUsefullManipulation(chars);
		for (Point p1 : numbers)
			System.out.println("-> " + p1.getX());
		while (a < numbers.size()) {
			p = numbers.get(a);
			if (usedIndex.size() > 0)
				for (int i : usedIndex)
					if (p.getX() == i)
						b = true;
			if (b == false) {
				index = (int) p.getY();
				number = (int) p.getX();
				break;
			}
			a++;
		}
		System.out.println("here");
		usedIndex.add(number);
		switch (number) {
			case 1:
				chars.set(index, 'e');
				chars.set(index + 1, 'i');
				break;
			case 2:
				chars.set(index, 'p');
				break;
			case 3:
				chars.remove(index);
				break;
			case 4:
				chars.set(index, 'k');
				break;
			case 5:
				chars.set(index, 't');
				break;
			case 6:
				chars.set(index, 'a');
				chars.set(index + 1, 'y');
				break;
			case 7:
				chars.set(index, 'a');
				chars.remove(index + 1);
				break;
			case 8:
				chars.set(index, 'y');
				chars.remove(index + 1);
				break;
			case 9:
				chars.set(index, 'v');
				break;
			case 10:
				chars.add(index + 1, 'f');
				break;
			case 11:
				chars.set(index, 'j');
				break;
			case 12:
				chars.remove(index);
				break;
			case 13:
				chars.set(index, 'y');
				break;
			case 14:
				chars.set(index, 'g');
				break;
			case 15:
				chars.set(index, 'q');
				break;
			case 16:
				chars.set(index, 'c');
				break;
			case 17:
				chars.add(index + 1, 'l');
				break;
			case 18:
				chars.remove(index + 1);
				break;
			case 19:
				chars.add(index + 1, 'm');
				break;
			case 20:
				chars.add(index + 1, 'n');
				break;
			case 21:
				chars.set(index, 'u');
				break;
			case 22:
				chars.set(index, 'b');
				break;
			case 23:
				chars.set(index, 'k');
				break;
			case 24:
				break;
			case 25:
				chars.set(index, 'z');
				break;
			case 26:
				chars.set(index, 'd');
				break;
			case 27:
				chars.set(index, 'o');
				break;
			case 28:
				chars.set(index, 'f');
				break;
			case 29:
				chars.set(index, 'v');
				break;
			case 30:
				break;
			case 31:
				chars.set(index, 'i');
				break;
			case 32:
				chars.set(index, 'c');
				break;
			case 33:
				chars.set(index, 'a');
				break;
			case 34:
				chars.set(index, 'e');
				break;
		}
		System.out.println("down");
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
			if (index < chars.size() - 1)
				if (chars.get(index + 1) == 'y') {
					numbers.add(new Point(1, index)); // ay->ei
				} else
					numbers.add(new Point(34, index));
		}
		if (chars.contains('b')) {
			index = chars.indexOf('b');
			if (index < chars.size() - 1 && index > 0) {
				if (chars.get(index - 1) != 'b' || chars.get(index + 1) != 'b')
					numbers.add(new Point(2, index)); // b->p
			}
		}
		if (chars.contains('c')) {
			index = chars.indexOf('c');
			if (index < chars.size() - 1 && index > 0) {
				if (chars.get(index - 1) == 's' && chars.get(index + 1) == 'h')
					numbers.add(new Point(3, index));// c->remove
				if (chars.get(index - 1) != 's' && chars.get(index + 1) != 'h')
					numbers.add(new Point(4, index)); // c->k
			}

		}
		if (chars.contains('d')) {
			index = chars.indexOf('d');
			numbers.add(new Point(5, index)); // d->t
		}
		if (chars.contains('e')) {
			index = chars.indexOf('e');
			if (index < chars.size() - 1) {
				if (chars.get(index + 1) == 'i') {
					numbers.add(new Point(6, index)); // ei->ay
					numbers.add(new Point(7, index)); // ei->a
				}
			}
			if (index > 0) {
				if (chars.get(index - 1) == 'i')
					numbers.add(new Point(8, index - 1)); // ie->y
				else
					numbers.add(new Point(33, index)); // e -> a
			}
			numbers.add(new Point(35, index));
		}
		if (chars.contains('f')) {
			index = chars.indexOf('f');
			if (index < chars.size() - 1 && index > 0) {
				if (chars.get(index - 1) != 'f' || chars.get(index + 1) != 'f') {
					numbers.add(new Point(9, index)); // f->v
					numbers.add(new Point(10, index)); // f->ff
				}
			}
		}
		if (chars.contains('g')) {
			index = chars.indexOf('g');
			numbers.add(new Point(11, index)); // g->j
		}
		if (chars.contains('h')) {
			index = chars.indexOf('e');
			if (index > 1) {
				if (chars.get(index - 1) != 'c' && chars.get(index - 2) != 's')
					numbers.add(new Point(12, index)); // remove h
			}
		}
		if (chars.contains('i')) {
			index = chars.indexOf('i');
			if (index < chars.size() - 1 && index > 0) {
				if (chars.get(index + 1) != 'e' && chars.get(index - 1) != 'e')
					numbers.add(new Point(13, index)); // i->y
			}
		}
		if (chars.contains('j')) {
			index = chars.indexOf('j');
			numbers.add(new Point(14, index)); // j->g
		}
		if (chars.contains('k')) {
			index = chars.indexOf('k');
			if (index < chars.size() - 1) {
				if (chars.get(index + 1) == 'u')
					numbers.add(new Point(15, index)); // ku -> qu
				else
					numbers.add(new Point(16, index)); // k -> c
			}
		}
		if (chars.contains('l')) {
			index = chars.indexOf('l');
			if (chars.get(index - 1) != 'l' || chars.get(index + 1) != 'l')
				numbers.add(new Point(17, index)); // l->ll
			else if (chars.get(index + 1) == 'l')
				numbers.add(new Point(18, index)); // ll->l
		}
		if (chars.contains('m')) {
			index = chars.indexOf('m');
			numbers.add(new Point(19, index)); // m->mm
		}
		if (chars.contains('n')) {
			index = chars.indexOf('n');
			numbers.add(new Point(20, index)); // n ->nn
		}
		if (chars.contains('o')) {
			index = chars.indexOf('o');
			numbers.add(new Point(21, index)); // o -> u
		}
		if (chars.contains('p')) {
			index = chars.indexOf('p');
			numbers.add(new Point(22, index)); // p->b
		}
		if (chars.contains('q')) {
			index = chars.indexOf('q');
			numbers.add(new Point(23, index)); // q->k
		}
		if (chars.contains('r')) {
			index = chars.indexOf('r');
		}
		if (chars.contains('s')) {
			index = chars.indexOf('s');
			if (index < chars.size() - 1 && index > 1) {
				if (chars.get(index + 1) != 'c' && chars.get(index + 2) != 'h' || chars.get(index + 1) != 'h')
					numbers.add(new Point(25, index));
			}
			numbers.add(new Point(25, index));// s->z
		}
		if (chars.contains('t')) {
			index = chars.indexOf('t');
			numbers.add(new Point(26, index));// t->d
		}
		if (chars.contains('u')) {
			index = chars.indexOf('u');
			numbers.add(new Point(27, index)); // u -> o
		}
		if (chars.contains('v')) {
			index = chars.indexOf('v');
			numbers.add(new Point(28, index)); // v->f
		}
		if (chars.contains('w')) {
			index = chars.indexOf('w');
			numbers.add(new Point(29, index)); // w->v
		}
		if (chars.contains('x')) {
			index = chars.indexOf('x');
		}
		if (chars.contains('y')) {
			index = chars.indexOf('y');
			numbers.add(new Point(31, index)); // y -> i
		}
		if (chars.contains('z')) {
			index = chars.indexOf('z');
			numbers.add(new Point(32, index)); // z->c
		}
		return numbers;
	}

	public void setButtonTexts(String pr�1, String pr�2) {
		this.pr�1 = pr�1;
		this.pr�2 = pr�2;
		int rnd2 = zufallszahl(0, this.frame.getTestVokabeln().size() - 1);
		v = frame.getTestVokabeln().get(rnd2);
		System.out.println(v);
		System.out.println(getVocabel());
		getVocabel().setText(v.getVocabOrigin());
		if (v.getVocabTranslation().length() < 3) {
			int randomButton = zufallszahl(1, 2);
			getVoc3().setVisible(false);
			getVoc4().setVisible(false);
			switch (randomButton) {
				case 1:
					getVoc1().setText(v.getVocabTranslation());
					getVoc2().setText(generateVocabel(v.getVocabTranslation()));

					break;
				case 2:
					getVoc1().setText(generateVocabel(v.getVocabTranslation()));
					getVoc2().setText(v.getVocabTranslation());

					break;
				default:
					System.out.println("fail");
					break;

			}
		}
		if (v.getVocabTranslation().length() < 5 && v.getVocabTranslation().length() >= 3) {
			int randomButton = zufallszahl(1, 3);
			getVoc3().setVisible(true);
			getVoc4().setVisible(false);
			switch (randomButton) {
				case 1:
					getVoc1().setText(v.getVocabTranslation());
					getVoc2().setText(generateVocabel(v.getVocabTranslation()));
					getVoc3().setText(generateVocabel(v.getVocabTranslation()));
					break;
				case 2:
					getVoc1().setText(generateVocabel(v.getVocabTranslation()));
					getVoc2().setText(v.getVocabTranslation());
					getVoc3().setText(generateVocabel(v.getVocabTranslation()));
					break;
				case 3:
					getVoc1().setText(generateVocabel(v.getVocabTranslation()));
					getVoc2().setText(generateVocabel(v.getVocabTranslation()));
					getVoc3().setText(v.getVocabTranslation());
					break;
				default:
					System.out.println("fail");
					break;

			}
		}
		if (v.getVocabTranslation().length() >= 5) {
			int randomButton = zufallszahl(1, 4);
			getVoc3().setVisible(true);
			getVoc4().setVisible(true);
			switch (randomButton) {
				case 1:
					getVoc1().setText(v.getVocabTranslation());
					getVoc2().setText(generateVocabel(v.getVocabTranslation()));
					getVoc3().setText(generateVocabel(v.getVocabTranslation()));
					getVoc4().setText(generateVocabel(v.getVocabTranslation()));
					break;
				case 2:
					getVoc1().setText(generateVocabel(v.getVocabTranslation()));
					getVoc2().setText(v.getVocabTranslation());
					getVoc3().setText(generateVocabel(v.getVocabTranslation()));
					getVoc4().setText(generateVocabel(v.getVocabTranslation()));
					break;
				case 3:
					getVoc1().setText(generateVocabel(v.getVocabTranslation()));
					getVoc2().setText(generateVocabel(v.getVocabTranslation()));
					getVoc3().setText(v.getVocabTranslation());
					getVoc4().setText(generateVocabel(v.getVocabTranslation()));
					break;
				case 4:
					getVoc1().setText(generateVocabel(v.getVocabTranslation()));
					getVoc2().setText(generateVocabel(v.getVocabTranslation()));
					getVoc3().setText(generateVocabel(v.getVocabTranslation()));
					getVoc4().setText(v.getVocabTranslation());
					break;
				default:
					System.out.println("fail");
					break;

			}
		}
		System.out.println("readyToClick");
		a = 0;
		usedIndex.clear();
	}

	public TransparentButton getNextButton() {
		return nextButton;
	}

	public void setNextButton(TransparentButton nextButton) {
		this.nextButton = nextButton;
	}

	public void createHelp() {
		frame.getHelper().add(TransparentLabel.createLabel("1. Klicke auf die richtig geschriebene Vokabel!", 10, 250, 400, 30, 18, this));
		frame.getHelper().add(TransparentLabel.createLabel("2. Klicke auf \"Weiter\" f�r die n�chste Vokabel!", 15, 530, 400, 30, 18, this));
	}
}
