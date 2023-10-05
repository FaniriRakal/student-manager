package student.manager.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "StartupServlet", urlPatterns = {"*.s"}, loadOnStartup = 1)
public class InitServlet extends HttpServlet{
}
