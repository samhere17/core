package org.iq.logger.handler;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.iq.config.LoggerConfig;
import org.iq.util.StringUtil;

/**
 * @author Sam
 * 
 */
public final class FileHandler extends java.util.logging.FileHandler {

	private static final String LOG_FILE_LOCATION_KEY = "log.file.location";
	private static final String LOG_FILE_PATTERN_KEY = "log.file.pattern";
	private static final String LOG_FILE_SIZE_BYTES_KEY = "log.file.size.bytes";
	private static final String LOG_FILE_BACKUP_COUNT_KEY = "log.file.backup.count";
	private static final String LOG_FILE_APPEND_MODE_KEY = "log.file.append.mode";

	private static final String FILE_NAME_SUFFIX = "-%g.log";
	private static final String DEFAULT_FILE_PATTERN = LoggerConfig
			.getLoggerHome() + File.separator + "default" + FILE_NAME_SUFFIX;

	private static final int FILE_SIZE_IN_MB = 5;
	private static final int BYTE_MLTIPLIER = 1024 * 1024;
	private static final int DEFAULT_FILE_SIZE = FILE_SIZE_IN_MB * BYTE_MLTIPLIER;

	private static final int DEFAULT_BACKUP_COUNT = 5;
	
	private static final boolean DEFAULT_APPEND_MODE = true;

	public FileHandler(Map<String, String> argumentsMap)
			throws SecurityException, IOException {
		super(
				(StringUtil.isEmpty(argumentsMap.get(LOG_FILE_LOCATION_KEY)) || StringUtil
						.isEmpty(argumentsMap.get(LOG_FILE_PATTERN_KEY))) ? DEFAULT_FILE_PATTERN
						: argumentsMap.get(LOG_FILE_LOCATION_KEY)
								+ File.separator
								+ argumentsMap.get(LOG_FILE_PATTERN_KEY),
				(StringUtil.isEmpty(argumentsMap.get(LOG_FILE_SIZE_BYTES_KEY))) ? DEFAULT_FILE_SIZE
						: Integer.valueOf(argumentsMap
								.get(LOG_FILE_SIZE_BYTES_KEY)),
				(StringUtil
						.isEmpty(argumentsMap.get(LOG_FILE_BACKUP_COUNT_KEY))) ? DEFAULT_BACKUP_COUNT
						: Integer.valueOf(argumentsMap
								.get(LOG_FILE_BACKUP_COUNT_KEY)),
				(StringUtil.isEmpty(argumentsMap.get(LOG_FILE_APPEND_MODE_KEY))) ? DEFAULT_APPEND_MODE
						: Boolean.valueOf(argumentsMap
								.get(LOG_FILE_APPEND_MODE_KEY)));
	}
}