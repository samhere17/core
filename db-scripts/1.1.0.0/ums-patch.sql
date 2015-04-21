USE UMS;

DROP TABLE UMS_OPTION;

CREATE TABLE IF NOT EXISTS UMS_OPTION (
	OPTION_ID				INT NOT NULL AUTO_INCREMENT,
	OPTION_NAME				VARCHAR(25) NOT NULL,
	OPTION_DESCRIPTION		VARCHAR(200),
	OPTION_AREA				INT(2) NOT NULL,
	OPTION_TYPE				INT(2) NOT NULL,
	OPTION_STATUS			INT(2) NOT NULL,
	OPTION_LINK				VARCHAR(200) NOT NULL DEFAULT '#',
	OPTION_IMAGE_LINK		VARCHAR(200),
	OPTION_IMAGE_ALT		VARCHAR(100),
	OPTION_ORDER			INT(2) NOT NULL DEFAULT 0,
	PARENT_OPTION_ID		INT NOT NULL,
	ENABLE_TOOLBOX			TINYINT(1),
	OBJECT_REFERENCE_KEY	VARCHAR(100),
	PRIMARY KEY (OPTION_ID)
);

INSERT INTO UMS_OPTION (OPTION_NAME, OPTION_DESCRIPTION, OPTION_AREA, OPTION_TYPE, OPTION_STATUS, OPTION_LINK, OPTION_IMAGE_LINK, OPTION_IMAGE_ALT, OPTION_ORDER, PARENT_OPTION_ID, ENABLE_TOOLBOX, OBJECT_REFERENCE_KEY) VALUES
	('Organization', '', 0, 0, 1, '#', NULL, NULL, 1, 0, 0, ''),
	('Option', '', 0, 0, 1, '#', NULL, NULL, 2, 0, 0, ''),
	('User', '', 1, 0, 1, '#', NULL, NULL, 4, 0, 0, ''),
	('Customer', '', 1, 0, 1, '#', NULL, NULL, 3, 0, 0, ''),
	('Help', '', 1, 0, 1, '#', NULL, NULL, 98, 0, 0, ''),
	('Dev Tools', '', 0, 0, 1, '#', NULL, NULL, 99, 0, 0, ''),
	('New Organization', NULL, 0, 1, 1, '__sys/org/new', NULL, NULL, 1, 1, 1, ''),
	('Search Organization', NULL, 0, 1, 1, '__sys/org/search', NULL, NULL, 2, 1, 1, ''),
	('Edit Organization', NULL, 0, 1, 1, '__sys/org/edit', NULL, NULL, 3, 1, 1, 'organization'),
	('Delete Organization', NULL, 0, 1, 1, '__sys/org/delete', NULL, NULL, 4, 1, 1, 'organization'),
	('New Option', NULL, 0, 1, 1, '__sys/opt/new&serviceName=ListOptions&listType=parent', '__sys/img/opt-add-16-16.png', NULL, 1, 2, 1, ''),
	('List Option', NULL, 0, 1, 1, '__sys/opt/list&serviceName=ListOptions', '__sys/img/opt-list-16-16.png', NULL, 2, 2, 1, ''),
	('Reorder Option', NULL, 0, 1, 1, '__sys/opt/reorder', '__sys/img/opt-reorder-16-16.png', NULL, 3, 2, 1, ''),
	('My Details', NULL, 1, 1, 1, 'ums/details&serviceName=GetUser', '__sys/img/user-details-16-16.png', NULL, 1, 3, 1, ''),
	('', NULL, 1, 2, 1, '', NULL, NULL, 2, 3, 1, ''),
	('New User', NULL, 1, 1, 1, 'ums/new&serviceName=GetNewUser', '__sys/img/user-add-16-16.png', NULL, 3, 3, 1, ''),
	('Add Multiple Users', NULL, 1, 1, 1, 'ums/mul-new', '__sys/img/user-multi-add-16-16.png', NULL, 4, 3, 1, ''),
	('Search User', NULL, 1, 1, 1, 'ums/search&serviceName=GetNewUser', '__sys/img/user-search-16-16.png', NULL, 5, 3, 1, ''),
	('Edit User', NULL, 1, 1, 1, 'ums/edit', '__sys/img/user-edit-16-16.png', NULL, 6, 3, 1, 'user'),
	('Delete User', NULL, 1, 1, 1, 'ums/delete', '__sys/img/user-delete-16-16.png', NULL, 7, 3, 1, 'user'),
	('', NULL, 1, 2, 1, '', NULL, NULL, 8, 3, 1, ''),
	('New Role', NULL, 1, 1, 1, 'ums/role/new&serviceName=ListPermissions', '__sys/img/role-add-16-16.png', NULL, 9, 3, 1, ''),
	('Search Role', NULL, 1, 1, 1, 'ums/role/search', '__sys/img/role-search-16-16.png', NULL, 10, 3, 1, ''),
	('Edit Role', NULL, 1, 1, 1, 'ums/role/edit', '__sys/img/role-edit-16-16.png', NULL, 11, 3, 1, 'role'),
	('Delete Role', NULL, 1, 1, 1, 'ums/role/delete', '__sys/img/role-delete-16-16.png', NULL, 12, 3, 1, 'role'),
	('New Customer', NULL, 1, 1, 1, 'cust/new&serviceName=GetNewCustomer', 'img/cust-add-16-16.png', NULL, 1, 4, 1, ''),
	('Search Customer', NULL, 1, 1, 1, 'cust/search&serviceName=GetNewCustomer', 'img/cust-search-16-16.png', NULL, 2, 4, 1, ''),
	('Edit Customer', NULL, 1, 1, 1, 'cust/edit', 'img/cust-edit-16-16.png', NULL, 3, 4, 1, 'customer'),
	('Delete Customer', NULL, 1, 1, 1, 'cust/delete', 'img/cust-delete-16-16.png', NULL, 4, 4, 1, 'customer'),
	('', NULL, 1, 2, 1, '', NULL, NULL, 5, 4, 1, ''),
	('Add Contact', NULL, 1, 1, 1, 'cust/contact/new', 'img/contact-add-16-16.png', NULL, 6, 4, 1, 'customer'),
	('Edit Contact', NULL, 1, 1, 1, 'cust/contact/preedit', 'img/contact-edit-16-16.png', NULL, 7, 4, 1, 'customer'),
	('Delete Contact', NULL, 1, 1, 1, 'cust/contact/predelete', 'img/contact-delete-16-16.png', NULL, 8, 4, 1, 'customer'),
	('Help Contents', NULL, 1, 1, 1, 'help/contents', '__sys/img/help-16-16.png', 'Help', 1, 5, 1, ''),
	('About', NULL, 1, 1, 1, 'help/about', '__sys/img/about-16-16.png', 'About', 2, 5, 1, ''),
	('', NULL, 1, 2, 1, '', NULL, NULL, 3, 5, 1, ''),
	('Report Bug', NULL, 1, 1, 1, 'help/bug', '__sys/img/bug-16-16.png', 'Report Bug', 4, 5, 1, ''),
	('Request Enhancement', NULL, 1, 1, 1, 'help/enhancement', '__sys/img/enhancement-16-16.png', 'Request Enhancement', 5, 5, 1, ''),
	('Contact Support', NULL, 1, 1, 1, 'help/support', '__sys/img/support-16-16.png', 'Contact Support', 6, 5, 1, ''),
	('Client Information', NULL, 0, 1, 1, '__sys/dev/info/client', '__sys/img/client-info-16-16.png', NULL, 1, 6, 1, ''),
	('Server Information', NULL, 0, 1, 1, '__sys/dev/info/server', '__sys/img/server-info-16-16.png', NULL, 2, 6, 1, ''),
	('', NULL, 0, 2, 1, '', NULL, NULL, 3, 6, 1, ''),
	('Log Viewer', NULL, 0, 1, 1, '__sys/dev/log/view', NULL, NULL, 4, 6, 1, ''),
	('', NULL, 0, 2, 1, '', NULL, NULL, 5, 6, 1, ''),
	('Cache Viewer', NULL, 0, 1, 1, '__sys/dev/cache/view&serviceName=GetCache', NULL, NULL, 6, 6, 1, ''),
	('Clear Cache', NULL, 0, 1, 1, '__sys/dev/cache/clear', NULL, NULL, 7, 6, 1, '');
