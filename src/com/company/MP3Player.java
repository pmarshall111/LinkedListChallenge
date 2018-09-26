package com.company;

import java.util.LinkedList;

public class MP3Player {
    private String owner;
    private LinkedList<Album> albums;
    private LinkedList<Playlist> playlists;

    public MP3Player(String owner) {
        this.owner = owner;
        this.albums = new LinkedList<Album>();
        this.playlists = new LinkedList<Playlist>();
    }

    public LinkedList<Album> getAlbums() {
        return albums;
    }

    public void addAlbum(String name) {
        albums.add(new Album(name));
    }

    public void addSongToAlbum(String albumName, String songName, String songDuration) {
        Album targetAlbum = findAlbum(albumName);

        if (targetAlbum != null) {
            targetAlbum.addSong(new Song(songName, songDuration));
            System.out.println("Added " + songName + " to " + albumName);
        } else {
            System.out.println("Could not find the album: " + albumName);
        }
    }

    private Album findAlbum(String name) {
        for (Album album: this.albums) {
            if (album.getName().equals(name)) return album;
        }
        return null;
    }

    public void addPlaylist(String name) {
        this.playlists.add(new Playlist(name));
    }

    public void addSongToPlaylist(String playlistName, String songName) {
        Playlist playlist = findPlaylist(playlistName);
        if (playlist != null) {
            //now we need to check if song is owned
            Song song = isSongOwned(songName);
            if (song != null) playlist.addSong(song);
            else System.out.println("The song " + songName + " is not owned and so cannot be added to your playlist");
        } else {
            System.out.println("Could not find the playlist: " + playlistName);
        }
    }

    private Playlist findPlaylist(String playlistName) {
        for (Playlist playlist: this.playlists) {
            if (playlist.getName().equals(playlistName)) return playlist;
        }
        return null;
    }

    private Song isSongOwned(String songName) {
        for (Album album: this.albums) {
            Song song = album.songInAlbum(songName);
            if (song != null) return song;
        }
        return null;
    }

    public void showAlbumTracks(String albumName) {
        Album reqAlbum = findAlbum(albumName);

        if (reqAlbum != null) reqAlbum.printSongList();
        else System.out.println("Could not find the album: " + albumName);
    }

    public void showPlaylistTracks(String playlistName) {
        Playlist reqPlaylist = findPlaylist(playlistName);

        if (reqPlaylist != null) reqPlaylist.printSongList();
        else System.out.println("Could not find the playlist: " + playlistName);
    }

    public void playAPlaylist(String playlistName) {
        Playlist reqPlaylist = findPlaylist(playlistName);

        if (reqPlaylist != null) reqPlaylist.play();
        else System.out.println("Could not find the playlist: " + playlistName);
    }

    public void playAnAlbum(String albumName) {
        Album reqAlbum = findAlbum(albumName);

        if (reqAlbum != null) reqAlbum.play();
        else System.out.println("Could not find the playlist: " + albumName);
    }
}
