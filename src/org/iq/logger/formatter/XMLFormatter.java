package org.iq.logger.formatter;


import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import org.iq.util.StringUtil;

/**
 * @author Sam
 *
 */
public class XMLFormatter extends Formatter {
  
  //TODO

  /* (non-Javadoc)
   * @see java.util.logging.Formatter#format(java.util.logging.LogRecord)
   */
  @Override
  public String format(LogRecord record) {
    StringBuffer sb = new StringBuffer();
    sb.append("Not yet implemented..."+StringUtil.lineSeparator);
    return sb.toString();
    }

}
