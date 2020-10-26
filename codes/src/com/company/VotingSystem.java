package com.company;

import java.sql.Time;
import java.util.ArrayList;

public class VotingSystem {
    public ArrayList<Voting> votingList ;

    /**
     * constructor
     */
    public VotingSystem(){
        votingList = new ArrayList<Voting>();
    }

    /**
     * creats new voting
     * @param question question of voting
     * @param type type of voting
     */
    public void creatVoting(String question , int type){
        Voting v =new Voting(type,question);
        votingList.add(v);
    }

    /**
     * delets a voting from voting system
     * @param number number of voting in voting list.
     */
    public  void deleteVoting(int number){
        votingList.remove(number-1);
    }

    /**
     * prints question off all available votings in System
     */
    public void printListOfVotings(){
        int counter = 1;
        for (Voting v : votingList) {
            System.out.println("poll"+counter+" "+v.getQuestion());
            counter++;
        }
    }

    /**
     * prints question and options of a voting
     * @param number number of voting in list
     */
    public void printVoting(int number){
        System.out.println(votingList.get(number-1).getQuestion());
        for (String s : votingList.get(number-1).getPolls().keySet()) {
            System.out.println(s);
        }
    }

    /**
     * vote
     * @param number number of voting
     * @param person person who wants to vote
     * @param date date of voting
     * @param votes options a person wanna vote
     */
    public  void vote(int number , Person person ,String date ,ArrayList<String> votes ){

       votingList.get(number-1).vote(person,date , votes);
    }

    /**
     * prints result of a voting (options and voters to each option)
     * @param number number of voting in system
     */
    public void printResult(int number){
        votingList.get(number-1).printVotes();

    }

}
