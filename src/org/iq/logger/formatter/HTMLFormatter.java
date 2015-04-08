package org.iq.logger.formatter;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * @author Sam
 * 
 */
public class HTMLFormatter extends Formatter {
	  
	  private final static String DEFAULT_FORMAT = "%d %t %c %M %l - %m";
	  
	  private String format;

	  /**
	   * 
	   */
	  public HTMLFormatter() {
	    this.format = DEFAULT_FORMAT;
	  }
	  
	  /**
	   * 
	   */
	  /*public HTMLFormatter(String format) {
	    this.format = format;
	  }*/
	  
		public static void main(String[] args) {
			for (int i = 1; i <= 5; i++) {
				LogRecord logRecord = new LogRecord(Level.SEVERE,
						"This is a severe message #"+i+"!");

				logRecord.setLoggerName("test app");
				logRecord.setMillis(System.currentTimeMillis());
				logRecord.setParameters(new Object[] { Thread.currentThread()
						.getName() });
				logRecord.setSourceClassName(HTMLFormatter.class.getName());
				logRecord.setSourceMethodName("SourceMethodName");

				System.out.print(new HTMLFormatter().format(logRecord));

				logRecord = new LogRecord(Level.WARNING,
						"This is a warning message #"+i+"!");

				logRecord.setLoggerName("test app");
				logRecord.setMillis(System.currentTimeMillis());
				logRecord.setParameters(new Object[] { Thread.currentThread()
						.getName() });
				logRecord.setSourceClassName(HTMLFormatter.class.getName());
				logRecord.setSourceMethodName("SourceMethodName");

				System.out.print(new HTMLFormatter().format(logRecord));
			}
		}
	  
	  /* (non-Javadoc)
	   * @see java.util.logging.Formatter#format(java.util.logging.LogRecord)
	   */
	  @Override
	  public String format(LogRecord record) {
	    StringBuffer sb = new StringBuffer();
        sb.append("<tr>");
        
        sb.append("<td>");
        sb.append(dateToString(new Date(record.getMillis()), "yyyy/MM/dd"));
        sb.append("</td>");

        sb.append("<td>");
        sb.append(dateToString(new Date(record.getMillis()), "hh:mm:ss,SSS"));
        sb.append("</td>");
        
		sb.append("<td>");
		if (record.getParameters() != null) {
			sb.append(record.getParameters()[0]);
		} else {
			sb.append(record.getThreadID());
		}
		sb.append("</td>");
        
        sb.append("<td>");
        sb.append(record.getSourceClassName());
        sb.append("</td>");
        
        sb.append("<td>");
        sb.append(record.getSourceMethodName());
        sb.append("</td>");
        
        sb.append("<td>");
        sb.append(record.getLevel());
        sb.append("</td>");
        
        sb.append("<td>");
        sb.append(formatMessage(record));
        sb.append("</td>");
        
        sb.append("</tr>");

	    return sb.toString();
	  }

	  /**
	   * Converts <code>java.util.Date</code> object to <code>String</code>
	   * based on the format specified by <code>dateFormatStr</code>
	   * 
	   * @param date
	   * @param dateFormatStr
	   * @return String
	   * @throws ParseException
	   */
	  public String dateToString(Date date, String dateFormatStr) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatStr);
	    if (date == null) {
	      return null;
	    }
	    return dateFormat.format(date);
	  }
}
