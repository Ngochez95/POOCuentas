package bancoapoo;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class BancoAPoo {

    public static void main(String[] args) {
        JTextArea hoja = new JTextArea();
        Cuenta cuentas = new Cuenta();
        int opciones;
        boolean estado = true;

        do {
            opciones = Integer.parseInt(JOptionPane.showInputDialog("Opciones"
                    + "\n1-Crear cuenta\n2-Ver Cuentas"
                    + "\n3-Consultar saldo\n4-Ingresar efectivo"));
            switch (opciones) {
                case 1:
                    cuentas.CrearCuenta("nelson", "25", "12345");
                    break;

                case 2:
                    hoja.setText(cuentas.MostrarCuenta());
                    JOptionPane.showMessageDialog(null, hoja);
                    break;
                case 3:
                   JOptionPane.showMessageDialog(null, cuentas.mostrarSaldo("nelson", "12345"));
                    break;
                case 4:
                    cuentas.ingresoEfectivo("nelson", "12345", 200);
                    break;
            }
            cuentas.setSalida("");
            hoja.setText(cuentas.getSalida());
        } while (estado);
    }

}
