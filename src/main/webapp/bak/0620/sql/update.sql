-- Add/modify columns 
alter table MIS_EMR_PREAID_VS add senrcd_other VARCHAR2(4000);
-- Add comments to the columns 
comment on column MIS_EMR_PREAID_VS.senrcd_other
  is '其他施救措施';
  
  
  
-- Add/modify columns 
alter table MIS_EMR_AE add ecg_other VARCHAR2(200);
-- Add comments to the columns 
comment on column MIS_EMR_AE.ecg_other
  is '其他心电图检查信息';
  
  
  