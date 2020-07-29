/*Write a video player application with ‘Play’, ‘Forward’, ‘Rewind’ functionalities. Please write pseudocode for this program and explain the design pattern you will use to
  develop these three functionalities.*/

/*Here i will use observer design pattern for develop these three functionalities.*/

import java.util.ArrayList;
import java.util.List;

public class VideoPlayer  extends Thread implements OnVideoSegmentReceivedListener  {
    private List<VideoSegment> videoSegmentList = new ArrayList<>();
    public static void main(String[] args) {
        VideoPlayer videoPlayer = new VideoPlayer();
        VideoDownloader videoDownloader = new VideoDownloader();
        videoDownloader.subscribe(videoPlayer);
        videoPlayer.play();
    }

    private void showBufferingIndicator() {
        System.out.println("Buffering");
    }

    private boolean playVideoSegment() {
        System.out.println("Playing video......");
        return true;
    }

    private boolean playVideoSegmentToSpecificPosition(int offset) {
        synchronized (this) {
            notify();
            System.out.println("Played to " + offset);
        }
        return true;
    }
    /*Play: As VideoPlayer is subscribed to VideoDownloader. When a segment is downloaded VideoDownloader notifies
    VideoPlayer and that segment is played. Otherwise after timeout buffering indicator  will be shown.*/
    public boolean play() {
        try {
            synchronized (this) {
                wait(3000);
                showBufferingIndicator();
                return playVideoSegment();
            }
        } catch (InterruptedException e) {
            return playVideoSegment();
        }
    }

  /*  Forward: When user tap forward, it forwards to next tenth frame.*/

    public boolean forward(int position) {
        return playVideoSegmentToSpecificPosition(position);
    }

    /*Rewind: When user tap rewind, it starts with first frame.*/

    public boolean rewind() {
        return playVideoSegmentToSpecificPosition(0);
    }

    @Override
    public void notifyVideoPlayer(VideoSegment videoSegment) {
        videoSegmentList.add(videoSegment);
        interrupt();
    }
}

class VideoSegment {
    byte []payload;
    boolean isLastSegment;
}

class VideoDownloader {
    private OnVideoSegmentReceivedListener onVideoSegmentReceivedListener;

    public VideoDownloader() {
    }

    public void download() {
        boolean shouldDownloadVideo = true;
        while (shouldDownloadVideo) {
            VideoSegment videoSegment = new VideoSegment();
            shouldDownloadVideo = !videoSegment.isLastSegment;
            onVideoSegmentReceivedListener.notifyVideoPlayer(videoSegment);
        }
    }

    public void subscribe(VideoPlayer videoPlayer) {
        if (videoPlayer instanceof OnVideoSegmentReceivedListener) {
            onVideoSegmentReceivedListener = (OnVideoSegmentReceivedListener) videoPlayer;
        } else {
            throw new ClassCastException("OnVideoSegmentReceivedListener.");
        }
    }

}


interface OnVideoSegmentReceivedListener {
    void notifyVideoPlayer(VideoSegment videoSegment);
}
