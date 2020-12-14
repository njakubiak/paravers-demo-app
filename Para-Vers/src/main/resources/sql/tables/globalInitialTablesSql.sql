CREATE TABLE IF NOT EXISTS TBL_ROLE (ID BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL, NAME VARCHAR(255) NOT NULL, CONSTRAINT SYS_PK_10200 PRIMARY KEY (ID))
CREATE UNIQUE INDEX IF NOT EXISTS SYS_IDX_UK_B8PDCPSSKPVGWWXU1MEY2X6DQ_10209 ON TBL_ROLE (NAME)

CREATE TABLE IF NOT EXISTS TBL_USER (ID BIGINT  GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL, PASSWORD VARCHAR(255) NOT NULL, USERNAME VARCHAR(255) NOT NULL, ROLE_ID BIGINT, CONSTRAINT SYS_PK_10205 PRIMARY KEY (ID), CONSTRAINT FKQYHP9YTKC0O8UAPY1VTQMW350 FOREIGN KEY (ROLE_ID) REFERENCES TBL_ROLE(ID))
CREATE INDEX IF NOT EXISTS SYS_IDX_FKQYHP9YTKC0O8UAPY1VTQMW350_10215 ON TBL_USER (ROLE_ID)
CREATE UNIQUE INDEX IF NOT EXISTS SYS_IDX_UK_K0BTY7TBCYE41JPXAM88Q5KJ2_10211 ON TBL_USER (USERNAME)

CREATE TABLE IF NOT EXISTS TBL_GLOBAL_PREFERENCES (ID BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL, DATA_ACCESS_MODE VARCHAR(255), INDUSTRY_TYPE VARCHAR(255), REST_END_POINT VARCHAR(255), SOAP_END_POINT VARCHAR(255), AD_ENABLED TINYINT, USE_PARASOFT_JDBC_PROXY TINYINT, PARASOFT_VIRTUALIZE_SERVER_URL VARCHAR(255), PARASOFT_VIRTUALIZE_SERVER_PATH VARCHAR(255), PARASOFT_VIRTUALIZE_GROUP_ID VARCHAR(255), CONSTRAINT SYS_PK_11066 PRIMARY KEY (ID))

CREATE TABLE IF NOT EXISTS TBL_DEMO_BUG (ID BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL, DEMO_BUGS_TYPE VARCHAR(255), GLOBAL_PREFERENCES_ID BIGINT, CONSTRAINT SYS_PK_11064 PRIMARY KEY (ID), CONSTRAINT FK8WA8F4NKGESOCNWO9J9TL4BQV FOREIGN KEY (GLOBAL_PREFERENCES_ID) REFERENCES TBL_GLOBAL_PREFERENCES(ID))
CREATE INDEX IF NOT EXISTS SYS_IDX_FK8WA8F4NKGESOCNWO9J9TL4BQV_11084 ON TBL_DEMO_BUG (GLOBAL_PREFERENCES_ID)

CREATE TABLE IF NOT EXISTS TBL_ENDPOINT (ID BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL, ROUTE_ID VARCHAR(255), ROUTE_PATH VARCHAR(255), SERVICE_ID VARCHAR(255), ROUTE_URL VARCHAR(255), STRIP_PREFIX TINYINT, RETRYABLE TINYINT, GLOBAL_PREFERENCES_ID BIGINT, CONSTRAINT SYS_PK_13052 PRIMARY KEY (ID), CONSTRAINT FK_GLOBAL_PREFERENCES_ID FOREIGN KEY (GLOBAL_PREFERENCES_ID) REFERENCES TBL_GLOBAL_PREFERENCES(ID))
CREATE INDEX IF NOT EXISTS SYS_IDX_GLOBAL_PREFERENCES_ID ON TBL_ENDPOINT (GLOBAL_PREFERENCES_ID)