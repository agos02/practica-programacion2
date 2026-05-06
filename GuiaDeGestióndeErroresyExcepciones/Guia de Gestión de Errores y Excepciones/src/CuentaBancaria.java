//Ejercicio 3.1
public class CuentaBancaria{
        double saldo;
    public CuentaBancaria(double saldo){
        this.saldo = saldo;
    }

    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= saldo){
            saldo = saldo - monto;
        }
        else if(monto > saldo){
            throw new SaldoInsuficienteException("El saldo de la cuenta bancaria es insuficiente!");
        }
    }
}
