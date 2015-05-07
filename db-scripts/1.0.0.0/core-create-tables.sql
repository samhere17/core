CREATE DATABASE IF NOT EXISTS CORE;

USE CORE;

CREATE TABLE IF NOT EXISTS FORM_DETAILS (
	FORM_ID				INT NOT NULL AUTO_INCREMENT,
	FORM_NAME			VARCHAR(100) NOT NULL,
	PRIMARY KEY (FORM_ID)
);

CREATE TABLE IF NOT EXISTS FIELD_DETAILS (
	FIELD_ID			INT NOT NULL AUTO_INCREMENT,
	FIELD_NAME			VARCHAR(100) NOT NULL,
	FIELD_LABEL			VARCHAR(100) NOT NULL,
	FIELD_TYPE			VARCHAR(100) NOT NULL,
	PRIMARY KEY (FIELD_ID)
);

CREATE TABLE IF NOT EXISTS FORM_FIELD_MAP (
	FORM_ID				INT NOT NULL,
	FIELD_ID			INT NOT NULL
	FIELD_TAB_INDEX		INT,
);

CREATE TABLE IF NOT EXISTS FIELD_VALIDATIONS (
	FIELD_ID			INT NOT NULL,
	REQUIRED			TINYINT(1) NOT NULL DEFAULT 0,
	REQUIRED_MSG		VARCHAR(100),
	MIN_LENGTH			INT,
	MIN_LENGTH_MSG		VARCHAR(100),
	MAX_LENGTH			INT,
	MAX_LENGTH_MSG		VARCHAR(100),
	NUMBER				TINYINT(1) NOT NULL DEFAULT 0,
	NUMBER_MSG			VARCHAR(100),
	DIGITS				TINYINT(1) NOT NULL DEFAULT 0,
	DIGITS_MSG			VARCHAR(100),
	DATE				TINYINT(1) NOT NULL DEFAULT 0,
	DATE_MSG			VARCHAR(100),
	EMAIL				TINYINT(1) NOT NULL DEFAULT 0,
	EMAIL_MSG			VARCHAR(100),
	URL					TINYINT(1) NOT NULL DEFAULT 0,
	URL_MSG				VARCHAR(100),
	CUSTOM_FUNC_NAME	VARCHAR(50),
	CUSTOM_MSG			VARCHAR(100),
	/*remote � Requests a resource to check the element for validity.
	rangelength � Makes the element require a given value range.
	min � Makes the element require a given minimum.
	max � Makes the element require a given maximum.
	range � Makes the element require a given value range.
	dateISO � Makes the element require an ISO date.
	creditcard � Makes the element require a credit card number.
	equalTo � Requires the element to be the same as another one*/
	FOREIGN KEY (FIELD_ID) REFERENCES FIELD_DETAILS (FIELD_ID),

);

CREATE TABLE IF NOT EXISTS ORGANIZATION (
	ORGANIZATION_ID					INT NOT NULL AUTO_INCREMENT,
	ORGANIZATION_NAME				VARCHAR(100) NOT NULL,
	ORGANIZATION_ALIAS				VARCHAR(50),
	ORGANIZATION_ADDRESS_1			VARCHAR(200),
	ORGANIZATION_ADDRESS_2			VARCHAR(200),
	ORGANIZATION_CITY				VARCHAR(100),
	ORGANIZATION_DISTRICT			VARCHAR(100),
	ORGANIZATION_STATE				VARCHAR(100),
	ORGANIZATION_COUNTRY			VARCHAR(100),
	ORGANIZATION_PIN				VARCHAR(6),
	ORGANIZATION_PRIMARY_PHONE		VARCHAR(30),
	ORGANIZATION_PRIMARY_FAX		VARCHAR(30),
	ORGANIZATION_PRIMARY_EMAIL		VARCHAR(100),
	ORGANIZATION_ALTERNATE_PHONE	VARCHAR(30),
	ORGANIZATION_ALTERNATE_FAX		VARCHAR(30),
	ORGANIZATION_ALTERNATE_EMAIL	VARCHAR(100),
	ORGANIZATION_STATUS				INT(2),
	ORGANIZATION_CREATION_STAMP		DATETIME NOT NULL,
	ORGANIZATION_CREATED_BY			INT,
	ORGANIZATION_UPDATED_STAMP		DATETIME NOT NULL,
	ORGANIZATION_UPDATED_BY			INT,
	PRIMARY KEY (ORGANIZATION_ID)
);

/*CREATE TABLE IF NOT EXISTS ORGANIZATION_CONTACT (
	ORG_CONTACT_ID					INT NOT NULL AUTO_INCREMENT,
	ORGANIZATION_ID					INT NOT NULL,
	ORG_CONTACT_ACCESS_KEY			VARCHAR(50) NOT NULL UNIQUE,
	ORG_CONTACT_TYPE				INT NOT NULL,
	ORG_CONTACT_TITLE				VARCHAR(100) NOT NULL,
	ORG_CONTACT_FIRST_NAME			VARCHAR(100) NOT NULL,
	ORG_CONTACT_MIDDLE_NAME			VARCHAR(100) NOT NULL,
	ORG_CONTACT_LAST_NAME			VARCHAR(100) NOT NULL,
	ORG_CONTACT_PREFERRED_NAME		VARCHAR(100),
	ORG_CONTACT_DESIGNATION			VARCHAR(100),
	ORG_CONTACT_ADDRESS_1			VARCHAR(200) NOT NULL,
	ORG_CONTACT_ADDRESS_2			VARCHAR(200),
	ORG_CONTACT_CITY				VARCHAR(100),
	ORG_CONTACT_DISTRICT			VARCHAR(100),
	ORG_CONTACT_STATE				VARCHAR(100),
	ORG_CONTACT_COUNTRY				VARCHAR(100),
	ORG_CONTACT_PIN					VARCHAR(6),
	ORG_CONTACT_PRIMARY_PHONE		VARCHAR(30),
	ORG_CONTACT_PRIMARY_FAX			VARCHAR(30),
	ORG_CONTACT_PRIMARY_EMAIL		VARCHAR(100),
	ORG_CONTACT_ALTERNATE_PHONE		VARCHAR(30),
	ORG_CONTACT_ALTERNATE_FAX		VARCHAR(30),
	ORG_CONTACT_ALTERNATE_EMAIL		VARCHAR(100),
	ORG_CONTACT_CREATION_STAMP		TIMESTAMP NOT NULL DEFAULT NOW(),
	ORG_CONTACT_UPDATED_STAMP		TIMESTAMP NOT NULL,
	ORG_CONTACT_UPDATED_BY			INT,
	PRIMARY KEY (ORG_CONTACT_ID)
);
*/