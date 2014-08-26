package by.skakun.carrentalsystem.command.admin;

import by.skakun.carrentalsystem.command.ActionCommand;
import by.skakun.carrentalsystem.dao.CarDao;
import by.skakun.carrentalsystem.dao.impl.CarDaoImpl;
import by.skakun.carrentalsystem.exception.DAOException;
import by.skakun.carrentalsystem.util.ConfigurationManager;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 *
 * @author Skakun
 * 
 * deletes car / not recommended
 */
public class DeleteCarCommand implements ActionCommand {

    private static final Logger LOG = Logger.getLogger(DeleteCarCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        CarDao carDao;
        try {
            carDao = new CarDaoImpl();
        } catch (DAOException ex) {
            LOG.fatal("Couldn't establish the connection to the database");
            LOG.info("->errorpage");
            page = ConfigurationManager.getProperty("path.page.error");
            return page;
        }
        boolean flag = false;
        try {
            int id = Integer.parseInt((String) request.getParameter("carid"));
            flag = carDao.deleteCar(id);
            LOG.info(flag);
        } catch (DAOException ex) {
            LOG.info("Dao Mistake after clientDao.deleteUser(id)." + ex.getLocalizedMessage());
        }
        if (flag) {
            request.setAttribute("dsuccess", "1");
            page = ConfigurationManager.getProperty("path.page.carchange");
            return page;

        } else {
            request.setAttribute("dfail", "1");
            page = ConfigurationManager.getProperty("path.page.carchange");
            return page;
        }

    }

}
