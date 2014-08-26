package by.skakun.carrentalsystem.command.admin;

import by.skakun.carrentalsystem.command.ActionCommand;
import by.skakun.carrentalsystem.dao.OrderDao;
import by.skakun.carrentalsystem.dao.impl.OrderDaoImpl;
import by.skakun.carrentalsystem.exception.DAOException;
import by.skakun.carrentalsystem.util.ConfigurationManager;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 *
 * @author Skakun
 *
 * sets an order as confirmed and returns admin to page with other orders
 */
public class ConfirmCommand implements ActionCommand {

    private static final Logger LOG = Logger.getLogger(ConfirmCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        boolean flag;
        OrderDao orderDao;
        try {
            orderDao=new OrderDaoImpl();
        } catch (DAOException ex) {
            LOG.fatal("Couldn't establish the connection to the database");
            LOG.info("->errorpage");
            page = ConfigurationManager.getProperty("path.page.error");
            return page;
        }
        String appl = (String) request.getParameter("applId");
        int applId = Integer.parseInt(appl);
        try {
            flag = orderDao.confirm(applId);
        } catch (DAOException ex) {
            page = new NewOrdersCommand().execute(request);
            return page;
        }

        if (flag) {
            request.setAttribute("csuccess", "1");
            page = new NewOrdersCommand().execute(request);

        } else {
            page = new NewOrdersCommand().execute(request);
        }
        LOG.info("->neworders");
        return page;

    }

}
