package NewGui;

import javax.swing.Icon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public abstract class CustomLabel extends JLabel {

	public CustomLabel() {}

	public CustomLabel(String text) {
		super(text);
	}

	public CustomLabel(Icon image) {
		super(image);
	}

	public CustomLabel(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
	}

	public CustomLabel(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
	}

	public CustomLabel(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
	}

}
