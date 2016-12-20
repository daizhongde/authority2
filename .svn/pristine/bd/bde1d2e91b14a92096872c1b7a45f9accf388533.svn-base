--Export DDL from db table order modify, Must order:
--            mig_auditf_main_result>mig_auditf_detail_result    
--            mig_job_info>mig_job_content
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `mig_auditc_consistency`
-- ----------------------------
DROP TABLE IF EXISTS `mig_auditc_consistency`;
CREATE TABLE `mig_auditc_consistency` (
  `AUDIT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `AUDIT_NAME` char(30) DEFAULT NULL,
  `MIG_SQL` text NOT NULL,
  `AUTHOR` char(20) DEFAULT NULL,
  `MIG_SQL_REP` varchar(512) NOT NULL,
  PRIMARY KEY (`AUDIT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_auditc_enum_mapping`
-- ----------------------------
DROP TABLE IF EXISTS `mig_auditc_enum_mapping`;
CREATE TABLE `mig_auditc_enum_mapping` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `ENTITY` char(30) NOT NULL,
  `AUDIT_NAME` char(30) DEFAULT NULL,
  `ENUM_DESC` char(30) DEFAULT NULL,
  `SRC_ENUM` char(12) DEFAULT NULL,
  `DST_ENUM` char(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_auditc_mid_consistency`
-- ----------------------------
DROP TABLE IF EXISTS `mig_auditc_mid_consistency`;
CREATE TABLE `mig_auditc_mid_consistency` (
  `AUDIT_ID` int(11) NOT NULL,
  `AUDIT_NAME` char(30) DEFAULT NULL,
  `MIG_SQL` text,
  `AUTHOR` char(20) DEFAULT NULL,
  `MIG_SQL_REP` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`AUDIT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_auditc_report_detail_result`
-- ----------------------------
DROP TABLE IF EXISTS `mig_auditc_report_detail_result`;
CREATE TABLE `mig_auditc_report_detail_result` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `ENTITY` char(30) NOT NULL,
  `AUDIT_ITEM` char(50) DEFAULT NULL,
  `ENUM_DESC` char(50) DEFAULT NULL,
  `SPLIT_FLAG` char(10) DEFAULT NULL,
  `SRC_ENUM` char(12) DEFAULT NULL,
  `DST_ENUM` char(12) DEFAULT NULL,
  `SRC_COUNT` int(11) DEFAULT NULL,
  `DST_COUNT` int(11) DEFAULT NULL,
  `AUDIT_AUTHOR` char(20) DEFAULT NULL,
  `FARES_DRYRUN_ID` char(20) DEFAULT NULL,
  `MIN_ANALYSIS` varchar(512) DEFAULT NULL,
  `MIN_PER` char(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `mig_auditf_main_result`
-- ----------------------------
DROP TABLE IF EXISTS `mig_auditf_main_result`;
CREATE TABLE `mig_auditf_main_result` (
  `FARES_MAIN_ID` varchar(20) NOT NULL,
  `FARES_DRYRUN_ID` varchar(20) NOT NULL,
  `FARES_SERIAL` varchar(14) NOT NULL,
  `FARES_SRC_COUNT` int(11) DEFAULT NULL,
  `FARES_DST_COUNT` int(11) DEFAULT NULL,
  `FARES_SRC_PASSCNT` int(11) DEFAULT NULL,
  `FARES_KEY_PASSCNT` int(11) DEFAULT NULL,
  `FARES_SRC_MORE` int(11) DEFAULT NULL,
  `FARES_DST_MORE` int(11) DEFAULT NULL,
  `FARES_KEY_UNMATCH` int(11) DEFAULT NULL,
  `FARES_ELSE_UNMATCH` int(11) DEFAULT NULL,
  `FARES_CREATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`FARES_MAIN_ID`,`FARES_SERIAL`,`FARES_DRYRUN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_auditf_detail_result`
-- ----------------------------
DROP TABLE IF EXISTS `mig_auditf_detail_result`;
CREATE TABLE `mig_auditf_detail_result` (
  `FARES_MAIN_ID` varchar(20) DEFAULT NULL,
  `FARES_SERIAL` varchar(14) DEFAULT NULL,
  `FARES_DRYRUN_ID` varchar(20) DEFAULT NULL,
  `FARES_UNPASS_TYPE` int(11) DEFAULT NULL,
  `FARES_BITMAP` varchar(256) NOT NULL,
  `FARES_UNPASS_SRC` varchar(4000) DEFAULT NULL,
  `FARES_UNPASS_DST` varchar(4000) DEFAULT NULL,
  `FARES_CREATETIME` datetime NOT NULL,
  KEY `FK_Reference_14` (`FARES_MAIN_ID`,`FARES_SERIAL`,`FARES_DRYRUN_ID`),
  CONSTRAINT `FK_Reference_14` FOREIGN KEY (`FARES_MAIN_ID`, `FARES_SERIAL`, `FARES_DRYRUN_ID`) REFERENCES `mig_auditf_main_result` (`FARES_MAIN_ID`, `FARES_SERIAL`, `FARES_DRYRUN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_auditf_detail_result_his`
-- ----------------------------
DROP TABLE IF EXISTS `mig_auditf_detail_result_his`;
CREATE TABLE `mig_auditf_detail_result_his` (
  `FARES_MAIN_ID` varchar(20) DEFAULT NULL,
  `FARES_SERIAL` varchar(14) DEFAULT NULL,
  `FARES_DRYRUN_ID` varchar(20) DEFAULT NULL,
  `FARES_UNPASS_TYPE` int(11) NOT NULL,
  `FARES_BITMAP` varchar(256) NOT NULL,
  `FARES_UNPASS_SRC` varchar(4000) DEFAULT NULL,
  `FARES_UNPASS_DST` varchar(4000) DEFAULT NULL,
  `FARES_CREATETIME` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_auditf_main`
-- ----------------------------
DROP TABLE IF EXISTS `mig_auditf_main`;
CREATE TABLE `mig_auditf_main` (
  `FAUDIT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FAUDIT_NAME` varchar(128) DEFAULT NULL,
  `FAUDIT_SRCTABLE_NAME` varchar(128) NOT NULL,
  `FAUDIT_SRCTABLE_CONN` varchar(1024) NOT NULL,
  `FAUDIT_DSTTABLE_NAME` varchar(128) NOT NULL,
  `FAUDIT_DSTTABLE_CONN` varchar(1024) NOT NULL,
  `Author` varchar(20) NOT NULL,
  `FAUDIT_DESC` varchar(1024) DEFAULT NULL,
  `FAUDIT_CREATETIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`FAUDIT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `mig_auditf_main_result_his`
-- ----------------------------
DROP TABLE IF EXISTS `mig_auditf_main_result_his`;
CREATE TABLE `mig_auditf_main_result_his` (
  `FARES_MAIN_ID` varchar(20) NOT NULL,
  `FARES_DRYRUN_ID` varchar(20) NOT NULL,
  `FARES_SERIAL` varchar(14) NOT NULL,
  `FARES_SRC_COUNT` int(11) DEFAULT NULL,
  `FARES_DST_COUNT` int(11) DEFAULT NULL,
  `FARES_SRC_PASSCNT` int(11) DEFAULT NULL,
  `FARES_KEY_PASSCNT` int(11) DEFAULT NULL,
  `FARES_SRC_MORE` int(11) DEFAULT NULL,
  `FARES_DST_MORE` int(11) DEFAULT NULL,
  `FARES_KEY_UNMATCH` int(11) DEFAULT NULL,
  `FARES_ELSE_UNMATCH` int(11) DEFAULT NULL,
  `FARES_CREATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`FARES_MAIN_ID`,`FARES_SERIAL`,`FARES_DRYRUN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_auditf_sub`
-- ----------------------------
DROP TABLE IF EXISTS `mig_auditf_sub`;
CREATE TABLE `mig_auditf_sub` (
  `FAUDIT_MAIN_ID` varchar(20) NOT NULL,
  `FAUDIT_SUB_INDEX` int(11) NOT NULL,
  `FAUDIT_SRC_FIELD` varchar(64) NOT NULL,
  `FAUDIT_DST_FIELD` varchar(64) NOT NULL,
  `FAUDIT_ISKEY` int(11) NOT NULL DEFAULT '0',
  `FAUDIT_OPT` varchar(128) DEFAULT NULL,
  `FAUDIT_CREATETIME` datetime NOT NULL,
  `FAUDIT_MODIFYTIME` datetime DEFAULT NULL,
  `FAUDIT_STATUS` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`FAUDIT_SUB_INDEX`,`FAUDIT_MAIN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_auditf_value_map`
-- ----------------------------
DROP TABLE IF EXISTS `mig_auditf_value_map`;
CREATE TABLE `mig_auditf_value_map` (
  `FAUDIT_SRCTABLE_NAME` varchar(128) NOT NULL,
  `FAUDIT_SRC_FIELD` varchar(64) NOT NULL,
  `FAUDIT_FIELD_SRCVALUE` varchar(200) NOT NULL,
  `FAUDIT_DSTTABLE_NAME` varchar(128) NOT NULL,
  `FAUDIT_DST_FIELD` varchar(64) NOT NULL,
  `FAUDIT_FIELD_DSTVALUE` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_auditv_config`
-- ----------------------------
DROP TABLE IF EXISTS `mig_auditv_config`;
CREATE TABLE `mig_auditv_config` (
  `AUDIT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DOMAIN` char(20) DEFAULT NULL,
  `TABLE_NAME` char(200) DEFAULT NULL,
  `AUDIT_NAME` char(200) NOT NULL,
  `AUDIT_TYPE` char(4) DEFAULT NULL,
  `SQL_TYPE` char(4) DEFAULT NULL,
  `SRC_AUDIT_SQL` text NOT NULL,
  `DST_AUDIT_SQL` text,
  `AUDIT_VALUE` text NOT NULL,
  `AUDIT_FLAG` char(1) DEFAULT NULL,
  `INVALID_DATA_SQL` text,
  `OPERATOR` char(10) NOT NULL,
  `AUDIT_UNIT` char(20) DEFAULT NULL,
  `AUDIT_AUTHOR` char(20) NOT NULL,
  `REMARK` varchar(1000) DEFAULT NULL,
  `SRC_DB_CONNECT` char(40) NOT NULL,
  `DST_DB_CONNECT` char(40) DEFAULT NULL,
  `MIG_SQL_REP` varchar(512) NOT NULL,
  `VERSION` char(10) DEFAULT NULL,
  PRIMARY KEY (`AUDIT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_auditv_configcolldetail`
-- ----------------------------
DROP TABLE IF EXISTS `mig_auditv_configcolldetail`;
CREATE TABLE `mig_auditv_configcolldetail` (
  `detail_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `main_id` int(11) NOT NULL,
  `audit_id` int(11) NOT NULL,
  PRIMARY KEY (`detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_auditv_configcollmain`
-- ----------------------------
DROP TABLE IF EXISTS `mig_auditv_configcollmain`;
CREATE TABLE `mig_auditv_configcollmain` (
  `main_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `remark` varchar(1024) NOT NULL,
  PRIMARY KEY (`main_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_auditv_mid_config`
-- ----------------------------
DROP TABLE IF EXISTS `mig_auditv_mid_config`;
CREATE TABLE `mig_auditv_mid_config` (
  `AUDIT_ID` int(11) NOT NULL,
  `DOMAIN` char(20) DEFAULT NULL,
  `TABLE_NAME` char(200) DEFAULT NULL,
  `AUDIT_NAME` char(200) DEFAULT NULL,
  `AUDIT_TYPE` char(4) DEFAULT NULL,
  `SQL_TYPE` char(4) DEFAULT NULL,
  `SRC_AUDIT_SQL` text,
  `DST_AUDIT_SQL` text,
  `AUDIT_VALUE` text,
  `AUDIT_FLAG` char(1) DEFAULT NULL,
  `INVALID_DATA_SQL` text,
  `OPERATOR` char(10) DEFAULT NULL,
  `AUDIT_UNIT` char(20) DEFAULT NULL,
  `AUDIT_AUTHOR` char(20) DEFAULT NULL,
  `REMARK` varchar(1000) DEFAULT NULL,
  `SRC_DB_CONNECT` char(40) DEFAULT NULL,
  `DST_DB_CONNECT` char(40) DEFAULT NULL,
  `VERSION` char(10) DEFAULT NULL,
  PRIMARY KEY (`AUDIT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_auditv_result`
-- ----------------------------
DROP TABLE IF EXISTS `mig_auditv_result`;
CREATE TABLE `mig_auditv_result` (
  `AUDIT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FARES_DRYRUN_ID` char(20) DEFAULT NULL,
  `MIN_ANALYSIS` char(200) DEFAULT NULL,
  `DOMAIN` char(20) DEFAULT NULL,
  `TABLE_NAME` char(200) DEFAULT NULL,
  `AUDIT_NAME` char(200) DEFAULT NULL,
  `SRC_VALUE` text,
  `DST_VALUE` text,
  `MIN_VALUE` text,
  `AUDIT_UNIT` char(20) DEFAULT NULL,
  `INVALID_DATA_TABLE` varchar(100) DEFAULT NULL,
  `RESULT` int(10) DEFAULT '1',
  `AUDIT_AUTHOR` char(20) DEFAULT NULL,
  `HDATE` datetime DEFAULT NULL,
  `REMARK` varchar(1000) DEFAULT NULL,
  `SUCCESS_FLAG` int(11) DEFAULT '1',
  `ERR_MSG` text,
  `INVALID_DATA_CNT` int(11) DEFAULT NULL,
  PRIMARY KEY (`AUDIT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_codedetail_define`
-- ----------------------------
DROP TABLE IF EXISTS `mig_codedetail_define`;
CREATE TABLE `mig_codedetail_define` (
  `id` int(5) NOT NULL,
  `TYPE` varchar(64) NOT NULL,
  `code` varchar(20) NOT NULL,
  `value` varchar(254) DEFAULT NULL,
  `remark` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_codedetail_define` (`TYPE`,`code`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_com_info`
-- ----------------------------
DROP TABLE IF EXISTS `mig_com_info`;
CREATE TABLE `mig_com_info` (
  `COM_ID` char(30) NOT NULL,
  `PARA_ID` int(11) NOT NULL,
  `PARA_VALUE` text,
  PRIMARY KEY (`COM_ID`,`PARA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_com_ins`
-- ----------------------------
DROP TABLE IF EXISTS `mig_com_ins`;
CREATE TABLE `mig_com_ins` (
  `JOB_INS_ID` char(10) NOT NULL,
  `COM_ID` char(10) NOT NULL,
  `PARA_ID` int(11) NOT NULL,
  `PARA_VALUE` text,
  PRIMARY KEY (`JOB_INS_ID`,`COM_ID`,`PARA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_config_connection`
-- ----------------------------
DROP TABLE IF EXISTS `mig_config_connection`;
CREATE TABLE `mig_config_connection` (
  `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `url` varchar(512) NOT NULL COMMENT 'url',
  `remark` varchar(1024) NOT NULL COMMENT 'description',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'create time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_control_info`
-- ----------------------------
DROP TABLE IF EXISTS `mig_control_info`;
CREATE TABLE `mig_control_info` (
  `CONTROL_ID` char(10) NOT NULL,
  `CONTROL_NAME` varchar(20) DEFAULT NULL,
  `CONTROL_MARK` varchar(128) DEFAULT NULL,
  `icon_cls` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`CONTROL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_control_template`
-- ----------------------------
DROP TABLE IF EXISTS `mig_control_template`;
CREATE TABLE `mig_control_template` (
  `CONTROL_ID` char(10) NOT NULL,
  `PARA_ID` int(11) NOT NULL,
  `PARA_NAME` varchar(20) NOT NULL,
  `nullable` int(4) DEFAULT NULL,
  `IS_NUMBER` int(4) DEFAULT NULL,
  `DEF_VALUE` varchar(128) DEFAULT NULL,
  `input_type` int(4) DEFAULT NULL COMMENT 'text-1  ,textarea-2, combobox-3,date-91, time-92,datetime-93, clob-2005',
  `code_type` varchar(64) DEFAULT NULL,
  `checkrule` varchar(64) NOT NULL DEFAULT '0',
  `remark` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`CONTROL_ID`,`PARA_ID`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`CONTROL_ID`) REFERENCES `mig_control_info` (`CONTROL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_ins_config`
-- ----------------------------
DROP TABLE IF EXISTS `mig_ins_config`;
CREATE TABLE `mig_ins_config` (
  `MIG_TASK_ID` char(10) NOT NULL,
  `JOB_INS_ID` char(10) NOT NULL,
  `MIG_SRC` varchar(1024) DEFAULT NULL,
  `MIG_SRC_CONN` varchar(128) DEFAULT NULL,
  `MIG_WHERE` varchar(1024) DEFAULT NULL,
  `MIG_DST` varchar(1024) DEFAULT NULL,
  `MIG_DST_CONN` varchar(128) DEFAULT NULL,
  `MIG_AUTHOR` varchar(20) NOT NULL,
  `MIG_DESC` varchar(1024) DEFAULT NULL,
  `MIG_MODIFYTIME` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `mig_status` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_ins_para`
-- ----------------------------
DROP TABLE IF EXISTS `mig_ins_para`;
CREATE TABLE `mig_ins_para` (
  `JOB_INS_ID` char(10) NOT NULL,
  `node_ID` char(30) NOT NULL,
  `PARA` char(20) NOT NULL,
  `PARA_NAME` varchar(64) DEFAULT NULL,
  `PARA_TYPE` int(3) DEFAULT NULL,
  `PARA_VALUE` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`JOB_INS_ID`,`node_ID`,`PARA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_job_info`
-- ----------------------------
DROP TABLE IF EXISTS `mig_job_info`;
CREATE TABLE `mig_job_info` (
  `JOB_ID` char(10) NOT NULL,
  `JOB_NAME` varchar(64) NOT NULL,
  `type` int(4) unsigned DEFAULT '1',
  `JOB_AUTHOR` varchar(64) DEFAULT NULL,
  `JOB_REMARK` varchar(64) DEFAULT NULL,
  `JOB_UPDATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`JOB_ID`),
  UNIQUE KEY `UK_jobname` (`JOB_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_job_content`
-- ----------------------------
DROP TABLE IF EXISTS `mig_job_content`;
CREATE TABLE `mig_job_content` (
  `JOB_ID` char(10) NOT NULL,
  `node_ID` char(30) NOT NULL,
  `isleaf` int(3) NOT NULL DEFAULT '1',
  `node_STATUS` char(1) DEFAULT NULL,
  `PREPOS` varchar(256) DEFAULT NULL,
  `POSTPOS` varchar(256) DEFAULT NULL,
  `coords` char(9) DEFAULT NULL,
  PRIMARY KEY (`JOB_ID`,`node_ID`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`JOB_ID`) REFERENCES `mig_job_info` (`JOB_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `mig_job_ins`
-- ----------------------------
DROP TABLE IF EXISTS `mig_job_ins`;
CREATE TABLE `mig_job_ins` (
  `JOB_INS_ID` char(10) NOT NULL,
  `JOB_ID` char(10) NOT NULL,
  `JOB_INS_NAME` varchar(64) DEFAULT NULL,
  `type` int(4) unsigned DEFAULT '1',
  `STATUS` char(1) DEFAULT NULL,
  `MTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'modify time',
  `AUTHOR` varchar(64) DEFAULT NULL,
  `REMARK` varchar(20) DEFAULT NULL,
  `LOCK_STATUS` char(1) DEFAULT NULL,
  `running` int(3) DEFAULT '0',
  PRIMARY KEY (`JOB_INS_ID`),
  UNIQUE KEY `UK_jobinsname` (`JOB_INS_NAME`),
  KEY `FK_Reference_9` (`JOB_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_job_log`
-- ----------------------------
DROP TABLE IF EXISTS `mig_job_log`;
CREATE TABLE `mig_job_log` (
  `LOG_ID` char(20) NOT NULL,
  `JOB_INS_ID` char(10) DEFAULT NULL,
  `task_id` char(10) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `LOG_MSG` varchar(4096) DEFAULT NULL,
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'create time',
  `REMArk` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`LOG_ID`),
  KEY `NK_Reference_8` (`JOB_INS_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_job_para`
-- ----------------------------
DROP TABLE IF EXISTS `mig_job_para`;
CREATE TABLE `mig_job_para` (
  `node_ID` char(30) NOT NULL,
  `PARA` char(20) NOT NULL,
  `PARA_NAME` varchar(64) DEFAULT NULL,
  `PARA_TYPE` int(3) DEFAULT NULL,
  `PARA_VALUE` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`node_ID`,`PARA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_job_process`
-- ----------------------------
DROP TABLE IF EXISTS `mig_job_process`;
CREATE TABLE `mig_job_process` (
  `PROCESS_ID` char(10) NOT NULL,
  `JOB_INS_ID` char(10) NOT NULL,
  `JOB_ID` char(10) DEFAULT NULL,
  `node_id` char(30) DEFAULT NULL,
  `isleaf` int(3) DEFAULT '1',
  `node_NAME` varchar(64) DEFAULT NULL,
  `node_remark` varchar(64) DEFAULT NULL,
  `CONTROL_ID` char(10) DEFAULT NULL,
  `com_id` char(10) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `PREPOS` varchar(256) DEFAULT NULL,
  `POSTPOS` varchar(256) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `REMARK` varchar(1024) DEFAULT NULL,
  `coords` char(9) DEFAULT NULL,
  PRIMARY KEY (`PROCESS_ID`),
  KEY `FK_Reference_10` (`JOB_INS_ID`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`JOB_INS_ID`) REFERENCES `mig_job_ins` (`JOB_INS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_job_stat`
-- ----------------------------
DROP TABLE IF EXISTS `mig_job_stat`;
CREATE TABLE `mig_job_stat` (
  `LOG_ID` char(20) NOT NULL,
  `JOB_ID` char(10) DEFAULT NULL,
  `job_ins_id` char(10) DEFAULT NULL,
  `BEGIN_TIME` datetime DEFAULT NULL,
  `END_TIME` datetime DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `REMArk` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_task_config`
-- ----------------------------
DROP TABLE IF EXISTS `mig_task_config`;
CREATE TABLE `mig_task_config` (
  `MIG_config_id` int(8) NOT NULL AUTO_INCREMENT,
  `MIG_config_type` int(4) NOT NULL,
  `MIG_SRC` varchar(1024) DEFAULT NULL,
  `MIG_SRC_CONN` varchar(128) DEFAULT NULL,
  `MIG_WHERE` varchar(1024) DEFAULT NULL,
  `MIG_DST` varchar(1024) DEFAULT NULL,
  `MIG_DST_CONN` varchar(128) DEFAULT NULL,
  `MIG_AUTHOR` varchar(20) NOT NULL,
  `MIG_DESC` varchar(1024) DEFAULT NULL,
  `MIG_MODIFYTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `mig_status` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`MIG_config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `mig_task_info`
-- ----------------------------
DROP TABLE IF EXISTS `mig_task_info`;
CREATE TABLE `mig_task_info` (
  `TASK_ID` char(30) NOT NULL,
  `TASK_NAME` varchar(64) DEFAULT NULL,
  `TASK_AUTHOR` varchar(64) DEFAULT NULL,
  `TASK_REMARK` varchar(64) DEFAULT NULL,
  `TASK_UPDATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `CONTROL_ID` char(10) DEFAULT NULL,
  `com_id` char(10) DEFAULT NULL,
  PRIMARY KEY (`TASK_ID`),
  KEY `FK_Reference_11` (`CONTROL_ID`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`CONTROL_ID`) REFERENCES `mig_control_info` (`CONTROL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `t_authority_inst`
-- ----------------------------
DROP TABLE IF EXISTS `t_authority_inst`;
CREATE TABLE `t_authority_inst` (
  `N_IID` int(8) NOT NULL AUTO_INCREMENT COMMENT '��ID',
  `C_ICODE` varchar(9) NOT NULL COMMENT '�����',
  `C_INAME` varchar(120) NOT NULL COMMENT '�����',
  `N_ILEVEL` decimal(3,0) NOT NULL COMMENT '����|0�㼶����(Ψһ)��1һ����2������3��...',
  `C_ILEAF` varchar(5) NOT NULL COMMENT '�Ƿ�ĩ��|default ''true''',
  `N_ITYPE` decimal(3,0) NOT NULL COMMENT '������|1:ʡ��˾,2:�й�˾,3:ʡ��������,4:վ��,5:��Ͷ��,6:��Ӫҵ��',
  `N_ISUPERIOR` decimal(8,0) DEFAULT NULL COMMENT '�ϼ���|0������ϼ����ǿ�',
  `C_IMANAGER` varchar(30) DEFAULT NULL COMMENT '���쵼',
  `C_IMTEL` varchar(20) DEFAULT NULL COMMENT '�쵼�绰',
  `C_IMEMAIL` varchar(30) DEFAULT NULL COMMENT '�쵼����',
  `C_IMQQ` varchar(10) DEFAULT NULL COMMENT '�쵼QQ',
  `C_ILINKMAN` varchar(30) DEFAULT NULL COMMENT '����ϵ��',
  `C_ILTEL` varchar(20) DEFAULT NULL COMMENT '��ϵ�˵绰',
  `C_ILEMAIL` varchar(30) DEFAULT NULL COMMENT '��ϵ������',
  `C_ILQQ` varchar(10) DEFAULT NULL COMMENT '��ϵ��QQ',
  `C_IADDRESS` varchar(120) DEFAULT NULL COMMENT '���ַ',
  `C_IDESCRIPTION` text COMMENT '������',
  `C_ICTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  `C_ICIP` varchar(60) DEFAULT NULL COMMENT '������IP',
  `C_ICREATOR` varchar(24) DEFAULT NULL COMMENT '������',
  `C_IMTIME` datetime DEFAULT NULL COMMENT '����޸�ʱ��',
  `C_IMIP` varchar(60) DEFAULT NULL COMMENT '����޸���IP',
  `C_IMODIFIER` varchar(24) DEFAULT NULL COMMENT '����޸���',
  `C_IONS` char(1) DEFAULT NULL COMMENT '����״̬|(0:δ����;1:����;)',
  `C_IONT` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`N_IID`),
  KEY `N_ISUPERIOR` (`N_ISUPERIOR`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `t_authority_level`
-- ----------------------------
DROP TABLE IF EXISTS `t_authority_level`;
CREATE TABLE `t_authority_level` (
  `N_LID` decimal(4,0) NOT NULL COMMENT '����',
  `C_LNAME` varchar(90) NOT NULL COMMENT '�������',
  `C_LNOTE` text COMMENT '��ע',
  PRIMARY KEY (`N_LID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Ȩ�޼����';

-- ----------------------------
-- Table structure for `t_authority_module`
-- ----------------------------
DROP TABLE IF EXISTS `t_authority_module`;
CREATE TABLE `t_authority_module` (
  `N_MID` int(8) NOT NULL AUTO_INCREMENT COMMENT 'ģ��ID',
  `C_MNAME` varchar(90) NOT NULL COMMENT 'ģ�����',
  `N_MLEVEL` decimal(4,0) NOT NULL COMMENT 'ģ�鼶��|0�㼶����(Ψһ)��1һ���˵���2�����˵���3��˵�...',
  `C_MLEAF` varchar(5) NOT NULL DEFAULT 'true' COMMENT 'ģ������|true:Ҷ�ӽڵ� is leaf,false:Ŀ¼is not leaf,directory',
  `N_MPARENT` decimal(8,0) DEFAULT NULL COMMENT '�ϼ�ģ��|0��ģ����ϼ�ģ��Ϊ��',
  `N_MORDER` decimal(4,0) NOT NULL COMMENT 'ģ������',
  `C_MTARGET` varchar(3) NOT NULL DEFAULT 'R' COMMENT 'ģ������Ŀ��|''R'':right frame(��basefrm��);''B'':new window;''T'':current browser window;''S'':current frame.',
  `C_MICONCLS` varchar(30) DEFAULT NULL COMMENT 'ģ��ͼ����ʽ',
  `C_MEXPANDED` varchar(5) NOT NULL DEFAULT 'true' COMMENT 'ģ����չ��״̬',
  `C_MCHECKED` varchar(5) NOT NULL DEFAULT 'false' COMMENT 'ģ�����Ƿ�ѡ��',
  `C_MPATH` varchar(180) DEFAULT NULL COMMENT 'ģ��url·��',
  `C_MNOTE` text COMMENT '��ע',
  `C_MCTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'ģ�鴴��ʱ��',
  `C_MCIP` varchar(60) DEFAULT NULL COMMENT 'ģ�鴴���ߴ���ʱ��ʹ�õ�IP',
  `C_MCREATOR` varchar(24) DEFAULT NULL COMMENT 'ģ�鴴����',
  `C_MMTIME` datetime DEFAULT NULL COMMENT 'ģ���޸�ʱ��,M �������Զ�д��',
  `C_MMIP` varchar(60) DEFAULT NULL COMMENT 'ģ�������޸���ʹ�õ�IP',
  `C_MMODIFIER` varchar(24) DEFAULT NULL COMMENT 'ģ�����һ�εĸ��޸���',
  `C_MONS` char(1) NOT NULL DEFAULT '1' COMMENT '����״̬|(0:δ����;1:����;)',
  `C_MONT` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`N_MID`),
  UNIQUE KEY `UK_AUTHORITY_MODULE_NAME` (`C_MNAME`),
  KEY `N_MPARENT` (`N_MPARENT`)
) ENGINE=MyISAM AUTO_INCREMENT=10072 DEFAULT CHARSET=utf8 COMMENT='ģ����Ϣ��';

-- ----------------------------
-- Table structure for `t_authority_rmrelation`
-- ----------------------------
DROP TABLE IF EXISTS `t_authority_rmrelation`;
CREATE TABLE `t_authority_rmrelation` (
  `N_RID` decimal(3,0) NOT NULL COMMENT '��ɫID',
  `N_MID` decimal(8,0) NOT NULL COMMENT 'ģ��ID',
  `C_CTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '�ҽ�ʱ��',
  `C_CIP` varchar(60) DEFAULT NULL COMMENT '�ҽ�����ʹ�õ�IP',
  `C_CREATOR` varchar(24) DEFAULT NULL COMMENT '�ҽ���',
  PRIMARY KEY (`N_RID`,`N_MID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='��ɫģ���ϵ��';

-- ----------------------------
-- Table structure for `t_authority_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_authority_role`;
CREATE TABLE `t_authority_role` (
  `N_RID` int(3) NOT NULL AUTO_INCREMENT COMMENT '��ɫID|PK',
  `C_RNO` char(3) NOT NULL COMMENT '��ɫ���|UK',
  `C_RNAME` varchar(60) NOT NULL COMMENT '��ɫ���',
  `N_RLEVEL` decimal(3,0) NOT NULL COMMENT '��ɫ����(�����ϼ�ģ��)',
  `C_RNOTE` text COMMENT 'ע��',
  `C_RCTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '����ʱ��',
  `C_RCIP` varchar(60) DEFAULT NULL COMMENT '������IP',
  `C_RCREATOR` varchar(24) DEFAULT NULL COMMENT '������',
  `C_RONS` char(1) NOT NULL DEFAULT '1' COMMENT '����״̬|(0:δ����;1:����;)',
  `C_RONT` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`N_RID`),
  UNIQUE KEY `UK_rolename` (`C_RNAME`),
  KEY `N_RLEVEL` (`N_RLEVEL`)
) ENGINE=MyISAM AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COMMENT='��ɫ��Ϣ��';

-- ----------------------------
-- Table structure for `t_authority_urrelation`
-- ----------------------------
DROP TABLE IF EXISTS `t_authority_urrelation`;
CREATE TABLE `t_authority_urrelation` (
  `N_UID` decimal(8,0) NOT NULL COMMENT '�û�ID',
  `N_RID` decimal(3,0) NOT NULL COMMENT '��ɫID',
  `C_CTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '�ҽ�ʱ��',
  `C_CIP` varchar(60) DEFAULT NULL COMMENT '�ҽ�����ʹ�õ�IP',
  `C_CREATOR` varchar(24) DEFAULT NULL COMMENT '�ҽ�����ʹ�õ�IP',
  PRIMARY KEY (`N_UID`,`N_RID`),
  KEY `N_RID` (`N_RID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='�û���ɫ��ϵ��';

-- ----------------------------
-- Table structure for `t_authority_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_authority_user`;
CREATE TABLE `t_authority_user` (
  `N_UID` int(8) NOT NULL AUTO_INCREMENT COMMENT '�û�ID',
  `C_ULOGNAME` varchar(24) NOT NULL COMMENT '�û���½��',
  `C_UNAME` varchar(90) NOT NULL COMMENT '�û�����',
  `C_UPASSWORD` varchar(40) NOT NULL COMMENT '����',
  `C_USEX` char(6) NOT NULL COMMENT '�Ա�',
  `C_UPHONE` varchar(15) DEFAULT NULL COMMENT '�ֻ����',
  `C_UTEL` varchar(15) DEFAULT NULL COMMENT '�칫����',
  `C_UFAX` varchar(15) DEFAULT NULL COMMENT '�������',
  `C_UEMAIL` varchar(40) DEFAULT NULL COMMENT '��������',
  `C_UQQ` varchar(10) DEFAULT NULL COMMENT 'QQ',
  `C_UADDR` varchar(120) DEFAULT NULL COMMENT '�û���ַ',
  `C_UNOTE` text COMMENT 'ע��',
  `N_IID` decimal(9,0) DEFAULT NULL COMMENT '��ID',
  `N_DID` decimal(9,0) DEFAULT NULL COMMENT '����ID',
  `C_UCTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '�û�����ʱ��',
  `C_UCIP` varchar(60) DEFAULT NULL COMMENT '�û������ߴ���ʱ����IP',
  `C_UCREATOR` varchar(24) DEFAULT NULL COMMENT '�û�������',
  `C_UMTIME` datetime DEFAULT NULL COMMENT '������ʱ��',
  `C_UMIP` varchar(60) DEFAULT NULL COMMENT '����޸���IP',
  `C_UMODIFIER` varchar(24) DEFAULT NULL COMMENT '����޸���Ϣ����',
  `C_UONS` char(1) NOT NULL DEFAULT '1' COMMENT '����״̬|(0:δ����;1:����;)',
  `C_UONT` datetime DEFAULT NULL COMMENT '����ʱ��',
  `C_LOGINS` char(1) NOT NULL DEFAULT '0' COMMENT '��½״̬|''0''����;''1''����',
  `C_LOGINIP` varchar(60) DEFAULT NULL COMMENT '���һ�ε�½IP',
  `C_LOGINT` datetime DEFAULT NULL COMMENT '���һ�ε�½ʱ��',
  `C_LOGOUTT` datetime DEFAULT NULL COMMENT '���һ���˳�ʱ��',
  PRIMARY KEY (`N_UID`),
  UNIQUE KEY `UK_userlogname` (`C_ULOGNAME`)
) ENGINE=MyISAM AUTO_INCREMENT=9910 DEFAULT CHARSET=utf8 COMMENT='�û���Ϣ��';

-- ----------------------------
-- Table structure for `t_pub_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_dictionary`;
CREATE TABLE `t_pub_dictionary` (
  `id` int(8) NOT NULL,
  `code` varchar(20) NOT NULL,
  `value` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `parentid` int(8) DEFAULT NULL,
  `version` int(8) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_pub_dictionary` (`code`,`type`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `t_pub_seqtable`
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_seqtable`;
CREATE TABLE `t_pub_seqtable` (
  `seq_name` varchar(30) NOT NULL COMMENT '������(���)',
  `seq_value` int(10) NOT NULL DEFAULT '1' COMMENT '��ǰֵ',
  `seq_time` varchar(10) DEFAULT NULL COMMENT '����',
  `prefix` char(2) DEFAULT NULL COMMENT 'ǰ׺',
  PRIMARY KEY (`seq_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='���б�,����ҪСд';
