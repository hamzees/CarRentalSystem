package by.skakun.carrentalsystem.command.user;

import by.skakun.carrentalsystem.command.ActionCommand;
import by.skakun.carrentalsystem.manager.ConfigurationManager;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

public class DefineOrderCommand implements ActionCommand {

     private static final Logger LOG = Logger.getLogger(DefineOrderCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        LOG.info("DefineOrderCommand");
        String carname =  (String) request.getParameter("carName");
        String carprice =  (String) request.getParameter("carPrice");
        String carid = (String) request.getParameter("carId");
        String carimage = (String) request.getParameter("carImage");
        request.getSession().setAttribute("carId", carid);
        request.getSession().setAttribute("carName", carname);
        request.getSession().setAttribute("carImage", carimage);
        request.getSession().setAttribute("carPrice", carprice);
        LOG.info("->define-order");
        String page = ConfigurationManager.getProperty("path.page.define");
        return page;

}
}