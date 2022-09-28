import java.util.ArrayList;

public class Venda {
    private int priceTotal;
    private ArrayList<Productes> lista;

   public Venda(){
        this.lista = new ArrayList<Productes>();
        this.priceTotal = 0;
    }

    public int getPriceTotal(){
        return this.priceTotal;
    }

    public ArrayList<Productes> getProductes(){
        return this.lista;
    }

    public void setProductes (ArrayList<Productes> lista){
        this.lista = lista;
    }

    public void calcularTotal() throws VendaBuidaException {
        if(this.lista.isEmpty()){
            throw new VendaBuidaException();
        }

        try{
            for (int i = 0; i < lista.size(); i++) {

                this.priceTotal += lista.get(i).getPrice();
            }

            System.out.println("La venda total es de " + this.priceTotal + " euros");

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

    }

}
