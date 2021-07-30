package com.google;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;
  private Video videoCurrentlyPlaying;
  private boolean isCurrentlyPlaying;
  private boolean isPaused;
  private HashMap<String, VideoPlaylist> allPlaylists = new HashMap<String, VideoPlaylist>();

  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
  }

  public void numberOfVideos() {
    System.out.printf("%s Videos in the Library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    System.out.println("Here's a list of all availble videos");

    for (Video video : videoLibrary.getVideos()) {
      List<String> tags = video.getTags();

      if (tags.size() > 0) {
        StringBuffer sb = new StringBuffer();
        boolean isFirstTag = true; 
        for (String tag : tags) {
          if (isFirstTag) {
            sb.append(tag);
            isFirstTag =  false;
          } else {
            sb.append(" ");
            sb.append(tag);
          }
        }
        String tagString = sb.toString();
        System.out.println("  " + video.getTitle() + " (" + video.getVideoId() + ")" + " [" + tagString + "]");
      } else {
        System.out.println("  " + video.getTitle() + " (" + video.getVideoId() + ")");
      }
      
  
    }
  }

  public void playVideo(String videoId) {
    HashMap<String, Video> hashMap = videoLibrary.getHashmap();
    if (hashMap.containsKey(videoId)) {
      if (isCurrentlyPlaying == false) {
        System.out.println("Playing video: " + hashMap.get(videoId).getTitle());
        isCurrentlyPlaying = true;
        videoCurrentlyPlaying = hashMap.get(videoId);
      } else {
        System.out.println("Stopping video: " + videoCurrentlyPlaying.getTitle());
        System.out.println("Playing video: " + hashMap.get(videoId).getTitle());
        videoCurrentlyPlaying = hashMap.get(videoId);
      }
    } else {
      System.out.println("Cannot play video: Video does not exist");
    }
  }

  public void stopVideo() {
    if (isCurrentlyPlaying == true) {
      System.out.println("Stopping video: " + videoCurrentlyPlaying.getTitle());
      videoCurrentlyPlaying = null;
      isCurrentlyPlaying = false;
    } else {
      System.out.println("Cannot stop video: No video currently playing");
    }
    
  }

  public void playRandomVideo() {
    List<Video> videos = videoLibrary.getVideos();
    int maxIndex = videos.size()-1;

// nextInt is normally exclusive of the top value,
// so add 1 to make it inclusive
    int randomNum = ThreadLocalRandom.current().nextInt(0, maxIndex + 1);
    if (isCurrentlyPlaying == false) {
      System.out.println("Playing video: " + videos.get(randomNum).getTitle());
      isCurrentlyPlaying = true;
      videoCurrentlyPlaying = videos.get(randomNum);
    } else {
      System.out.println("Stopping video: " + videoCurrentlyPlaying.getTitle());
      System.out.println("Playing video: " + videos.get(randomNum).getTitle());
      isCurrentlyPlaying = true;
      videoCurrentlyPlaying = videos.get(randomNum);
    }
    
  }

  public void pauseVideo() {
    if (isPaused == false && videoCurrentlyPlaying != null) {
      System.out.println("Pausing video: " + videoCurrentlyPlaying.getTitle());
      isPaused = true;
    } else if (videoCurrentlyPlaying == null) {
      System.out.println("Cannot pause video: No video currently playing");
    } else {
      System.out.println("Video already paused: " + videoCurrentlyPlaying.getTitle());
    }
  }

  public void continueVideo() {
    if (isPaused == true) {
      System.out.println("Continuing video: " + videoCurrentlyPlaying.getTitle());
      isPaused = false;
    } else if (videoCurrentlyPlaying == null) {
      System.out.println("Cannot continue video: No video currently playing");
    } else {
      System.out.println("Cannot continue video: Video is not paused");
    }
  }

  public void showPlaying() {
    if (videoCurrentlyPlaying != null) {

      String title = videoCurrentlyPlaying.getTitle();
      String id = videoCurrentlyPlaying.getVideoId();

      List<String> tags = videoCurrentlyPlaying.getTags();

      if (tags.size() > 0) {
        StringBuffer sb = new StringBuffer();
        boolean isFirstTag = true; 
        for (String tag : tags) {
          if (isFirstTag) {
            sb.append(tag);
            isFirstTag =  false;
          } else {
            sb.append(" ");
            sb.append(tag);
          }
        }
        String tagString = sb.toString();
        System.out.println("Currently playing: " + "  " + title + " (" + id + ")" + " [" + tagString + "]");
      } else {
        System.out.println("Currently playing: " + "  " + title + " (" + id + ")");
      }
    } else {
      System.out.println("No video currently playing");
    }
  }

  public void createPlaylist(String playlistName) {

    if (allPlaylists.containsKey(playlistName.toLowerCase())) {
      System.out.println("Cannot create playlist: a playlist with the same name already exists");
    } else {
      allPlaylists.put(playlistName, new VideoPlaylist(playlistName));
      System.out.println("Successfully created new playlist: " + playlistName);
    }
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}