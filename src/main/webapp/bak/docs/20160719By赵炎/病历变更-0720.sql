--select * from sys_code where typeid=259;

insert into sys_code (id,code,name,typeid,flag) values(2879,100,'药物中毒',259,0);
insert into sys_code (id,code,name,typeid,flag) values(2880,110,'食物中毒',259,0);
update sys_code set name='其他中毒' where id=2705;
commit;

insert into sys_code (id,code,name,typeid,flag) values(2881,210,'救助站',211,0);
insert into sys_code (id,code,name,typeid,flag) values(2882,220,'未送院',211,0);
insert into sys_code (id,code,name,typeid,flag) values(2883,230,'其他',211,0);
commit;

ALTER TABLE MIS_EMR_BASICINFO ADD (D_CLASSIFY  NUMBER(4));

COMMENT ON COLUMN MIS_EMR_BASICINFO.D_CLASSIFY IS '疾病分类。存储疾病分类编码';

Insert into SYS_CODE_TYPE
   (TYPEID, NAME,  FLAG)
 Values
   (274, '疾病分类',   0);
COMMIT;

insert into sys_code (id,code,name,typeid,sort_id,flag) values(2884,1,'交通事故导致的各种创伤',274,1,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2885,2,'其他原因导致的各种创伤',274,2,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2886,3,'脑血管系统疾病',274,3,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2887,4,'心血管系统疾病',274,4,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2888,5,'心脏病（含高血压性心脏病）',274,5,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2889,6,'高血压（不含高血压性心脏病）',274,6,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2890,7,'其他神经系统疾病',274,7,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2891,8,'呼吸系统疾病',274,8,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2892,9,'消化系统疾病',274,9,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2893,10,'泌尿生殖系统疾病',274,10,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2894,11,'肿瘤',274,11,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2895,12,'血液相关疾病',274,12,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2896,13,'内分泌、营养和代谢疾病',274,13,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2897,14,'精神和行为障碍',274,14,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2898,15,'五官科疾病',274,15,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2899,16,'肌肉骨骼系统疾病',274,16,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2900,17,'结缔组织疾病',274,17,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2901,18,'传染病',274,18,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2902,19,'寄生虫病',274,19,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2903,20,'皮肤和皮下组织疾病',274,20,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2904,21,'新生儿疾病',274,21,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2905,22,'儿科',274,22,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2906,23,'妇科',274,23,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2907,24,'产科',274,24,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2908,25,'一氧化碳中毒',274,25,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2909,26,'酒精中毒',274,26,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2910,27,'药物中毒',274,27,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2911,28,'食物中毒',274,28,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2912,29,'其他中毒',274,29,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2913,30,'溺水',274,30,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2914,31,'电击伤',274,31,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2915,32,'中暑',274,32,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2916,33,'异物',274,33,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2917,34,'烧伤',274,34,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2918,35,'冻伤',274,35,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2919,36,'抢救前死亡',274,36,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2920,37,'抢救后死亡',274,37,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2921,38,'各种未明确原因的疾病',274,38,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2922,39,'其他内科疾病',274,39,0);
insert into sys_code (id,code,name,typeid,sort_id,flag) values(2923,40,'其他外科疾病',274,40,0);
COMMIT;
