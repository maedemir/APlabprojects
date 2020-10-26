package com.company;

import ir.huri.jcal.JalaliCalendar;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * i tried to implement a simple sample :D of my voting system and use its methods to see what happens in fact!
 * remeber to enter date with this regex : year_month_day
 */
public class Main {

    public static void main(String[] args) {
        VotingSystem mySystem = new VotingSystem();
        //adding new voting and polls to my voting system
        mySystem.creatVoting("which one is your fav color ?",0);
        mySystem.votingList.get(0).creatPoll("purple");
        mySystem.votingList.get(0).creatPoll("blue");
        mySystem.votingList.get(0).creatPoll("red");
        mySystem.votingList.get(0).creatPoll("black");
        mySystem.votingList.get(0).creatPoll("green");
        mySystem.creatVoting("which one is your favourite animal?",1);
        mySystem.votingList.get(1).creatPoll("dog");
        mySystem.votingList.get(1).creatPoll("cat");
        mySystem.votingList.get(1).creatPoll("horse");
        mySystem.votingList.get(1).creatPoll("bird");
        mySystem.votingList.get(1).creatPoll("snake");
        ////initializing persons
        Person p1 = new Person("maede" ,"mir");
        Person p2 = new Person("zahra" , "mohamadi");
        Person p3 = new Person("sara" ,"ghasemi");
        Person p4 = new Person("Ali" , "karimi");
        //initializig array list of each persons option for poll 1
        ArrayList<String> p1_1 = new ArrayList<>(Arrays.asList("purple"));
        ArrayList<String> p2_1 = new ArrayList<>(Arrays.asList("blue"));
        ArrayList<String> p3_1 = new ArrayList<>(Arrays.asList("purple","red"));
        ArrayList<String> p4_1 = new ArrayList<>(Arrays.asList("green"));
        //initializig array list of each persons option for poll 2
        ArrayList<String> p1_2 = new ArrayList<>(Arrays.asList("dog" ,"cat"));
        ArrayList<String> p2_2 = new ArrayList<>(Arrays.asList("dog" ,"snake","bird"));
        ArrayList<String> p3_2 = new ArrayList<>(Arrays.asList("dog" ,"bird"));
        ArrayList<String> p4_2 = new ArrayList<>(Arrays.asList("horse"));
        //votings for voting 1 :))
        mySystem.printVoting(1);
        mySystem.printVoting(2);
        System.out.println("\n"+"\n"+"system check for voting number 1 ");
        mySystem.vote(1,p1 , "1399_3_10",p1_1);
        mySystem.vote(1,p2 , "1399_3_11",p2_1);
        //this is more than one option for a voting with type 0! so we must see a warnin here
        mySystem.vote(1,p3 , "1399_3_13",p3_1);
        mySystem.vote(1,p4 , "1399_3_15",p4_1);
        //p1 have voted before ! lets see what happens if he/she tries again!
        mySystem.vote(1,p1 , "1399_3_10",p4_1);
        //an example of random vote for voting number 1 with type 0
        mySystem.votingList.get(0).randomChoice(p3,"1399_2_5");
        System.out.println("\n"+"\n"+"system check for voting number 2 ");
        //votings for voting 2
        mySystem.vote(2,p1,"1399_6_4",p1_2);
        mySystem.vote(2,p2,"1399_6_5",p2_2);
        mySystem.vote(2,p3,"1399_6_6",p3_2);
        // now lets see votes of voting number 1
        System.out.println("\n"+"\n"+"results for voting number 1 is:");
        mySystem.printResult(1);
        // now lets see votes of voting number 2
        System.out.println("\n"+"\n"+"results for voting number 2 is:");
        mySystem.printResult(2);
        System.out.println("\n"+"\n"+"you deleted voting 2 !!! new list is :");
        mySystem.deleteVoting(1);
        mySystem.printListOfVotings();














    }
}
