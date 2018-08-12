package creatingobservables;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import rx.Observable;
import rx.Subscriber;


public class Interval {
    public static void main(String[] args){
        
        CountDownLatch latch = new CountDownLatch(1);
        
        // Observable.interval()
        System.out.println("Observable.interval(Long interval, TimeUnit timeUnit)");
        Observable<Long> obsrvble = Observable.interval(1000, TimeUnit.MILLISECONDS);
        obsrvble.subscribe(new Subscriber<Long>(){
            @Override
            public void onCompleted() {
                System.out.println(" All items have been emitted.");
            }

            @Override
            public void onError(Throwable thrwbl) {
                System.out.println("Something went wrong...");
            }

            @Override
            public void onNext(Long t) {
                System.out.print(t);
            }
        });
        
        // Wait for the observable to complete. (Never in this case.)
        try {
            latch.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Interval.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
