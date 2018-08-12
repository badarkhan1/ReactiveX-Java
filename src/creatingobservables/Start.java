package creatingobservables;

import java.util.concurrent.Callable;
import rx.Observable;
import rx.Subscriber;


public class Start {
    
    public static Integer performSomeLongRunningOperation(){
        return 1;
    }
    
    public static void main(String[] args){
        
        // Observable.fromCallable(Callable<? extends T> callable)
        System.out.println("Observable.from(Callable<? extends T> callable)");
        Observable<Integer> obsrvble = Observable.fromCallable(new Callable<Integer>(){
            @Override
            public Integer call() throws Exception {
                return performSomeLongRunningOperation();
            }
        });
        
        obsrvble.subscribe(new Subscriber<Integer>(){
            @Override
            public void onCompleted() {
                System.out.println(" All items have been emitted.");
            }

            @Override
            public void onError(Throwable thrwbl) {
                System.out.println("Something went wrong...");
            }

            @Override
            public void onNext(Integer t) {
                System.out.print(t);
            }
        });
    }
}
