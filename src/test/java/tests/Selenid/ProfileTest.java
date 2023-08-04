package tests.Selenid;


import my.project.Selenid.EditUserProfilePopup;
import my.project.Selenid.ProfilePage;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProfileTest extends BaseTest {

    @Test
    public void profileTest() {
        loginAsTom();

        ProfilePage profilePage = new ProfilePage();
        profilePage.clickOnProfileDropdownButton();
        profilePage.clickOnProfileMenuItem();
        EditUserProfilePopup editPopup = profilePage.clickOnEditInfo();
        editPopup.setName("John")
                .setLastname("Doe")
                .clickOnUpdateButton();

        assertEquals(profilePage.getUserFullName(), "John Doe");
    }
}

