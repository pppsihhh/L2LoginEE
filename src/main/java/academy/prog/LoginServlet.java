package academy.prog;

import jakarta.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    static final String LOGIN = "admin";
    static final String PASS = "12345678900";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        int ageInt = 0;

        if ("".equals(age)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("age_empty", "yes");
        } else {
            HttpSession session = request.getSession(false);
            session.removeAttribute("age_empty");
            ageInt = Integer.parseInt(age);
        }

        if (!(LOGIN.equals(login))) {
            HttpSession session = request.getSession(true);
            session.setAttribute("wrong_login", "yes");
        } else {
            HttpSession session = request.getSession(false);
            session.removeAttribute("wrong_login");
        }
        if ((password.length()) < 10){
            HttpSession session = request.getSession(true);
            session.setAttribute("small_pass", "yes");
        } else if (!(PASS.equals(password))) {
            HttpSession session = request.getSession(true);
            session.setAttribute("wrong_pass", "yes");
        } else {
            HttpSession session = request.getSession(false);
            session.removeAttribute("wrong_pass");
            session.removeAttribute("small_pass");
        }

        if ((!("".equals(age))) && LOGIN.equals(login) && PASS.equals(password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user_login", login);
            session.setAttribute("user_age", age);
            if (ageInt < 18) {
                session.setAttribute("user_older", "no");
            }
        }
        response.sendRedirect("index.jsp");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String a = request.getParameter("a");
        HttpSession session = request.getSession(false);

        if ("exit".equals(a) && (session != null) ) {
            session.removeAttribute("user_login");
            session.removeAttribute("not_age");
            session.removeAttribute("user_older");
            session.removeAttribute("wrong_login");
            session.removeAttribute("wrong_pass");
        }
        response.sendRedirect("index.jsp");
    }
}
