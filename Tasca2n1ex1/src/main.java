import java.util.ArrayList;
import java.util.Iterator;

public class main {
    public static void main(String[] args) {
        Venda maria = new Venda();
        try {
            maria.calcularTotal();
        } catch (VendaBuidaException ex) {
            System.out.println(ex.getMessage());
        }

        Productes poma= new Productes ("Poma golden", 2);
        Productes pebrot = new Productes ("pebrot vermell", 3);
        Productes pollastre = new Productes ("Pollastre sencer", 7);

        ArrayList<Productes> lista = new ArrayList();
        lista.add(poma);
        lista.add(pebrot);
        lista.add(pollastre);
        lista.add(poma);

        maria.setProductes(lista);
        try {

            maria.calcularTotal();
        } catch (VendaBuidaException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
