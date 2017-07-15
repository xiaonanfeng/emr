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
'MIS_���Ӳ���_Ժǰʩ�ȴ�ʩ���';

comment on column MIS_EMR_PREAID_STAT.ID is
'��¼ID';

comment on column MIS_EMR_PREAID_STAT.EMR_ID is
'����ID';

comment on column MIS_EMR_PREAID_STAT.PREAID_CODE is
'ʩ�ȴ�ʩ���롣�洢ʩ�ȴ�ʩ����';

comment on column MIS_EMR_PREAID_STAT.PATIENT_STAT is
'����״̬';

comment on column MIS_EMR_PREAID_STAT.PREAID_SUCCEED is
'ʩ�ȴ�ʩ���';

comment on column MIS_EMR_PREAID_STAT.SUCCEED_STAT is
'ʩ�ȴ�ʩ��������˵�';

comment on column MIS_EMR_PREAID_STAT.REASON is
'ԭ��';

comment on column MIS_EMR_PREAID_STAT.REMARK is
'��ע';

comment on column MIS_EMR_PREAID_STAT.CREATE_TIME is
'����ʱ��';

comment on column MIS_EMR_PREAID_STAT.MODIFY_USERID is
'��������';

comment on column MIS_EMR_PREAID_STAT.LAST_MODIFY_TIME is
'������ʱ��';

comment on column MIS_EMR_PREAID_STAT.XZBM is
'��������';


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
   (364, '���ֳ�ʱ����״̬', 76, 0);
   
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 1, '����״̬', 364, 1, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 2, '�ٴ�����״̬', 364, 2, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 3, '����������״̬', 364, 3, 
    0);
COMMIT;

Insert into SYS_CODE_TYPE
   (TYPEID, NAME, PARENT_TYPEID, FLAG)
 Values
   (365, 'ʩ�ȴ�ʩ���', 76, 0);
   
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 1, 'δ�ɹ�', 365, 1, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 2, '�ɹ�', 365, 2, 
    0);
COMMIT;

Insert into SYS_CODE_TYPE
   (TYPEID, NAME,  PARENT_TYPEID, FLAG)
 Values
   (366, 'ʩ�ȴ�ʩ�������', 76, 0);
   
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 1, '��ʶ�������������ָ�', 366, 1, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 2, '��ʶδ�ָ��������������ָ�', 366, 2, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 3, '��ʶ������δ�ָ��������ָ�', 366, 3, 
    0);
COMMIT;

Insert into SYS_CODE_TYPE
   (TYPEID, NAME, PARENT_TYPEID, FLAG)
 Values
   (367, '����ʧ��ԭ��', 76, 0);
   
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 1, '����ˮƽ����Ƿȱ', 367, 1, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 2, '���ⲡ��Ѫ������', 367, 2, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 3, '�����߲�����������', 367, 3, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 4, '�������أ����ߡ����¡�·;������Ӱ��', 367, 4, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 5, 'ע���þߣ��ͺ�ѡ�񲻵�������ȱ�ݣ�����', 367, 5, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 6, '����', 367, 6, 
    0);


Insert into SYS_CODE_TYPE
   (TYPEID, NAME, PARENT_TYPEID, FLAG)
 Values
   (368, '���ܲ��ʧ��ԭ��', 76, 0);
   
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 1, '����ˮƽ����Ƿȱ', 368, 1, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 2, '������������쳣', 368, 2, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 3, '�������첡���쳣', 368, 3, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 4, '�����߲�����������', 368, 4, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 5, '�������أ����ߡ��ռ䡢·;������Ӱ��', 368, 5, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 6, '����ǰ׼������(�����߲���\������λ���ѵ����ͺ�ѡ��������Ʒ����ȱ��)����', 368, 6, 
    0);
Insert into SYS_CODE
   (ID, CODE, NAME, TYPEID, SORT_ID, 
    FLAG)
 Values
   (SEQ_SYS_CODE.NEXTVAL, 7, '����', 368, 7, 
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
