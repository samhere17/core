/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.adapter;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.iq.ServiceConstants;
import org.iq.SystemContext;
import org.iq.processor.RequestProcessor;
import org.iq.processor.RequestProcessor.RequestType;
import org.iq.ums.UmsConstants;
import org.iq.ums.UmsContext;
import org.iq.util.StringUtil;

/**
 * 
 * @author Sam
 * 
 */
public class ServerAdapter extends HttpServlet {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 375299886649118252L;

	// location to store file uploaded
	private static final String	UPLOAD_DIRECTORY	= "uploads";

	// upload settings
	private static final int	MEMORY_THRESHOLD	= 1024 * 1024 * 3;		// 3MB
	private static final int	MAX_FILE_SIZE		= 1024 * 1024 * 10;		// 10MB
	private static final int	MAX_REQUEST_SIZE	= 1024 * 1024 * 20;		// 20MB

	// private String browserURL = null;
	private RequestProcessor	requestProcessor	= null;
	private Map<String, Object>	inputMap			= null;
	private Map<String, Object>	resultMap			= null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("ADAPTER STARTED SUCCESSFULLY");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http. HttpServletRequest ,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getContentType());
		processRequest(request, response, RequestType.GET);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http. HttpServletRequest ,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getContentType());
		processRequest(request, response, RequestType.POST);
	}

	/**
	 * @param request
	 * @param response
	 * @param requestType
	 * @throws IOException
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response, RequestType requestType)
			throws IOException {
		// resetting class level variables
		// browserURL = "";
		inputMap = new HashMap<String, Object>();
		resultMap = new HashMap<String, Object>();

		HttpSession httpSession = request.getSession(false);

		if(httpSession == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}

		// browserURL = resolveBrowserURL(request);

		requestProcessor = new RequestProcessor(httpSession.getId(), requestType);

		// inputMap = prepareInputMap(request);
		inputMap.putAll(prepareParameterMap(request));
		inputMap.putAll(prepareSessionMap(httpSession));

		clearSessionAttributes(httpSession);

		// processing user request
		resultMap.putAll(requestProcessor.processRequest(inputMap));

		String requestedServiceName = StringUtil
				.getStringValue(inputMap.get(ServiceConstants.REQUESTED_SERVICE_NAME_KEY));

		/*
		 * if (ServiceConstants.REFRESH_CONTEXT_SERVICE_NAME.equals(requestedServiceName)) {
		 * httpSession.removeAttribute("organization"); httpSession.removeAttribute("customer");
		 * httpSession.removeAttribute("role"); }
		 */

		if(ServiceConstants.LOGOUT_SERVICE_NAME.equals(requestedServiceName) == false) {
			// processing system request for building Menu, Toolbox etc.
			HashMap<String, Object> systemInputMap = new HashMap<String, Object>();
			systemInputMap.putAll(prepareSessionMap(httpSession));
			systemInputMap.putAll(resultMap);
			resultMap.putAll(requestProcessor.processSystemRequest(systemInputMap));

			setSessionAttributes(httpSession);
		} else {
			httpSession.invalidate();
		}

		// setSessionAttributes(httpSession);

		response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/" + getRedirectUrl()));
		// response.sendRedirect(request.getContextPath() + "/" + getRedirectUrl());
	}

	/**
	 * @return String
	 */
	/*
	 * private String resolveBrowserURL(HttpServletRequest servletRequest) { return StringUtil.getStringValue(
	 * servletRequest.getSession().getAttribute("browserURL")) .replace(servletRequest.getContextPath() + "/", ""); }
	 */

	/**
	 * @return
	 */
	/*
	 * private Map<String, Object> prepareInputMap( HttpServletRequest servletRequest) { // putting request parameters
	 * in inputMap for (Enumeration<String> e = servletRequest.getParameterNames(); e .hasMoreElements();) { String
	 * paramName = (String) e.nextElement(); Object paramValue = servletRequest.getParameter(paramName);
	 * inputMap.put(paramName, paramValue); }
	 * 
	 * // putting session parameters in inputMap HttpSession httpSession = servletRequest.getSession(); for
	 * (Enumeration<String> e = httpSession.getAttributeNames(); e .hasMoreElements();) { String attribName = (String)
	 * e.nextElement(); Object attribValue = httpSession.getAttribute(attribName); inputMap.put("session." + attribName,
	 * attribValue); }
	 * 
	 * return inputMap; }
	 */

	/**
	 * @param servletRequest
	 * @return Map<String, Object>
	 * @throws IOException
	 */
	private Map<String, Object> prepareParameterMap(HttpServletRequest servletRequest) throws IOException {

		// putting request parameters in parameterMap
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		try {

			// check if request is a file upload request, i.e., the request's
			// enctype="multipart/form-data"
			boolean isMultipart = ServletFileUpload.isMultipartContent(servletRequest);
			if(isMultipart) {
				// request is of enctype="multipart/form-data"

				// create a factory for disk-based file items
				DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
				// sets memory threshold - beyond which files are stored in disk
				diskFileItemFactory.setSizeThreshold(MEMORY_THRESHOLD);
				// sets temporary location to store files
				diskFileItemFactory.setRepository(new File(System.getProperty("java.io.tmpdir")));

				// create a new file upload handler
				ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

				// sets maximum size of upload file
				servletFileUpload.setFileSizeMax(MAX_FILE_SIZE);
				// sets maximum size of request (include file + form data)
				servletFileUpload.setSizeMax(MAX_REQUEST_SIZE);

				// constructs the directory path to store uploaded files
				// this path is relative to application's directory
				String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;

				// creates the directory if it does not exist
				File uploadDir = new File(uploadPath);
				if(!uploadDir.exists()) {
					uploadDir.mkdir();
				}

				// parses the request's content to extract file data
				List<FileItem> formItems = servletFileUpload.parseRequest(servletRequest);
				if(formItems != null && formItems.size() > 0) {
					for(FileItem formItem : formItems) {
						// check if formItem is a form field or not
						if(formItem.isFormField() == false) {
							// formItem is not a form field
							String fieldName = formItem.getFieldName();
							String fileName = new File(formItem.getName()).getName();

							File uploadedFile = new File(uploadPath + File.separator + fileName);

							// saves the file on disk
							formItem.write(uploadedFile);

							parameterMap.put(fieldName, uploadedFile.getAbsolutePath());
						} else {
							// formItem is a form field
							parameterMap.put(formItem.getFieldName(), formItem.getString());
						}
					}
				}
			} else {
				// request is of enctype="application/x-www-form-urlencoded"
				for(Enumeration<?> e = servletRequest.getParameterNames(); e.hasMoreElements();) {
					String paramName = (String) e.nextElement();
					Object paramValue = servletRequest.getParameter(paramName);
					parameterMap.put(paramName, paramValue);
				}
			}
		} catch(FileUploadException e) {
			e.printStackTrace();
			throw new IOException(e);
		} catch(Exception e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return parameterMap;
	}

	/**
	 * @param httpSession
	 * @return Map<String, Object>
	 */
	private Map<String, Object> prepareSessionMap(HttpSession httpSession) {
		// putting session parameters in inputMap
		Map<String, Object> sessionMap = new HashMap<String, Object>();
		// HttpSession httpSession = servletRequest.getSession();
		for(Enumeration<?> e = httpSession.getAttributeNames(); e.hasMoreElements();) {
			String attribName = (String) e.nextElement();
			Object attribValue = httpSession.getAttribute(attribName);
			sessionMap.put(attribName, attribValue);
		}
		return sessionMap;
	}

	/**
	 * 
	 */
	private void clearSessionAttributes(HttpSession httpSession) {
		for(Enumeration<?> e = httpSession.getAttributeNames(); e.hasMoreElements();) {
			String attrName = (String) e.nextElement();
			if(UmsConstants.UMS_SESSION_KEY.equals(attrName) == false && "customer".equals(attrName) == false
					&& "role".equals(attrName) == false && "optionsList".equals(attrName) == false
					&& "organization".equals(attrName) == false) {
				httpSession.removeAttribute(attrName);
			}
		}
	}

	/**
	 * 
	 */
	private void setSessionAttributes(HttpSession httpSession) {
		Set<String> paramNames = resultMap.keySet();
		for(String paramName : paramNames) {
			httpSession.setAttribute(paramName, resultMap.get(paramName));
		}
		
		httpSession.setAttribute("systemConfig", SystemContext.systemConfig);
		httpSession.setAttribute("umsConfig", UmsContext.umsConfig);
		
	}

	/**
	 * @return String
	 */
	private String getRedirectUrl() {
		if(resultMap != null) {
			String serviceProvidedURL = StringUtil.getStringValue(resultMap.get(ServiceConstants.REDIRECT_URL));
			if(serviceProvidedURL != null) {
				return serviceProvidedURL;
			}
		}
		return "REDIRECT_URL_NOT_PROVIDED";// browserURL;
	}
}
