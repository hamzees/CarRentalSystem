package by.skakun.carrentalsystem.command.admin;

import by.skakun.carrentalsystem.command.ActionCommand;
import by.skakun.carrentalsystem.connectionpool.ConnectionPool;
import by.skakun.carrentalsystem.dao.impl.OrderDaoImpl;
import by.skakun.carrentalsystem.exception.DAOException;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 *
 * @author apple
 */
public class ReturnCommand implements ActionCommand {

    private static final Logger LOG = Logger.getLogger(ReturnCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        try {
            OrderDaoImpl applDao = new OrderDaoImpl(ConnectionPool.getConnection());
            String appl = (String) request.getParameter("applId");
            int applId = Integer.parseInt(appl);
            applDao.returnCar(applId);
            page = new PaidOrdersCommand().execute(request);
        } catch (DAOException ex) {
            LOG.info("DaoException while ReturnCommand: " + ex);
            page = new PaidOrdersCommand().execute(request);
        }
        LOG.info("->paidorders.jsp");
        return page;

    }

}