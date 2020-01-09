import com.ea.async.Async;

public class Main {

    public static void main(String[] unused) {
        StringCompletableFuture srcTask = new StringCompletableFuture();
        System.out.println("About to call getNumber");
        StringCompletableFuture prependTask = prependHash(srcTask);
        System.out.println("Called getNumber");
        srcTask.complete("1");
        System.out.println("Completed srcTask");
        System.out.println("Result: " + prependTask.join());
    }

    private static StringCompletableFuture prependHash(StringCompletableFuture stringCf) {
        System.out.println("Wait started");
        Async.await(stringCf);
        System.out.println("Wait ended");
        StringCompletableFuture done = new StringCompletableFuture();
        done.complete("#" + stringCf.join());
        return done;
    }

}
