public class ImplementationRunnable implements Runnable{

    private int zakresOd;
    private int zakresDo;
    private int wynik;

    public void setZakres(int zakresOd,int zakresDo) {
        this.zakresOd = zakresOd;
        this.zakresDo = zakresDo;
    }

    public int getWynik() {
        return wynik;
    }

    @Override

    public void run() {
        int l= 1;
        System.out.println(zakresOd+" "+zakresDo+" zakresy");
        for(int i=zakresOd;i<zakresDo+1;i++)
        {
            l*=i;
        }
        this.wynik  = l;
    }
}
