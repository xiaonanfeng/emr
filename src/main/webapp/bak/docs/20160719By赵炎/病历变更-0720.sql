--select * from sys_code where typeid=259;

insert into sys_code (id,code,name,typeid,flag) values(2879,100,'ҩ���ж�',259,0);
insert into sys_code (id,code,name,typeid,flag) values(2880,110,'ʳ���ж�',259,0);
update sys_code set name='�����ж�' where id=2705;
commit;

insert into sys_code (id,code,name,typeid,flag) values(2881,210,'����վ',211,0);
insert into sys_code (id,code,name,typeid,flag) values(2882,220,'δ��Ժ',211,0);
insert into sys_code (id,code,name,typeid,flag) values(2883,230,'����',211,0);
commit;

ALTER TABLE MIS_EMR_BASICINFO ADD (D_CLASSIFY  NUMBER(4));

COMMENT ON COLUMN MIS_EMR_BASICINFO.D_CLASSIFY IS '�������ࡣ�洢�����������';

Insert into SYS_CODE_TYPE
   (TYPEID, NAME,  FLAG)
 Values
   (274, '��������',   0);
COMMIT;

insert into sys_code (id,code,name,typeid,sort_id,flag) values(2884,1,'��ͨ�¹ʵ��µĸ��ִ���',274,1,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2885,2,'����ԭ���µĸ��ִ���',274,2,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2886,3,'��Ѫ��ϵͳ����',274,3,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2887,4,'��Ѫ��ϵͳ����',274,4,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2888,5,'���ಡ������Ѫѹ�����ಡ��',274,5,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2889,6,'��Ѫѹ��������Ѫѹ�����ಡ��',274,6,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2890,7,'������ϵͳ����',274,7,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2891,8,'����ϵͳ����',274,8,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2892,9,'����ϵͳ����',274,9,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2893,10,'������ֳϵͳ����',274,10,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2894,11,'����',274,11,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2895,12,'ѪҺ��ؼ���',274,12,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2896,13,'�ڷ��ڡ�Ӫ���ʹ�л����',274,13,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2897,14,'�������Ϊ�ϰ�',274,14,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2898,15,'��ٿƼ���',274,15,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2899,16,'�������ϵͳ����',274,16,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2900,17,'�����֯����',274,17,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2901,18,'��Ⱦ��',274,18,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2902,19,'�����没',274,19,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2903,20,'Ƥ����Ƥ����֯����',274,20,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2904,21,'����������',274,21,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2905,22,'����',274,22,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2906,23,'����',274,23,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2907,24,'����',274,24,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2908,25,'һ����̼�ж�',274,25,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2909,26,'�ƾ��ж�',274,26,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2910,27,'ҩ���ж�',274,27,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2911,28,'ʳ���ж�',274,28,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2912,29,'�����ж�',274,29,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2913,30,'��ˮ',274,30,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2914,31,'�����',274,31,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2915,32,'����',274,32,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2916,33,'����',274,33,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2917,34,'����',274,34,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2918,35,'����',274,35,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2919,36,'����ǰ����',274,36,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2920,37,'���Ⱥ�����',274,37,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2921,38,'����δ��ȷԭ��ļ���',274,38,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2922,39,'�����ڿƼ���',274,39,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2923,40,'������Ƽ���',274,40,0);
COMMIT;
