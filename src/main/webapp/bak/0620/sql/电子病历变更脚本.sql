--“呼救原因”将原来妊娠、围产期及新生儿疾病1项分拆为妊娠、围产期和新生儿疾病2项，
update sys_code_type set name='妊娠、围产期' where typeid=257;

insert into sys_code_type (typeid,name,parent_typeid,flag) 
values (273,'新生儿疾病',255,0);

update sys_code set name='妊娠、围产期' where id=2678;

Insert into SYS_CODE (ID, CODE, NAME, TYPEID, FLAG,NOTE)
 Values(2803, 273, '新生儿疾病', 255, 0,'O-Q');

update sys_code set code=10, typeid=273 where id=2696;
update sys_code set code=20, typeid=273 where id=2697;

--“疾病类型”中增加“一氧化碳中毒”、“酒精中毒”选项（详见附件）；
Insert into SYS_CODE (ID, CODE, NAME, TYPEID, FLAG)
 Values(2804, 80, '一氧化碳中毒', 259, 0);

Insert into SYS_CODE (ID, CODE, NAME, TYPEID, FLAG)
 Values(2805, 90, '酒精中毒', 259, 0);

--删除所有下拉框中的“已查”选项。
update sys_code set flag=1 where id=2007;

commit;


-- 施救措施添加一个其他录入项 
alter table MIS_EMR_PREAID_VS add senrcd_other VARCHAR2(4000);
-- Add comments to the columns 
comment on column MIS_EMR_PREAID_VS.senrcd_other
  is '其他施救措施';
  
    
-- 心电图检查添加一个其他项 
alter table MIS_EMR_AE add ecg_other VARCHAR2(200);
-- Add comments to the columns 
comment on column MIS_EMR_AE.ecg_other
  is '其他心电图检查信息';
