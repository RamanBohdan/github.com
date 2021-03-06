package com.github.RamanBohdan.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CreateNewGitHubRepository extends AbstractPage {

    @FindBy(xpath = "//input[@id='repository_name']")
    private WebElement inputNameRepository;
    @FindBy(xpath = "//button[@class='btn-primary btn']")
    private WebElement buttonCreateRepository;
    @FindBy(xpath = "//a[@href='/RamanBohdan/example']")
    private WebElement searchRepository;

    public CreateNewGitHubRepository getNewRepository(String nameRepository) {
        inputNameRepository.sendKeys(nameRepository);
        waitForElementToBeClickable(buttonCreateRepository).click();
        return new CreateNewGitHubRepository();
    }

    private List<String> chooseUserRepository(String repository) {
        waitForElementToBeClickable(searchRepository).click();
        String nameInResult = "//a[@href='/RamanBohdan/example']";
        List<String> nameRepository = driver.findElements(By.xpath(nameInResult)).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        logger.info("nameRepository: "+ nameRepository);
        return nameRepository;
    }

    public boolean isAnyResultContainsRepositoryName(String repository) {
        List<String> repoInResult = chooseUserRepository(repository);
        logger.info("isAnyResultContainsRepositoryName");
        logger.info(repoInResult.stream().anyMatch(repo -> repo.contains(repository)));
        return repoInResult.stream().anyMatch(repo -> repo.contains(repository));
    }

}
