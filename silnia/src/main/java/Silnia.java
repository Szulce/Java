import static java.lang.System.exit;

public class Silnia {

    public int oblicz(int n) throws InterruptedException {
        ImplementationRunnable implementRunnable1 = new ImplementationRunnable();
        ImplementationRunnable implementRunnable2 = new ImplementationRunnable();
        ImplementationRunnable implementRunnable3 = new ImplementationRunnable();
        ImplementationRunnable implementRunnable4 = new ImplementationRunnable();
        ImplementationRunnable implementRunnable5 = new ImplementationRunnable();
        //ustawiam zakresy
        if(n>=5) {

            implementRunnable1.setZakres(1,n/5);
            implementRunnable2.setZakres((n/5)+1,2*n/5);
            implementRunnable3.setZakres((2*n/5)+1,3*n/5);
            implementRunnable4.setZakres((3*n/5)+1,4*n/5);
            implementRunnable5.setZakres((4*n/5)+1,n);
        }
        else{
            System.out.println("program działa dla liczby >=5");
            exit(-1);
        }

        Thread t1 = new Thread(implementRunnable1," wątek1 ");
        Thread t2 = new Thread(implementRunnable2," wątek2 ");
        Thread t3 = new Thread(implementRunnable3," wątek3 ");
        Thread t4 = new Thread(implementRunnable4," wątek4 ");
        Thread t5 = new Thread(implementRunnable5," wątek5 ");


        int s=1;

         t1.start();
         t2.start();
         t3.start();
         t4.start();
         t5.start();

           t1.join();
           s *= implementRunnable1.getWynik();
           t2.join();
           s*=implementRunnable2.getWynik();
           t3.join();
           s*=implementRunnable3.getWynik();
           t4.join();
           s*=implementRunnable4.getWynik();
           t5.join();
           s*=implementRunnable5.getWynik();


        return s;

    }
}
