package org.iq.ums.startup;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.iq.util.version.Version;

/**
 * @author Sam
 */
public class UmsStartupServlet extends GenericServlet {

  /**
   * 
   */
  private static final long serialVersionUID = 375299886649118252L;

//  private ServletContext servletContext = null;
//  private String applicationRoot = null;

  /*
   * (non-Javadoc)
   * @see javax.servlet.GenericServlet#init()
   */
  @Override
  public void init() throws ServletException {
    System.out.println("STARTING UMS "+Version.versionNumber+" ...");
//    servletContext = getServletContext();
//    applicationRoot = servletContext.getRealPath("/");

    super.init();
    /*System.out.println("INITIALIZING UMS LOGGER...");
    BaseLogger logger = BaseLogger.getLogger("UMS");
    logger.logInfo("UMS LOGGER INITIALIZED");
    System.out.println("UMS LOGGER INITIALIZED.");*/

    System.out.println("UMS APPLICATION STARTED SUCCESSFULLY");
  }
  
  /*
   * (non-Javadoc)
   * @see javax.servlet.GenericServlet#service(javax.servlet.ServletRequest,
   * javax.servlet.ServletResponse)
   */
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {

  }

  /*
   * (non-Javadoc)
   * @see javax.servlet.GenericServlet#destroy()
   */
  @Override
  public void destroy() {
    super.destroy();
  }
}