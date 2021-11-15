package common;

public class ValidationTextHelper {
    static String elementDisplayed(String name) {
        return "'" + name + "'" + " must be displayed.";
    }
	public static String elementHidden(String name) {
		return "'" + name + "'" + " must be hidden.";
	}
    static String elementClicked(String name) {
        return "'" + name + "'" + " must be clicked.";
    }
	static String elementTypeText(String name) {
		return "'" + name + "'" + " text must be entered.";
	}
	static String stringEqual(String actual, String expected) {
		return "'" + actual + "'" + " and " + "'" + expected + "'" + " texts must be equal.";
	}
	static String stringNotEqual(String actual, String expected) {
		return "'" + actual + "'" + " and " + "'" + expected + "'" + " texts must be not equal.";
	}	
	public static String elementHoverOver(String name) {
		return "'" + name + "'" + " mouse hover over must work.";
	}
	public static String elementHoverOverAndClick(String name) {
		return "'" + name + "'" + " mouse hover over and click must work.";
	}
}
