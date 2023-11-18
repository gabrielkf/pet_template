//Item 3 (TROCAR ESSA CLASSE PELA SUA)
public class MinhaImagemAnimada extends ImagemAnimada {

	private Thread t = new Thread(this);
	
	public MinhaImagemAnimada() {
		t.start();
	}
	
	@Override
	public void run() {
		 while(true) {
			 this.setX(this.getX() + 10);
			 try {
				 t.sleep(500);
			 } catch (InterruptedException e) {
				 e.printStackTrace();
			 }
		  }
	}
	
}
