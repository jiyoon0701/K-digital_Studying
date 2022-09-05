package chap8;

class LazerZet implements Printerable {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("레이터 printer로 출력");
	}
	
}

class InkZet implements Printerable {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("잉크젯 printer로 출력");
	}
	
}

class PrinterManager {
	public static Printerable getPrinter(String type) {
		if(type.equals("INK")) return new InkZet();
		else return new LazerZet();
	}
}

public class interfaceEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Printerable a = PrinterManager.getPrinter("INK");
		a.print();
	}

}
