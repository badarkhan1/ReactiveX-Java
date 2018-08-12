package creatingobservables;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import rx.Observable;
import rx.Subscriber;


public class Timer {
    public static void main(String[] args){
        
        CountDownLatch latch = new CountDownLatch(1);
        
        Observable<Long> obsrvble = Observable.timer(1000, TimeUnit.MILLISECONDS);
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
        
        try {
            latch.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
