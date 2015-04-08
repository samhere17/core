package org.iq.logger.formatter;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.iq.util.DateUtil;
import org.iq.util.StringUtil;

/**
 * @author Sam
 * 
 */
public class TextFormatter extends Formatter {

	private final static String DEFAULT_FORMAT = "%d %t %c %M %l - %m";

	private String format;

	/**
	 * 
	 */
	public TextFormatter() {
		this.format = DEFAULT_FORMAT;
	}

	/**
	 * 
	 */
	public TextFormatter(String format) {
		this.format = format;
	}

/*	public static void main(String[] args) {
		for (int i = 1; i <= 1; i++) {
			LogRecord logRecord = new LogRecord(Level.SEVERE,
					"This is a severe message #" + i + "!");

			logRecord.setLoggerName("test app");
			logRecord.setMillis(System.currentTimeMillis());
			logRecord.setParameters(new Object[] { Thread.currentThread()
					.getName() });
			logRecord.setSourceClassName(TextFormatter.class.getName());
			logRecord.setSourceMethodName("SourceMethodName");

			System.out.print(new TextFormatter().format(logRecord));

			logRecord = new LogRecord(Level.WARNING,
					"This is a warning message #" + i + "!");

			logRecord.setLoggerName("test app");
			logRecord.setMillis(System.currentTimeMillis());
			logRecord.setParameters(new Object[] { Thread.currentThread()
					.getName() });
			logRecord.setSourceClassName(TextFormatter.class.getName());
			logRecord.setSourceMethodName("SourceMethodName");

			try {
				int re = 5 / 0;
			} catch (Exception exception) {
				logRecord.setThrown(exception);
			}

			System.out.print(new TextFormatter().format(logRecord));
		}
	}*/

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.logging.Formatter#format(java.util.logging.LogRecord)
	 */
	@Override
	public String format(LogRecord record) {
		int ix = 0;
		StringBuffer sb = new StringBuffer();
		while (ix < format.length()) {
			char ch = format.charAt(ix);
			ix++;
			char ch2 = 0;
			if (ix < format.length()) {
				ch2 = format.charAt(ix);
			}

			if (ch == '%') {
				if (ch2 == 'd') {
					sb.append(DateUtil.dateToString(new Date(record.getMillis()),
							"yyyy/MM/dd hh:mm:ss,SSS"));
					ix++;
					continue;
				} else if (ch2 == 't') {
					if (record.getParameters() != null) {
						sb.append("[" + record.getParameters()[0] + "]");
					} else {
						sb.append(record.getThreadID());
					}
					ix++;
					continue;
				} else if (ch2 == 'c') {
					sb.append(record.getSourceClassName());
					ix++;
					continue;
				} else if (ch2 == 'M') {
					sb.append(record.getSourceMethodName());
					ix++;
					continue;
				} else if (ch2 == 'l') {
					sb.append(record.getLevel());
					ix++;
					continue;
				} else if (ch2 == 'm') {
					sb.append(formatMessage(record));
					if (record.getLevel().intValue() >= Level.WARNING
							.intValue()) {
						if (record.getThrown() != null) {
							sb.append(StringUtil.lineSeparator);
							sb.append(getStackTraceString(record.getThrown()));
						}
					}
					ix++;
					continue;
				}
			}
			sb.append(ch);
		}
		sb.append(StringUtil.lineSeparator);
		return sb.toString();
	}

	/**
	 * @param throwable
	 * @return String
	 */
	private String getStackTraceString(Throwable throwable) {
		StringWriter errors = new StringWriter();
		throwable.printStackTrace(new PrintWriter(errors));
		return errors.toString();
	}
}