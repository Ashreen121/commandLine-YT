package com.google;

import java.util.ArrayList;

/** A class used to represent a Playlist */
class VideoPlaylist {

    String playlistName;
    ArrayList<Video> playlist = new ArrayList<Video>();

    public VideoPlaylist(String name) {
        playlistName = name;
    }
}
