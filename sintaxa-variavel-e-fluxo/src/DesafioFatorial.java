
public class DesafioFatorial {
	public static void main(String[] args) {
		for(int n=0; n<=10; n++) {
			if(n==0) {
				int fatorial = 1;
				System.out.println("fatorial de " + n + " é " + fatorial);
			}
			else {
				int fatorial=1;
				for(int i=1; i<=n; i++) {
					fatorial = fatorial * i;
				}
				System.out.println("fatorial de " + n + " é " + fatorial);
			}
		}
	}
}
