/*==============================================================*/
/* Table: MIS_EMR_PREAID_STAT                                   */
/*==============================================================*/
create table MIS_EMR_PREAID_STAT 
(
   ID                   VARCHAR2(20)         not null,
   EMR_ID               VARCHAR2(20)         not null,
   PREAID_CODE          NUMBER(4),
   PATIENT_STAT         NUMBER(4),
   PREAID_SUCCEED       NUMBER(4),
   SUCCEED_STAT         NUMBER(4),
   REASON               NUMBER(4),
   REMARK               VARCHAR2(200),
   CREATE_TIME          DATE                 not null,
   MODIFY_USERID        VARCHAR2(8),
   LAST_MODIFY_TIME     DATE,
   XZBM                 NUMBER(8),
   constraint PK_MIS_EMR_PREAID_STAT primary key (ID)
)
partition by range
 (CREATE_TIME)
    interval (NUMTOYMINTERVAL(3,'MONTH'))
 (partition P1
 values less than (TO_DATE('2017-07-01','YYYY-MM-DD'))
     nocompress);

comment on table MIS_EMR_PREAID_STAT is
'MIS_电子病历_院前施救措施情况';

comment on column MIS_EMR_PREAID_STAT.ID is
'记录ID';

comment on column MIS_EMR_PREAID_STAT.EMR_ID is
'患者ID';

comment on column MIS_EMR_PREAID_STAT.PREAID_CODE is
'施救措施编码。存储施救措施编码';

comment on column MIS_EMR_PREAID_STAT.PATIENT_STAT is
'病人状态';

comment on column MIS_EMR_PREAID_STAT.PREAID_SUCCEED is
'施救措施结果';

comment on column MIS_EMR_PREAID_STAT.SUCCEED_STAT is
'施救措施结果三级菜单';

comment on column MIS_EMR_PREAID_STAT.REASON is
'原因';

comment on column MIS_EMR_PREAID_STAT.REMARK is
'备注';

comment on column MIS_EMR_PREAID_STAT.CREATE_TIME is
'创建时间';

comment on column MIS_EMR_PREAID_STAT.MODIFY_USERID is
'最后更新人';

comment on column MIS_EMR_PREAID_STAT.LAST_MODIFY_TIME is
'最后更新时间';

comment on column MIS_EMR_PREAID_STAT.XZBM is
'行政编码';


CREATE SEQUENCE SEQ_MIS_EMR_PREAID_STAT
  START WITH 1
  MAXVALUE 9999999999
  MINVALUE 0
  NOCYCLE
  NOCACHE
  NOORDER;
  
ALTER TABLE SYS_CODE MODIFY(NAME VARCHAR2(128 BYTE));
  
Insert into SYS_CODE_TYPE
   (TYPEID, NAME, PARENT_TYPEID, FLAG)
 Values
   (364, '到现场时病人状态', 76, 0);
   
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 1, '濒死状态', 364, 1, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 2, '临床死亡状态', 364, 2, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 3, '不可逆死亡状态', 364, 3, 
    0);
COMMIT;

Insert into SYS_CODE_TYPE
   (TYPEID, NAME, PARENT_TYPEID, FLAG)
 Values
   (365, '施救措施结果', 76, 0);
   
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 1, '未成功', 365, 1, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 2, '成功', 365, 2, 
    0);
COMMIT;

Insert into SYS_CODE_TYPE
   (TYPEID, NAME,  PARENT_TYPEID, FLAG)
 Values
   (366, '施救措施结果三级', 76, 0);
   
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 1, '意识、心跳及呼吸恢复', 366, 1, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 2, '意识未恢复，心跳及呼吸恢复', 366, 2, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 3, '意识及呼吸未恢复、心跳恢复', 366, 3, 
    0);
COMMIT;

Insert into SYS_CODE_TYPE
   (TYPEID, NAME, PARENT_TYPEID, FLAG)
 Values
   (367, '穿刺失败原因', 76, 0);
   
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 1, '技术水平经验欠缺', 367, 1, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 2, '特殊病患血管因素', 367, 2, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 3, '操作者不良心理因素', 367, 3, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 4, '环境因素（光线、气温、路途颠簸）影响', 367, 4, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 5, '注射用具（型号选择不当、存在缺陷）问题', 367, 5, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 6, '其他', 367, 6, 
    0);


Insert into SYS_CODE_TYPE
   (TYPEID, NAME, PARENT_TYPEID, FLAG)
 Values
   (368, '气管插管失败原因', 76, 0);
   
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 1, '技术水平经验欠缺', 368, 1, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 2, '气道先天解剖异常', 368, 2, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 3, '气道后天病理异常', 368, 3, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 4, '操作者不良心理因素', 368, 4, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 5, '环境因素（光线、空间、路途颠簸）影响', 368, 5, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 6, '操作前准备不足(喉镜光线不良\患者体位不佳导管型号选择、其他物品存在缺陷)问题', 368, 6, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 7, '其他', 368, 7, 
    0);
COMMIT;

DROP SEQUENCE SEQ_SYS_CODE_TYPE;

CREATE SEQUENCE SEQ_SYS_CODE_TYPE
  START WITH 369
  MAXVALUE 999999
  MINVALUE 0
  NOCYCLE
  NOCACHE
  NOORDER;
