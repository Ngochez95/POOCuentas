package bancoapoo;

import javax.swing.JOptionPane;

public class Cuenta {

    private String Cuentas[][];
    private int contador;
    private String salida;

    public Cuenta() {
        this.Cuentas = new String[25][4];
        this.contador = 0;
        this.salida = "";
    }

    public void CrearCuenta(String nombre, String saldo, String contrasenia) {
        for (int fila = 0; fila < 25; fila++) {
            for (int columna = 0; columna < 4; columna++) {
                if (Cuentas[fila][columna] == null) {
                    Cuentas[fila][0] = "sin asignar";
                    Cuentas[fila][1] = "sin asignar";
                    Cuentas[fila][2] = "0.0";
                    Cuentas[fila][3] = "sin historial";
                }
            }
        }
        if (!nombre.isEmpty() && Double.parseDouble(saldo) > 0 && !contrasenia.isEmpty()) {
            this.Cuentas[contador][0] = nombre;
            this.Cuentas[contador][1] = contrasenia;
            this.Cuentas[contador][2] = saldo;
            this.Cuentas[contador][3] = "Apertura de cuenta";
            this.contador++;

        } else if (Double.parseDouble(saldo) < 0) {
            JOptionPane.showMessageDialog(null, "Saldo inicial debe de ser mayor a cero");
        }
    }

    public String MostrarCuenta() {
        salida += "Nombre\tContraseña\tSaldo\thistorial\n";
        for (int fila = 0; fila < 25; fila++) {

            if (!this.Cuentas[fila][1].equals("sin asignar")) {
                this.salida += this.Cuentas[fila][0] + "\t";
                this.salida += "*****\t";
                this.salida += this.Cuentas[fila][2] + "\t";
                this.salida += this.Cuentas[fila][3] + "\t";

            }
            this.salida += "\n";
        }

        return this.salida;

    }

    public String mostrarSaldo(String user, String contra) {
        for (int fila = 0; fila < 25; fila++) {
            if (Cuentas[fila][0].equals(user) && Cuentas[fila][1].equals(contra)) {
                return "saldo del usuario " + Cuentas[fila][0] + " es: $" + Cuentas[fila][2];
            }
        }
        return "Error, usuario y contraseña no coinciden";
    }

    public boolean verificarUsuario(String user, String contra) {
        for (int fila = 0; fila < 25; fila++) {
            if (Cuentas[fila][0].equals(user) && Cuentas[fila][1].equals(contra)) {
                return true;
            }
        }
        return false;
    }

    public void ingresoEfectivo(String user, String contra, String efectivo) {
        for (int fila = 0; fila < 25; fila++) {
            if (Cuentas[fila][0].equals(user) && Cuentas[fila][1].equals(contra)) {
                Cuentas[fila][2] = String.valueOf(Double.parseDouble(Cuentas[fila][2]) + Double.parseDouble(efectivo));
                Cuentas[fila][3] = "Ingresó la suma de: $" + efectivo;
            }
        }
    }

    public void retiroEfectivo(String user, String contra, String efectivo) {
        for (int fila = 0; fila < 25; fila++) {
            if (Cuentas[fila][0].equals(user) && Cuentas[fila][1].equals(contra)) {
                if (Double.parseDouble(Cuentas[fila][2]) < Double.parseDouble(efectivo)) {
                    JOptionPane.showMessageDialog(null, "no dispone de la cantidad necesario para realizar la transacción");
                } else {
                    Cuentas[fila][2] = String.valueOf(Double.parseDouble(Cuentas[fila][2]) - Double.parseDouble(efectivo));
                    Cuentas[fila][3] = "Retiró la suma de: $" + efectivo;
                }
            }
        }
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

}
