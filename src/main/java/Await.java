import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class Await {

    public static void main(String[] args) {

        System.out.println("Await testing");

        await("DB connection").atMost(5, TimeUnit.SECONDS)
                .until(() -> dbIsReadyFAILED());

        System.out.println("BD connected successfully");
    }

    private static Boolean dbIsReadySUCCESS() throws InterruptedException {
        System.out.println("Waiting for connect to DB ...");
        Thread.sleep(4000); //fail
        return true;
    }

    private static Boolean dbIsReadyFAILED() throws InterruptedException {
        System.out.println("Waiting for connect to DB ...");
        Thread.sleep(6000); //ok
        return true;
    }

}
