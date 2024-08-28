package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        UserList userList = new UserList();
        userList.addUser("user1", "pass1");
        userList.addUser("user2", "pass2");
        userList.addUser("user3", "pass3");

        User foundUser = userList.findUserByUsername("user2");

        String expected = "user2";
        String actual = foundUser.getUsername();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        UserList userList = new UserList();
        userList.addUser("user1", "pass1");
        userList.addUser("user2", "pass2");
        userList.addUser("user3", "pass3");

        boolean isPasswordChanged = userList.changePassword("user2", "pass2", "newpass2");

        assertTrue(isPasswordChanged);
        User user = userList.findUserByUsername("user2");
        assertTrue(user.validatePassword("newpass2"));
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        UserList userList = new UserList();
        userList.addUser("user1", "pass1");
        userList.addUser("user2", "pass2");
        userList.addUser("user3", "pass3");

        User loggedInUser = userList.login("user3", "pass3");

        assertNotNull(loggedInUser);
        assertEquals("user3", loggedInUser.getUsername());
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        UserList userList = new UserList();
        userList.addUser("user1", "pass1");
        userList.addUser("user2", "pass2");
        userList.addUser("user3", "pass3");

        User loggedInUser = userList.login("user1", "wrongpass");

        assertNull(loggedInUser);
    }
}
