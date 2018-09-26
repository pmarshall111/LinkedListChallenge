package com.company;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class SongGroup {
    private String name;
    private LinkedList<Song> songs;

    public SongGroup(String name) {
        this.name = name;
        this.songs = new LinkedList<Song>();
    }

    public String getName() {
        return name;
    }

    public LinkedList<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void printSongList() {
        if (this.songs.size() == 0) System.out.println("\nNo songs in " + this.name);
        else {
            String resultString = "\nSongs in " + this.name + ": \n";
            for (Song song: this.songs) {
                resultString += song.getName() + " " + song.getDuration() + "\n";
            }

            System.out.println(resultString);
        }
    }

    public void play() {
        Scanner myScanner = new Scanner(System.in);

        ListIterator<Song> songIterator = this.songs.listIterator();

        if (this.songs.isEmpty()) {
            System.out.println("No songs in " + this.name + ", so playing is not possible.");
        } else {
            printPlayMenu();
            System.out.println("Starting up " + this.name + "\n ===========");
            String currSong = songIterator.next().getName();
            boolean playing = true, goingForward = true;

            System.out.println("Now playing " + currSong);

            while(playing) {
                int command = myScanner.nextInt();
                myScanner.nextLine();


                switch (command) {
                    case 1:
                        System.out.println("Replaying " + currSong);
                        break;

                    case 2:
                        //because the ListIterator never actually hangs on a value and sits between the values, when we change direction we
                        //need to add an extra call.
                        if (!goingForward) songIterator.next();

                        goingForward = true;
                        if (songIterator.hasNext()) {
                            currSong = songIterator.next().getName();
                            System.out.println("Now playing " + currSong);
                        } else System.out.println("Reached the end of the playlist!");
                        break;

                    case 3:
                        if (goingForward) songIterator.previous();

                        goingForward = false;
                        if (songIterator.hasPrevious()) {
                            currSong = songIterator.previous().getName();
                            System.out.println("Now playing " + currSong);
                        } else System.out.println("Reached the beginning of the playlist!");
                        break;

                    case 4:
                        printSongList();
                        break;

                    case 5:
                        printPlayMenu();
                        break;

                    case 6:
                        playing = false;
                        System.out.println("Music session is now over!");
                        break;

                    default:
                        System.out.println("No command detected. Press 5 to see Menu options");
                }
            }

        }

        myScanner.close();
    }

    private void printPlayMenu() {
        System.out.println("--------\n" +
                "Menu: \n" +
                "1 | Replay current song\n" +
                "2 | Go to next song\n" +
                "3 | Go to previous song\n" +
                "4 | See song list\n" +
                "5 | See play menu\n" +
                "6 | Stop\n" +
                "-------------\n");
    }
}
