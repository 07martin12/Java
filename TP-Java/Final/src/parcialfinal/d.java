package parcialfinal;

public class d {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = -1;
		int y = 3;
		
		computar (x,y);
		
		
	}
	
	public static void computar (int x, int y) {
		boolean noTermina = true;
		
		while (noTermina) {
			if (x%y==0) {
				noTermina = x <=y;
				x += y;
			} 
			else 
				x++; 
		System.out.print(x);
		}
		
	}

}
