package transformingobservables;

import rx.Observable;
import rx.Subscriber;

public class Window {
    public static void main(String[] args){
        
        // Observable.window(int count)
        System.out.println("Observable.window(int count)");
        Observable.just(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
                .window(4)
                .subscribe(new Subscriber<Observable<Integer>>(){
            @Override
            public void onCompleted() {
                System.out.println("All items have been emitted.");
            }

            @Override
            public void onError(Throwable thrwbl) {
                System.out.println("Something went wrong.");
            }

            @Override
            public void onNext(Observable<Integer> t) {
                t.subscribe(new Subscriber<Integer>(){
                    @Override
                    public void onCompleted() {
                        System.out.println("All items have been emitted");
                    }

                    @Override
                    public void onError(Throwable thrwbl) {
                        System.out.println("Something went wrong...");
                    }

                    @Override
                    public void onNext(Integer t) {
                        System.out.print(t + " ");
                    }
                });
            }
        });
                
        
    }
}
