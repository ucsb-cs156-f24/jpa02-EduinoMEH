package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.Transient;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Edwin M.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("EduinoMEH", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_correct_team_name() {
        Team team = Developer.getTeam();
        assertEquals("f24-02", team.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team team = Developer.getTeam();
        assertTrue(team.getMembers().contains("Edwin"), "Team should contain Edwin");
        assertTrue(team.getMembers().contains("Jakob"), "Team should contain Jakob");
        assertTrue(team.getMembers().contains("Jeffery"), "Team should contain Jeffery");
        assertTrue(team.getMembers().contains("Leo"), "Team should contain Leo");
        assertTrue(team.getMembers().contains("Rushil"), "Team should contain Rushil");
        assertTrue(team.getMembers().contains("Ved"), "Team should contain Ved");
    }
}
