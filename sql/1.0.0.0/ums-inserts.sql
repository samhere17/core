/******************************************************************************
 * Insert Statements for creating Option entries
 *******************************************************************************/
USE UMS;

/*Inserting Menu and Menu Items for Options*/
INSERT INTO UMS_OPTION (OPTION_NAME, OPTION_DESCRIPTION, OPTION_TYPE, OPTION_AREA, OPTION_STATUS, OPTION_LINK, OPTION_ICON, OPTION_ORDER, PARENT_OPTION_ID, OBJECT_REFERENCE_KEY) VALUES
	('Option', NULL, 0, 0, 1, '#', 'pencil', 96, 0, NULL);

SET @last_id_in_ums_option = LAST_INSERT_ID();

INSERT INTO UMS_OPTION (OPTION_NAME, OPTION_DESCRIPTION, OPTION_TYPE, OPTION_AREA, OPTION_STATUS, OPTION_LINK, OPTION_ICON, OPTION_ORDER, PARENT_OPTION_ID, OBJECT_REFERENCE_KEY) VALUES
	('New Option', NULL, 1, 1, 1, 'ums/opt/new&serviceName=ListOptions&listType=parent', 'plus', 1, @last_id_in_ums_option, NULL),
	('List Option', NULL, 1, 1, 1, 'ums/opt/list&serviceName=ListOptions', 'list-ol', 2, @last_id_in_ums_option, NULL),
	('Reorder Option', NULL, 1, 1, 1, 'ums/opt/reorder&serviceName=ListOptions', 'reorder', 3, @last_id_in_ums_option, NULL);

/*Inserting Menu and Menu Items for User*/
INSERT INTO UMS_OPTION (OPTION_NAME, OPTION_DESCRIPTION, OPTION_TYPE, OPTION_AREA, OPTION_STATUS, OPTION_LINK, OPTION_ICON, OPTION_ORDER, PARENT_OPTION_ID, OBJECT_REFERENCE_KEY) VALUES
	('User', NULL, 0, 0, 1, '#', 'user', 97, 0, NULL);

SET @last_id_in_ums_option = LAST_INSERT_ID();

INSERT INTO UMS_OPTION (OPTION_NAME, OPTION_DESCRIPTION, OPTION_TYPE, OPTION_AREA, OPTION_STATUS, OPTION_LINK, OPTION_ICON, OPTION_ORDER, PARENT_OPTION_ID, OBJECT_REFERENCE_KEY) VALUES
	('My Details', NULL, 1, 1, 1, 'ums/details&serviceName=GetUser', NULL, 1, @last_id_in_ums_option, NULL),
	('', NULL, 2, 1, 1, '', NULL, 2, @last_id_in_ums_option, NULL),
	('New User', NULL, 1, 1, 1, 'ums/new&serviceName=GetNewUser', 'plus', 3, @last_id_in_ums_option, NULL),
	('New Multiple Users', NULL, 1, 1, 1, 'ums/newmultiple&serviceName=GetNewUser', 'plus', 4, @last_id_in_ums_option, NULL),
	('Search User', NULL, 1, 1, 1, 'ums/search&serviceName=GetNewUser', 'search', 5, @last_id_in_ums_option, NULL),
	/*('Edit User', NULL, 1, 1, 1, 'ums/edit', NULL, 6, @last_id_in_ums_option, NULL),
	('Delete User', NULL, 1, 1, 1, 'ums/delete', NULL, 7, @last_id_in_ums_option, NULL),*/
	('', NULL, 2, 1, 1, '', NULL, 6, @last_id_in_ums_option, NULL),
	('New Role', NULL, 1, 1, 1, 'ums/role/new&serviceName=ListPermissions', 'plus', 7, @last_id_in_ums_option, NULL),
	('Search Role', NULL, 1, 1, 1, 'ums/role/search', 'search', 8, @last_id_in_ums_option, NULL);
	/*('Edit Role', NULL, 1, 1, 1, 'ums/role/edit', NULL, 11, @last_id_in_ums_option, 'role'),
	('Delete Role', NULL, 1, 1, 1, 'ums/role/delete', NULL, 12, @last_id_in_ums_option, 'role'),*/

/*Inserting Menu and Menu Items for Help*/
INSERT INTO UMS_OPTION (OPTION_NAME, OPTION_DESCRIPTION, OPTION_TYPE, OPTION_AREA, OPTION_STATUS, OPTION_LINK, OPTION_ICON, OPTION_ORDER, PARENT_OPTION_ID, OBJECT_REFERENCE_KEY) VALUES
	('Help', NULL, 0, 1, 1, '#', 'question', 98, 0, NULL);

SET @last_id_in_ums_option = LAST_INSERT_ID();

INSERT INTO UMS_OPTION (OPTION_NAME, OPTION_DESCRIPTION, OPTION_TYPE, OPTION_AREA, OPTION_STATUS, OPTION_LINK, OPTION_ICON, OPTION_ORDER, PARENT_OPTION_ID, OBJECT_REFERENCE_KEY) VALUES
	('Help Contents', NULL, 1, 1, 1, 'help/contents', 'list-ol', 1, @last_id_in_ums_option, NULL),
	('About', NULL, 1, 1, 1, 'help/about', NULL, 2, @last_id_in_ums_option, NULL),
	('', NULL, 2, 1, 1, '', NULL, 3, @last_id_in_ums_option, NULL),
	('Report Bug', NULL, 1, 1, 1, 'help/bug', 'bug', 4, @last_id_in_ums_option, NULL),
	('Request Enhancement', NULL, 1, 1, 1, 'help/enhancement', NULL, 5, @last_id_in_ums_option, NULL),
	('', NULL, 2, 1, 1, '', NULL, 6, @last_id_in_ums_option, NULL),
	('Contact Support', NULL, 1, 1, 1, 'help/support', 'life-ring', 7, @last_id_in_ums_option, NULL);

/*Inserting Menu and Menu Items for Dev Tools*/
INSERT INTO UMS_OPTION (OPTION_NAME, OPTION_DESCRIPTION, OPTION_TYPE, OPTION_AREA, OPTION_STATUS, OPTION_LINK, OPTION_ICON, OPTION_ORDER, PARENT_OPTION_ID, OBJECT_REFERENCE_KEY) VALUES
	('Dev Tools', NULL, 0, 0, 1, '#', 'code', 99, 0, NULL);

SET @last_id_in_ums_option = LAST_INSERT_ID();

INSERT INTO UMS_OPTION (OPTION_NAME, OPTION_DESCRIPTION, OPTION_TYPE, OPTION_AREA, OPTION_STATUS, OPTION_LINK, OPTION_ICON, OPTION_ORDER, PARENT_OPTION_ID, OBJECT_REFERENCE_KEY) VALUES
	('Client Information', NULL, 1, 1, 1, 'dev/info/client', 'desktop', 1, @last_id_in_ums_option, NULL),
	('Server Information', NULL, 1, 1, 1, 'dev/info/server', 'server', 2, @last_id_in_ums_option, NULL),
	('', NULL, 2, 1, 1, '', NULL, 3, @last_id_in_ums_option, NULL),
	('Log Viewer', NULL, 1, 1, 1, 'dev/log/view', NULL, 4, @last_id_in_ums_option, NULL),
	('', NULL, 2, 1, 1, '', NULL, 5, @last_id_in_ums_option, NULL),
	('Cache Viewer', NULL, 1, 1, 1, 'dev/cache/view&serviceName=GetCache', NULL, 6, @last_id_in_ums_option, NULL),
	('Clear Cache', NULL, 1, 1, 1, 'dev/cache/clear', NULL, 7, @last_id_in_ums_option, NULL);


/******************************************************************************
 * Insert Statements for creating Role entries
 *******************************************************************************/
USE UMS;

INSERT INTO UMS_ROLE (ROLE_NAME, ROLE_DESCRIPTION, ROLE_AREA, ROLE_STATUS, ROLE_CREATION_TIME, ROLE_CREATED_BY, ROLE_UPDATED_TIME, ROLE_UPDATED_BY) VALUES
	('Super Admin', 'This is a role for the super admins', 0, 1, NOW(), 0, NOW(), 0),
	('Admin', 'This is a role for the admins', 1, 1, NOW(), 1, NOW(), 1),
	('Manager', 'This is a role for the managers', 1, 1, NOW(), 1, NOW(), 1),
	('Executive', 'This is a role for the executives', 1, 1, NOW(), 1, NOW(), 1);


/******************************************************************************
 * Insert Statements for creating Role and Option mappings.
 * The below should be run after creating all Options and Roles needed by the
 * application.
 *******************************************************************************/
USE UMS;

DELETE FROM UMS_ROLE_OPTION_MAP;

/* removing procedure if exists... */
DROP PROCEDURE IF EXISTS insert_role_option_mappings;

/* setting delimiter */
DELIMITER $$

/* creating procedure */
CREATE PROCEDURE insert_role_option_mappings()
BEGIN
	DECLARE done INT DEFAULT FALSE;
	DECLARE v_role_id INT;
	DECLARE role_max_id INT;
	DECLARE v_option_id INT;
	DECLARE option_max_id INT;
	DECLARE max_role_id_cursor CURSOR FOR SELECT MAX(ROLE_ID) FROM UMS_ROLE;
	DECLARE max_option_id_cursor CURSOR FOR SELECT MAX(OPTION_ID) FROM UMS_OPTION;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
	SET v_role_id=1;
	SET v_option_id=1;
	OPEN max_role_id_cursor;
	OPEN max_option_id_cursor;
	read_loop:
		LOOP
			FETCH max_role_id_cursor INTO role_max_id;
			FETCH max_option_id_cursor INTO option_max_id;
			IF done THEN
				LEAVE read_loop;
			END IF;
			
			START TRANSACTION;
			WHILE(v_role_id <= role_max_id) DO
				WHILE(v_option_id <= option_max_id) DO
					IF v_role_id = 1 THEN
						INSERT INTO UMS_ROLE_OPTION_MAP (ROLE_ID, OPTION_ID, ENABLE) VALUES (v_role_id,v_option_id,1);
					ELSE
						INSERT INTO UMS_ROLE_OPTION_MAP (ROLE_ID, OPTION_ID, ENABLE) VALUES (v_role_id,v_option_id,0);
					END IF;
					SET v_option_id=(v_option_id+1);
				END WHILE;
				SET v_role_id=(v_role_id+1);
				SET v_option_id=1;
			END WHILE;
			COMMIT;
		END LOOP;
	CLOSE max_role_id_cursor;
	CLOSE max_option_id_cursor;
END $$

/* resetting delimiter */
DELIMITER ;

/* calling procedure */
CALL insert_role_option_mappings();
