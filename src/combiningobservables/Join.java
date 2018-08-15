package combiningobservables;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;

public class Join {
    public static void main(String[] args) {
        
        CountDownLatch latch = new CountDownLatch(1);
        
        Observable<Integer> ob1 = Observable.just(1, 2, 3, 4, 5);
        Observable<String>  ob2 = Observable.just("A", "B", "C", "D", "E");
        
        Func1<Integer,Observable<Integer>> leftDur = new Func1<Integer,Observable<Integer>>(){
            @Override
            public Observable<Integer> call(Integer t) {
                return Observable.just(t*10);
            }            
        };
        
        Func1<String,Observable<Integer>> rightDur = new Func1<String,Observable<Integer>>(){
            @Override
            public Observable<Integer> call(String t) {
                return Observable.just(t.length()*10);
            }
        
        };
        
        Func2<Integer,String,String> resultSelector = new Func2<Integer,String,String>(){
            @Override
            public String call(Integer t1, String t2) {
                return t1 + t2;
            }
        };
        
        ob1.join(ob2, leftDur, rightDur, resultSelector)
                .subscribe(new Subscriber<String>(){
            @Override
            public void onCompleted() {
                System.out.println("All items have been emitted.");
            }

            @Override
            public void onError(Throwable thrwbl) {
                System.out.println("Something went wrong...");
            }

            @Override
            public void onNext(String t) {
                System.out.print(t + " ");
            }
        });
        
        try {
            latch.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Join.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
