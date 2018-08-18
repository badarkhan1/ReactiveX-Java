package conditionalandbooleanoperators;

import rx.Observable;
import rx.Subscriber;

public class DefaultIfEmpty {
    public static void main(String[] args) {
        
        // Observable.defaultIfEmpty(? extends T)
        System.out.println("Observable.defaultIfEmpty(? extends T)");
        
        Observable.empty().defaultIfEmpty(1)
                .subscribe(new Subscriber<Object>(){
            @Override
            public void onCompleted() {
                System.out.println("All items have been emitted.");
            }

            @Override
            public void onError(Throwable thrwbl) {
                System.out.println("Something went wrong...");
            }

            @Override
            public void onNext(Object t) {
                System.out.print(t + " ");
            }
        });
    }
}
