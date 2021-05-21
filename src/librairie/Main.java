package librairie;

public class Main {

	public static void main(String[] args) {
		
		try {
			GUI window = new GUI();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
