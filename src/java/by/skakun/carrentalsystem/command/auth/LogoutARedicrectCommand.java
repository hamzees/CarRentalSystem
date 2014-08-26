package by.skakun.carrentalsystem.command.auth;

import by.skakun.carrentalsystem.command.ActionCommand;
import by.skakun.carrentalsystem.dao.OrderDao;
import by.skakun.carrentalsystem.dao.impl.OrderDaoImpl;
import by.skakun.carrentalsystem.exception.DAOException;
import by.skakun.carrentalsystem.util.ConfigurationManager;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 *
 * @author Skakun
 *
 * processing redirect to logouta.jsp
 */
public class LogoutARedicrectCommand implements ActionCommand {

    private static final Logger LOG = Logger.getLogger(LogoutARedicrectCommand.class);

    /**
     *
     * @param request
     * @return logouta.jsp page
     */
    @Override
    public String execute(HttpServletRequest request) {
        OrderDao orderDao = null;
        List list = null;
        try {
            orderDao = new OrderDaoImpl();
        } catch (DAOException ex) {
            LOG.error(ex);
        }
        try {
            list = (ArrayList) orderDao.getNewOrders();
        } catch (DAOException ex) {
            LOG.error("DAOException while LogoutACommand", ex);
        }
        if(list.size() > 0) {
        request.setAttribute("flag", "1");
        request.setAttribute("rw", list.size());
        }
        LOG.debug("->logouta.jsp");
        String page = ConfigurationManager.getProperty("path.page.logouta");
        return page;

    }

}
