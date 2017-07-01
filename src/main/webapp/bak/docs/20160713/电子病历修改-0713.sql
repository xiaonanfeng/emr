update sys_code set sort_id=1 where id=2045;
update sys_code set sort_id=2 where id=2044;
update sys_code set sort_id=3 where id=2043;
update sys_code set sort_id=4 where id=2042;
update sys_code set sort_id=5 where id=2046;
update sys_code set sort_id=6 where id=2047;
update sys_code set sort_id=7 where id=2048;


update sys_code set sort_id=1 where id=2069;
update sys_code set sort_id=2 where id=2070;
update sys_code set sort_id=3 where id=2071;
update sys_code set sort_id=4 where id=2072;
update sys_code set sort_id=5 where id=2074;
update sys_code set sort_id=6 where id=2073;
update sys_code set sort_id=7 where id=2075;
update sys_code set sort_id=8 where id=2076;

update sys_code set sort_id=1 where id=2089;
update sys_code set sort_id=2 where id=2090;
update sys_code set sort_id=3 where id=2091;
update sys_code set sort_id=4 where id=2092;
update sys_code set sort_id=5 where id=2094;
update sys_code set sort_id=6 where id=2093;
update sys_code set sort_id=7 where id=2095;
update sys_code set sort_id=8 where id=2096;

commit;

ALTER TABLE MIS_EMR_AE ADD (BOS_TEST  NUMBER(4));

COMMENT ON COLUMN ZZ120.MIS_EMR_AE.BOS_TEST IS '血氧饱和度是否检查';

Insert into SYS_CODE (ID, CODE, NAME, TYPEID, FLAG)
 Values
   (2878, 78, '头部固定器固定', 254, 0);
COMMIT;

update sys_code set sort_id=1 where id=2654;
update sys_code set sort_id=2 where id=2669;
update sys_code set sort_id=3 where id=2658;
update sys_code set sort_id=4 where id=2655;
update sys_code set sort_id=5 where id=2656;
update sys_code set sort_id=6 where id=2667;
update sys_code set sort_id=7 where id=2668;
update sys_code set sort_id=8 where id=2657;

update sys_code set sort_id=9 where id=2659;
update sys_code set sort_id=10 where id=2666;
update sys_code set sort_id=11 where id=2670;
update sys_code set sort_id=12 where id=2671;
update sys_code set sort_id=13 where id=2660;
update sys_code set sort_id=14 where id=2661;
update sys_code set sort_id=15 where id=2662;
update sys_code set sort_id=16 where id=2663;

update sys_code set sort_id=17 where id=2664;
update sys_code set sort_id=18 where id=2797;
update sys_code set sort_id=19 where id=2878;
update sys_code set sort_id=20 where id=2665;
update sys_code set sort_id=21 where id=2672;
update sys_code set sort_id=22 where id=2673;
update sys_code set sort_id=23 where id=2674;
update sys_code set sort_id=24 where id=2675;

commit;

ALTER TABLE MIS_EMR_PREAID_VS ADD (DRUG_OTHER  VARCHAR2(800));


COMMENT ON COLUMN MIS_EMR_PREAID_VS.DRUG_OTHER IS '其他药物应用';
