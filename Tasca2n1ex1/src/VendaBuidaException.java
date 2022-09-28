public class VendaBuidaException extends Exception{
    private static final String MESSAGE = "Per fer una venda primer has d'afegir productes";
    public VendaBuidaException() {
        super(MESSAGE);
    }

}
