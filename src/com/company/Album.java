package com.company;

import java.util.LinkedList;

public class Album extends SongGroup {
    public Album(String name) {
        super(name);
    }

    public Song songInAlbum(String songName) {
        LinkedList<Song> albumSongs = getSongs();

        for (Song song: albumSongs) {
            if (song.getName().equals(songName)) return song;
        }
        return null;
    }
}
