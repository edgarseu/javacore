package concurrency.countdownlatch;

/**
 * @author caozy
 * @create 2018/10/31
 */
public class Main {
    public static void main(String[] args) {
        VideoConference videoConference = new VideoConference(10);
        Thread threadConference = new Thread(videoConference);
        threadConference.start();

        for (int i = 0; i < 10; i++) {
            new Thread(new Participant("P-" + i, videoConference)).start();
        }

    }
}
