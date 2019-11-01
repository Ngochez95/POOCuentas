package bancoapoo;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class BancoAPoo {

    public static void main(String[] args) {
        String nombre, efectivo, contrasenia;
        JTextArea hoja = new JTextArea();
        Cuenta cuentas = new Cuenta();
        int opciones;
        boolean estado = true;

        do {
            opciones = Integer.parseInt(JOptionPane.showInputDialog("Opciones"
                    + "\n1-Crear cuenta\n2-Ver Cuentas"
                    + "\n3-Consultar saldo\n4-Ingresar efectivo\n5-Retiro efectivo"));
            switch (opciones) {
                case 1:
                    nombre = JOptionPane.showInputDialog("ingrese nombre");
                    efectivo = JOptionPane.showInputDialog("ingrese efectivo");
                    contrasenia = JOptionPane.showInputDialog("ingrese contrasenia");

                    cuentas.CrearCuenta(nombre, efectivo, contrasenia);
                    JOptionPane.showMessageDialog(null, "Éxito!");
                    break;

                case 2:
                    hoja.setText(cuentas.MostrarCuenta());
                    JOptionPane.showMessageDialog(null, hoja);
                    break;
                case 3:
                    nombre = JOptionPane.showInputDialog("ingrese nombre");
                    contrasenia = JOptionPane.showInputDialog("ingrese contrasenia");
                    if (cuentas.verificarUsuario(nombre, contrasenia)) {
                        JOptionPane.showMessageDialog(null, cuentas.mostrarSaldo(nombre, contrasenia));

                    } else {

                        JOptionPane.showMessageDialog(null, "error, credenciales incorrectas");
                    }
                    break;
                case 4:
                    nombre = JOptionPane.showInputDialog("ingrese nombre");
                    contrasenia = JOptionPane.showInputDialog("ingrese contrasenia");
                    if (cuentas.verificarUsuario(nombre, contrasenia)) {
                        efectivo = JOptionPane.showInputDialog("ingrese efectivo");
                        cuentas.ingresoEfectivo(nombre, contrasenia, efectivo);
                    } else {
                        JOptionPane.showMessageDialog(null, "error, credenciales incorrectas");

                    }
                    break;
                case 5:
                    nombre = JOptionPane.showInputDialog("ingrese nombre");
                    contrasenia = JOptionPane.showInputDialog("ingrese contrasenia");
                    if (cuentas.verificarUsuario(nombre, contrasenia)) {
                        efectivo = JOptionPane.showInputDialog("ingrese efectivo que desea retirar");
                        cuentas.retiroEfectivo(nombre, contrasenia, efectivo);
                    } else {
                        JOptionPane.showMessageDialog(null, "error, credenciales incorrectas");
                    }
                    break;
            }
            cuentas.setSalida("");
            hoja.setText(cuentas.getSalida());
        } while (estado);
    }

}
