package IO;
import java.io.IOException;
import java.util.Scanner;

public final class Console {
	
	private static Scanner sc = new Scanner(System.in);
	private static final String HORIZ = "============================================================================";
	private static final int CONSOLE_WIDTH = HORIZ.length();

	private Console() {
		throw new AssertionError();
	}
	public static void put(String out) {
		System.out.println(out);
	}
	public static void put() {
		System.out.println();
	}
	public static void write(String out) {
		String first = "| " + out;
		put(pad(first) + "|");
	}
	public static void writeNoNew(String out) {
		String first = "| " + out;
		System.out.print(first);

	}
	public static void write() {
		write("");
	}
	
	public static void putHoriz() {
		put(HORIZ);
	}
	public static String pad(String out) {
		int pad = CONSOLE_WIDTH - out.length();
		StringBuilder padding = new StringBuilder(out);
		for (int i = 0; i < pad - 1; i++) {
			padding.append(" ");
		}
		return padding.toString();
	}
	public static void writeCenter(String out) {
		StringBuilder frontPad = new StringBuilder();
		int front = (CONSOLE_WIDTH - out.length()) / 2;
		for (int i = 0; i < front; i++) {
			frontPad.append(" ");
		}
		put(pad("|" + frontPad.toString() +  out) + "|");
	}	
	public static String getInput() {
		String in = sc.nextLine();
		return in;
	}
	
	public static String prompt(String out) {
		writeNoNew(out);
		String in = sc.nextLine();
		return in;
	}
	
	
	
}

