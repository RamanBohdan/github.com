package com.github.RamanBohdan.ui.steps;
import com.github.RamanBohdan.ui.entity.User;
import com.github.RamanBohdan.ui.pageobjects.GitHubHomePage;
import com.github.RamanBohdan.ui.pageobjects.SignInToGitHubPage;
import com.github.RamanBohdan.ui.utils.UserCreator;

public class SignInStep extends SignInToGitHubPage {
    public static void signInAccountStep() {
        User user = UserCreator.createUser();
        new GitHubHomePage().openPage()
                .clickButtonSingIn()
                .fillFormAddClickButtonSignIn(user.getUsername(), user.getPassword())
                .clickUserMenuForRepository();
    }

    public static void signInAccountWithDataProviderStep() {
        User user = UserCreator.createUser();
        new GitHubHomePage().openPage()
                .clickButtonSingIn()
                .fillFormAddClickButtonSignIn(user.getUsername(), user.getPassword());
    }

}