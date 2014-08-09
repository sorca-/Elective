package by.boika.elective.command;

import by.boika.elective.db.dao.UserDao;
import by.boika.elective.db.pool.ConnectionPool;
import by.boika.elective.db.pool.ProxyConnection;
import by.boika.elective.resource.ConfigurationManager;
import by.boika.elective.resource.MessageManager;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String enterLogin = request.getParameter(PARAM_NAME_LOGIN);
        String enterPass = request.getParameter(PARAM_NAME_PASSWORD);

        ProxyConnection con =  ConnectionPool.getInstance().getConnection();
        UserDao userDao = new UserDao(con);
        String hashedPassword = userDao.findPassword(enterLogin);
        ConnectionPool.getInstance().putConnection(con);

        if (!hashedPassword.isEmpty() && BCrypt.checkpw(enterPass, hashedPassword)) {
            request.getSession().setAttribute("user", enterLogin);
            page = ConfigurationManager.getProperty("path.page.student");
        } else {
            request.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}
