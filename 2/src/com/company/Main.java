package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MusicCollection Pop = new MusicCollection();
        MusicCollection Jazz = new MusicCollection();
        MusicCollection Rock = new MusicCollection();
        MusicCollection Country = new MusicCollection();
        System.out.println("welcome to music manager , choose :");
        System.out.println("1)add song ");
        System.out.println("2)remove song ");
        System.out.println("3)see number of songs in each list");
        System.out.println("4)see all file addresses");
        System.out.println("5)add song to fave");
        System.out.println("6)remove song frome faves");
        System.out.println("7)play");
        System.out.println("8)stop");
        System.out.println("9)search");
        System.out.println("10)exit");
        while (true){
            Scanner myObj = new Scanner(System.in);
            int option = myObj.nextInt();

            switch (option){
                case 1 :
                    Scanner obj2 = new Scanner(System.in);
                    Music newMusic = new Music();
                    System.out.println("enter name of song");
                    String input = obj2.nextLine();
                    newMusic.setSinger(input);
                    System.out.println("enter file address");
                    input = obj2.nextLine();
                    newMusic.setAddress(input);
                    System.out.println("Enter publish year:");
                    input = obj2.nextLine();
                    newMusic.setPublishYear(input);
                    System.out.println("which genre 1)pop 2)jazz 3)Rock 4)country");
                    int num = obj2.nextInt();
                    switch (num){
                        case 1:
                            Pop.addFile(newMusic);
                            break;
                        case 2:
                            Jazz.addFile(newMusic);
                            break;
                        case 3:
                            Rock.addFile(newMusic);
                            break;
                        case 4:
                            Country.addFile(newMusic);
                            break;
                    }
                    //System.out.println("successfully added");
                    break;
                case 2:
                    Scanner obj3 = new Scanner(System.in);
                    System.out.println("enter index of song");
                    int index = obj3.nextInt();
                    System.out.println("which genre 1)pop 2)jazz 3)Rock 4)country");
                    num = obj3.nextInt();
                    switch (num){
                        case 1:
                            Pop.removeFile(index);
                            break;
                        case 2:
                            Jazz.removeFile(index);
                            break;
                        case 3:
                            Rock.removeFile(index);
                            break;
                        case 4:
                            Country.removeFile(index);
                            break;
                    }
                    //System.out.println("successfully deleted");
                    break;
                case 3:
                    System.out.println("pop :"+Pop.getNumberOfFiles());
                    System.out.println("Jazz :"+Jazz.getNumberOfFiles());
                    System.out.println("Rock:"+Rock.getNumberOfFiles());
                    System.out.println("Country :"+Country.getNumberOfFiles());
                    break;
                case 4:
                    Pop.listAllFiles();
                    Jazz.listAllFiles();
                    Rock.listAllFiles();
                    Country.listAllFiles();
                    break;
                case 5:
                    Scanner obj = new Scanner(System.in);
                    System.out.println("enter name of song");
                    String n = obj.nextLine();
                    System.out.println("which genre 1)pop 2)jazz 3)Rock 4)country");
                    num = obj.nextInt();
                   switch (num){
                        case 1:
                            Pop.addToFav(n);
                            Pop.listFavsongs();
                            break;
                        case 2:
                            Jazz.addToFav(n);
                            Jazz.listFavsongs();
                            break;
                        case 3:
                            Rock.addToFav(n);
                            Rock.listFavsongs();
                            break;
                        case 4:
                            Country.addToFav(n);
                            Country.listFavsongs();
                            break;
                    }
                    break;
                case 6:
                    Scanner obj5 = new Scanner(System.in);
                    System.out.println("enter name of song you want to be deleted");
                    String name = obj5.nextLine();
                    System.out.println("which genre?1)pop 2)jazz 3)Rock 4)country");
                    num = obj5.nextInt();
                    switch (num){
                        case 1:
                            Pop.removeFromFave(name);
                            break;
                        case 2:
                            Jazz.removeFromFave(name);
                            break;
                        case 3:
                            Rock.removeFromFave(name);
                            break;
                        case 4:
                            Country.removeFromFave(name);
                            break;
                    }
                    break;
                case 7:
                    Scanner obj6=new Scanner(System.in);
                    System.out.println("enter index of song you wanna play");
                    index = obj6.nextInt();
                    System.out.println("which genre ?1)pop 2)jazz 3)Rock 4)country");
                    num = obj6.nextInt();
                    switch (num){
                        case 1:
                            Pop.startPlaying(index);
                            break;
                        case 2:
                            Jazz.startPlaying(index);
                            break;
                        case 3:
                            Rock.startPlaying(index);
                            break;
                        case 4:
                            Country.startPlaying(index);
                            break;
                    }
                    break;
                case 8:
                    Pop.stopPlaying();
                    Jazz.stopPlaying();
                    Rock.stopPlaying();
                    Country.stopPlaying();
                    break;
                case 9:
                    Scanner obj7=new Scanner(System.in);
                    System.out.println("enter address or name of song :");
                    input = obj7.nextLine();
                    System.out.println("which genre ?1)pop 2)jazz 3)Rock 4)country");
                    num = obj7.nextInt();
                    switch (num){
                        case 1:
                            Pop.showAllfromThisSinger(input);
                            break;
                        case 2:
                            Jazz.showAllfromThisSinger(input);
                            break;
                        case 3:
                            Rock.showAllfromThisSinger(input);
                            break;
                        case 4:
                            Country.showAllfromThisSinger(input);
                            break;
                    }
                    break;

                case 10:
                    return;

            }
        }
    }
}
