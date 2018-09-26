package com.company;

//Refactored so that Playlist and Album extend from the same class, SongGroup. They share a lot of the same methods
//so avoids code duplication.


public class Main {

    public static void main(String[] args) {
	// write your code here
        MP3Player iPhone = new MP3Player("Peter");

        iPhone.addAlbum("Eminem");
        iPhone.addAlbum("Taylor Swift");
        iPhone.addAlbum("Sam Smith");

        iPhone.addSongToAlbum("Eminem", "Lose Yourself", "4:35");
        iPhone.addSongToAlbum("Eminem", "Rap God", "4:02");
        iPhone.addSongToAlbum("Eminem", "Stan (Long, Explicit)", "4:35");
        iPhone.addSongToAlbum("Sam Smith", "Stay with me", "3:42");
        iPhone.addSongToAlbum("Sam Smith", "One Hit Wonder", "0:00");
        iPhone.addSongToAlbum("Adele", "Hello", "4:12");

        iPhone.showAlbumTracks("Eminem");
        iPhone.showAlbumTracks("Taylor Swift");
        iPhone.showAlbumTracks("Sam Smith");
        iPhone.showAlbumTracks("Adele");

        iPhone.addPlaylist("Fave songs");

        iPhone.addSongToPlaylist("Fave songs", "Stan (Long, Explicit)");
        iPhone.addSongToPlaylist("Fave songs", "Stay with me");
        iPhone.addSongToPlaylist("Fave songs", "Scar Tissue");
        iPhone.addSongToPlaylist("Classical", "Someone's 5th Concerto");

        iPhone.showPlaylistTracks("Fave songs");
        iPhone.showPlaylistTracks("Rock n roll");


        iPhone.addSongToPlaylist("Fave songs", "Lose Yourself");
        iPhone.addSongToPlaylist("Fave songs", "One Hit Wonder");

        iPhone.playAPlaylist("Fave songs");
        iPhone.playAnAlbum("Sam Smith");
//        iPhone.playAnAlbum("Taylor Swift");
    }
}


// Create a program that implements a playlist for songs
// Create a Song class having Title and Duration for a song.
// The program will have an Album class containing a list of songs.
// The albums will be stored in an ArrayList
// Songs from different albums can be added to the playlist and will appear in the list in the order
// they are added.
// Once the songs have been added to the playlist, create a menu of options to:-
// Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
// List the songs in the playlist
// A song must exist in an album before it can be added to the playlist (so you can only play songs that
// you own).
// Hint:  To replay a song, consider what happened when we went back and forth from a city before we
// started tracking the direction we were going.
// As an optional extra, provide an option to remove the current song from the playlist
// (hint: listiterator.remove()