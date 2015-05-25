package renaudmathieu.com.videoplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends Activity implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener {

    private final String TAG = VideoPlayer.class.getSimpleName();

    /**
     * Video sample URL
     */
    private final String VIDEO_URL = "http://sample-videos.com/video/mp4/720/big_buck_bunny_720p_1mb.mp4";

    /**
     * Display of the video file.
     */
    private VideoView mVideoView;

    /**
     * Provide the controls for the video playback
     */
    private MediaController mMediaController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        // Create the Video View
        mVideoView = (VideoView) findViewById(R.id.videoView1);
        mVideoView.setVideoPath(VIDEO_URL);

        // Set up a MediaController
        mMediaController = new MediaController(this);
        mMediaController.setAnchorView(mVideoView);
        mVideoView.setMediaController(mMediaController);

        // Set up a PreparedListener
        mVideoView.setOnPreparedListener(this);
        mVideoView.setOnCompletionListener(this);
        mVideoView.setOnErrorListener(this);
        mVideoView.setOnInfoListener(this);

    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        Log.w(TAG, "onPrepared()");
        mVideoView.start();
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        Log.w(TAG, "onCompletion()");

    }

    public boolean onError(MediaPlayer mp, int what, int extra) {

        switch (what) {
            case MediaPlayer.MEDIA_ERROR_UNKNOWN:
                Log.w(TAG, "onError: MEDIA_ERROR_UNKNOWN" + ", " + extra);
                break;
            case MediaPlayer.MEDIA_ERROR_SERVER_DIED:
                Log.w(TAG, "onError: MEDIA_ERROR_SERVER_DIED" + ", " + extra);
                break;
        }

        return false;
    }

    public boolean onInfo(MediaPlayer mp, int what, int extra) {

        switch (what) {
            case MediaPlayer.MEDIA_INFO_UNKNOWN:
                Log.w(TAG, "onInfo: MEDIA_INFO_UNKNOWN" + ", " + extra);
                break;
            case MediaPlayer.MEDIA_INFO_VIDEO_TRACK_LAGGING:
                Log.w(TAG, "onInfo: MEDIA_INFO_VIDEO_TRACK_LAGGING" + ", " + extra);
                break;
            case MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START:
                Log.w(TAG, "onInfo: MEDIA_INFO_VIDEO_RENDERING_START" + ", " + extra);
                break;
            case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                Log.w(TAG, "onInfo: MEDIA_INFO_BUFFERING_START" + ", " + extra);
                break;
            case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                Log.w(TAG, "onInfo: MEDIA_INFO_BUFFERING_END" + ", " + extra);
                break;
            case MediaPlayer.MEDIA_INFO_BAD_INTERLEAVING:
                Log.w(TAG, "onInfo: MEDIA_INFO_BAD_INTERLEAVING" + ", " + extra);
                break;
            case MediaPlayer.MEDIA_INFO_NOT_SEEKABLE:
                Log.w(TAG, "onInfo: MEDIA_INFO_NOT_SEEKABLE" + ", " + extra);
                break;
            case MediaPlayer.MEDIA_INFO_METADATA_UPDATE:
                Log.w(TAG, "onInfo: MEDIA_INFO_METADATA_UPDATE" + ", " + extra);
                break;
            case MediaPlayer.MEDIA_INFO_UNSUPPORTED_SUBTITLE:
                Log.w(TAG, "onInfo: MEDIA_INFO_UNSUPPORTED_SUBTITLE" + ", " + extra);
                break;
            case MediaPlayer.MEDIA_INFO_SUBTITLE_TIMED_OUT:
                Log.w(TAG, "onInfo: MEDIA_INFO_SUBTITLE_TIMED_OUT" + ", " + extra);
                break;
        }

        return false;
    }

}
