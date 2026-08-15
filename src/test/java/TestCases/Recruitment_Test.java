package TestCases;

import org.testng.annotations.Test;

import DataProvider.RecruitmentDataProvider;
import orangehrm.Base.BaseTest;
import orangehrm.Pages.Dashboard_Page;
import orangehrm.Pages.LoginPage;
import org.testng.Assert;
import orangehrm.Pages.Recruitment_Page;

public class Recruitment_Test extends BaseTest {

    // TC_34 Add new candidate
    @Test(dataProvider = "AddCandidateData", dataProviderClass = RecruitmentDataProvider.class)
    public void AddNewCandidate(

            String firstName,
            String middleName,
            String lastName,
            String vacancy,
            String email,
            String contactNo,
            String keyword,
            String dateOfApplication,
            String notes) {

        LoginPage login = new LoginPage(driver);
        Dashboard_Page dashboard = new Dashboard_Page(driver);
        Recruitment_Page recruitment = new Recruitment_Page(driver);

        login.login("Admin", "admin123");

        dashboard.Click_Recruitment();

        recruitment.Navigate_To_AddCandidate();

        recruitment.Enter_FirstName_AddCandidate(firstName);
        recruitment.Enter_MiddleName_AddCandidate(middleName);
        recruitment.Enter_LastName_AddCandidate(lastName);
        recruitment.Enter_Vacancy_AddCandidate(vacancy);
        recruitment.Enter_Email_AddCandidate(email);
        recruitment.Enter_ContactNo_AddCandidate(contactNo);
        recruitment.Enter_Keyword_AddCandidate(keyword);
        recruitment.Enter_DateofApplication_AddCandidate(dateOfApplication);
        recruitment.Enter_Notes_AddCandidate(notes);

        recruitment.Click_SaveButton_AddCandidate();

        Assert.assertEquals(recruitment.getToastMessage(), "Successfully Saved");
    }

    // TC_30 Search by candidate name

    @Test(dataProvider = "CandidateSearchData", dataProviderClass = RecruitmentDataProvider.class)
    public void SearchByCandidateName(String firstName,
            String lastName,
            String email,
            String candidateSearchName,
            String candidateSearchOption) {

        LoginPage login = new LoginPage(driver);
        Dashboard_Page dashboard = new Dashboard_Page(driver);
        Recruitment_Page recruitment = new Recruitment_Page(driver);

        login.login("Admin", "admin123");

        dashboard.Click_Recruitment();

        recruitment.Navigate_To_AddCandidate();

        recruitment.Enter_FirstName_AddCandidate(firstName);
        recruitment.Enter_LastName_AddCandidate(lastName);
        recruitment.Enter_Email_AddCandidate(email);

        recruitment.Click_SaveButton_AddCandidate();

        recruitment.clickCandidatesTab();

        recruitment.Click_CandidateName_Search(candidateSearchName);
        recruitment.Select_CandidateSearch_Option(candidateSearchOption);

        recruitment.Click_SearchButton_SearchCandidate();

        recruitment.scrollDown();

        Assert.assertEquals(recruitment.getResultCandidateName(), candidateSearchOption);
    }

    // TC_32 Search by Vacancy
    @Test(dataProvider = "SearchByVacancyData", dataProviderClass = RecruitmentDataProvider.class)
    public void SearchByVacancy(
            String firstName,
            String lastName,
            String email,
            String vacancy,
            String candidateSearchName,
            String candidateSearchOption,
            String expectedVacancy) {

        try {

            LoginPage login = new LoginPage(driver);
            Dashboard_Page dashboard = new Dashboard_Page(driver);
            Recruitment_Page recruitment = new Recruitment_Page(driver);

            login.login("Admin", "admin123");

            dashboard.Click_Recruitment();

            // Add Candidate
            recruitment.Navigate_To_AddCandidate();
            recruitment.Enter_FirstName_AddCandidate(firstName);
            recruitment.Enter_LastName_AddCandidate(lastName);
            recruitment.Enter_Email_AddCandidate(email);
            recruitment.Enter_Vacancy_AddCandidate(vacancy);
            recruitment.Click_SaveButton_AddCandidate();

            // Search Candidate
            recruitment.clickCandidatesTab();
            recruitment.Click_CandidateName_Search(candidateSearchName);
            recruitment.Select_CandidateSearch_Option(candidateSearchOption);
            recruitment.Click_Vacancy_SearchCandidate(vacancy);
            recruitment.Click_SearchButton_SearchCandidate();

            recruitment.scrollDown();

            Assert.assertEquals(
                    recruitment.getResultVacancy(),
                    expectedVacancy,
                    "Vacancy search result does not match expected vacancy");

        } catch (AssertionError e) {

            Assert.fail(
                    "Search by Vacancy assertion failed: "
                            + e.getMessage());

        } catch (Exception e) {

            Assert.fail(
                    "Search by Vacancy failed due to automation error: "
                            + e.getMessage());
        }
    }

    @Test(dataProvider = "JobTitleData", dataProviderClass = RecruitmentDataProvider.class)
    public void validate_Functionality_of_JobTitle(
            String jobTitle,
            String expectedJobTitle) {

        LoginPage login = new LoginPage(driver);
        Dashboard_Page dashboard = new Dashboard_Page(driver);
        Recruitment_Page recruitment = new Recruitment_Page(driver);

        login.login("Admin", "admin123");

        dashboard.Click_Recruitment();

        recruitment.Click_Jobtitle_SearchCandidate(jobTitle);

        recruitment.Click_SearchButton_SearchCandidate();

        recruitment.scrollDown();

        Assert.assertEquals(
                recruitment.getResultVacancy(),
                expectedJobTitle);
    }

    // TC_18 reset adding candidate search

    @Test
    public void validate_Functionality_of_ResetCandidateSearch() throws Exception {

        LoginPage login = new LoginPage(driver);
        Dashboard_Page dashboard = new Dashboard_Page(driver);
        Recruitment_Page recruitment = new Recruitment_Page(driver);

        login.login("Admin", "admin123");

        dashboard.Click_Recruitment();

        recruitment.Click_CandidateName_Search("Muhammad Haris");

        recruitment.Click_resetbutton_SearchCandidate();
        recruitment.Click_resetbutton_SearchCandidate();

        Assert.assertEquals(recruitment.getCandidateSearchValue(), "");

    }
}