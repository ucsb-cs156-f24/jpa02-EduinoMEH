package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_true_for_same_objects() {
        Team team1 = new Team();
        Team team2 = team1;
        assertEquals(team1.equals(team2), true);
    }

    @Test
    public void equals_returns_false_for_different_classes() {
        Team team1 = new Team();
        Object obj = new Object();
        assertEquals(team1.equals(obj), false);
    }

    // Multiple tests for (this.name.equals(other.name) && this.members.equals(other.members))
    @Test
    public void equals_returns_true_for_same_name_and_members() {
        Team team1 = new Team();
        Team team2 = new Team();
        ArrayList<String> memberList = new ArrayList<String>();
        memberList.add("Edwin");

        team1.setName("f24-02");
        team1.setMembers(memberList);
        team2.setName("f24-02");
        team2.setMembers(memberList);

        assertEquals(team1.equals(team2), true);
    }

    @Test
    public void equals_return_false_for_same_name_different_members() {
        Team team1 = new Team();
        Team team2 = new Team();
        ArrayList<String> memberList1 = new ArrayList<String>();
        ArrayList<String> memberList2 = new ArrayList<String>();
        memberList1.add("Edwin");
        memberList2.add("Jakob");

        team1.setName("f24-02");
        team1.setMembers(memberList1);
        team2.setName("f24-02");
        team2.setMembers(memberList2);

        assertEquals(team1.equals(team2), false);
    }

    @Test
    public void equals_return_false_for_different_name_same_members() {
        Team team1 = new Team();
        Team team2 = new Team();
        ArrayList<String> memberList = new ArrayList<String>();
        memberList.add("Edwin");

        team1.setName("f24-02");
        team1.setMembers(memberList);
        team2.setName("f24-03");
        team2.setMembers(memberList);

        assertEquals(team1.equals(team2), false);
    }

    @Test
    public void equals_return_false_for_different_name_and_members() {
        Team team1 = new Team();
        Team team2 = new Team();
        ArrayList<String> memberList1 = new ArrayList<String>();
        ArrayList<String> memberList2 = new ArrayList<String>();
        memberList1.add("Edwin");
        memberList2.add("Jakob");

        team1.setName("f24-02");
        team1.setMembers(memberList1);
        team2.setName("f24-03");
        team2.setMembers(memberList2);

        assertEquals(team1.equals(team2), false);
    }
  
    @Test
    public void hashCode_returns_true_same_class() {
        Team team1 = new Team();
        Team team2 = new Team();
        ArrayList<String> memberList = new ArrayList<String>();
        memberList.add("Edwin");

        team1.setName("f24-02");
        team1.setMembers(memberList);
        team2.setName("f24-02");
        team2.setMembers(memberList);
        assertEquals(team1.hashCode(), team2.hashCode());
    }

    @Test
    public void hashCode_distinction_OR_AND() {
        Team team1 = new Team();
        int result = team1.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }
}
