package servlet;

import dao.UserDao;
import dto.User;
import useful.PasswordAuthentication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

@WebServlet("/edit_profile")
public class EditProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        final String fullname = request.getParameter("fullname");
        final String username = request.getParameter("username");
        final String email = request.getParameter("email");
        final String birthdateString = request.getParameter("birthdate");
        final Date birthdate = birthdateString.equals("") ? null : Date.valueOf(birthdateString);
        final char[] password = request.getParameter("password").toCharArray();

        final UserDao dao = (UserDao) request.getServletContext().getAttribute("userDao");
        final int cost = (int) request.getServletContext().getAttribute("cost");

        String oldUsername = (String) request.getSession().getAttribute("username");

        User user = dao.getUserByUsername(oldUsername);
        String oldPassword = user.getPassword();
        String oldEmail = user.getEmail();
        Date oldBirthdate = user.getBirthdate();
        String oldFullname = user.getFullname();

        boolean hasChanged = false;

        User newUser = new User();

        if (!username.equals("") && !username.equals(oldUsername)) {
            newUser.setUsername(username);
            hasChanged = true;
        } else {
            newUser.setUsername(oldUsername);
        }

        PasswordAuthentication passwordAuthentication = new PasswordAuthentication(cost);
        String passwordHash = passwordAuthentication.hashPassword(password);

        if (!Arrays.equals(password, new char[]{}) && !Arrays.equals(password, "********".toCharArray()) && !passwordHash.equals(oldPassword)) {
            newUser.setPassword(passwordHash);
            hasChanged = true;
        } else {
            newUser.setPassword(oldPassword);
        }

        if (!email.equals("") && !email.equals(oldEmail)) {
            newUser.setEmail(email);
            hasChanged = true;
        } else {
            newUser.setEmail(oldEmail);
        }

        if (birthdate != null && !birthdate.equals(oldBirthdate)) {
            newUser.setBirthdate(birthdate);
            hasChanged = true;
        } else {
            newUser.setBirthdate(oldBirthdate);
        }

        if (!fullname.equals("") && !fullname.equals(oldFullname)) {
            newUser.setFullname(fullname);
            hasChanged = true;
        } else {
            newUser.setFullname(oldFullname);
        }

        if (hasChanged) {
            dao.editUser(oldUsername, newUser);
        }
        response.sendRedirect("profile");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
