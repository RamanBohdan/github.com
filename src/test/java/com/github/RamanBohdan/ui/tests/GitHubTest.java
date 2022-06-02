package com.github.RamanBohdan.ui.tests;

import org.testng.annotations.Test;
import com.github.RamanBohdan.ui.pageobjects.*;

public class GitHubTest extends AbstractTest {
    private static final String userName = "RamanBohdan";
    private static final String userPassword = "wmckJiMqCZ1";
    private static final String nameRepository = "example";
    private static final String repository = "example";

    @Test
    public void testSignInUserAndCreateNewRepository() {
        CreateNewRepository userPage = new GitHubHomePage().openPage()
                .clickButtonSingIn()
                .fillFormAddClickButtonSignIn(userName, userPassword)
                .clickUserMenuForRepository()
                .clickButtonAndCreateRepository()
                .getNewRepository(nameRepository);

    }

    @Test
    public void testChooseUserRepository() {
        GitHubUserRepositoryPage userPage = new GitHubHomePage().openPage()
                .clickButtonSingIn()
                .fillFormAddClickButtonSignIn(userName, userPassword)
                .clickUserMenuForRepository();

    }

  /*  @Test
    public void testDeleteUserRepository() throws InterruptedException {
        GitHubUserPage userPage = new GitHubHomePage().openPage()
                .clickButtonSingIn()
                .fillFormAddClickButtonSignIn(userName, userPassword)
                .chooseUserRepository(repository);
        Thread.sleep(5000);
    }*/

}
