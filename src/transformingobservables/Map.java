package transformingobservables;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class Map {
    
    private static class Dog{
        public void speak(){
            System.out.println("woof woof...");
        }
    }
    
    private static class WildDog extends Dog{
        @Override
        public void speak() {
            System.out.println("wildwoof wildwoof...");
        }        
    }
    
    private static WildDog someLongRunningOperation(){
        return new WildDog();
    }
    
    public static void main(String[] args){

        // Observable.map(Func1<? extends T, ? extends R> func1)
        System.out.println("Observable.map(Func1<? extends T, ? extends R> func1)");        
        Observable.just(0, 1, 2, 3, 4, 5, 6, 7, 8,9)
                .map(new Func1<Integer,String>(){
            @Override
            public String call(Integer t) {
                return "The item emitted is " + t;
            }
        }).subscribe(new Subscriber<String>(){
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
                System.out.println(t);
            }
        });
        
        System.out.println();

        // Observable.cast(Class<R> klass)
        System.out.println("Observable.cast(Class<R> klass)");
        try {
            Observable.fromCallable(new Callable<WildDog>(){
                    @Override
                    public WildDog call() throws Exception {
                        return someLongRunningOperation();
                    }
                }).<Dog>cast((Class<Dog>) Class.forName(Dog.class.getName()))
                .subscribe(new Subscriber<Dog>(){
                @Override
                public void onCompleted() {
                    System.out.println("All items have been emitted");
                }

                @Override
                public void onError(Throwable thrwbl) {
                    System.out.println("Something went wrong...");
                }

                @Override
                public void onNext(Dog t) {
                    t.speak();
                    System.out.println();
                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
