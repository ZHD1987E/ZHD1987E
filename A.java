/*
 * This is skeleton code for Recitation 10. Use them if you would like!
 * 
 * Created by ZHD1987E based on the document.
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.lang.RuntimeException;

class A {
    private final int x;
    private static final int SLEEPTIME = 1000;

    A() {
        this(0); //basically the same as calling A(0).
    }

    A(int x) {
        this.x = x;
    }

    void sleep() {
        System.out.println(Thread.currentThread().getName() + " " + x);
        try {
            Thread.sleep(SLEEPTIME);
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
    }

    A incr() {
        sleep();
        return new A(this.x + 1);
    }

    A decr() {
        sleep();
        if (x < 0) {
            throw new IllegalStateException();
        }
        return new A(this.x - 1);
    }

    public String toString() {
        return "" + x;
    }

    CompletableFuture<A> foo(A a) {
        throw RuntimeException("To be implemented.");
    }

    CompletableFuture<A> bar(CompletableFuture<A> a) {
        throw RuntimeException("To be implemented.");
    }

    A baz(A a, int x) {
        if (x == 0) {
            return new A(0);
        } else {
            return a.incr().decr();
        }
    }
}
    