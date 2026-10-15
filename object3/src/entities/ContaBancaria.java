package entities;

public class ContaBancaria {
		public String titular;
		public double saldo;
		
		public void depositar(double valor) {
			saldo += valor;
		}
		
		public boolean sacar(double valor) {
		    if (valor <= saldo) {
		        saldo -= valor; 
		        return true;
		    } else {
		        return false; 
		    }
		}
		
		
		@Override
		public String toString() {
			return "Titular: " + titular + "| Saldo Atual: R$ " + String.format("%.2f",saldo);
		}
}	
