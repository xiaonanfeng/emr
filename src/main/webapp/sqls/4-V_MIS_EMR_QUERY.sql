/* Formatted on 2017/6/26 10:12:13 (QP5 v5.252.13127.32847) */
CREATE OR REPLACE FORCE VIEW V_MIS_EMR_QUERY
(
   EMRID,
   HJSJ,
   LSH,
   CCXH,
   NAME,
   SEX,
   AGE,
   STAGE,
   PHONE,
   CAUSE,
   DISEASE_TYPE,
   D_CLASSIFY,
   CONDITION,
   CREATEUSERID,
   IS_HOSPITALIZED,
   PRIM_DIAG,
   PRIM_DIAG_R,
   ID,
   SZFZ,
   CCSJ,
   PRE_EMC_RESULT,
   SENT_TO,
   IS_COMMITTED,
   SSJGDM,
   DRIVER,
   NURSE,
   CLID
)
AS
   SELECT B.ID EMRID,
          A.HJSJ,
          B.LSH,
          B.CCXH,
          B.NAME,
          B.SEX,
          B.AGE,
          B.STAGE,
          B.PHONE,
          B.CAUSE,
          B.DISEASE_TYPE,
          B.d_Classify,                                                --增加了这个
          B.CONDITION,
          B.CREATEUSERID,
          b.is_hospitalized,
          D.PRIM_DIAG,
          D.Prim_Diag_r,
          D.Doctor_Sign AS id,
          C.SZFZ,
          C.Ccsj,
          B.PRE_EMC_RESULT,
          B.Sent_To,
          B.IS_COMMITTED,
          (SELECT O.SSJGDM
             FROM SYS_ORG_INFO O
            WHERE O.ORG_ID = C.SZFZ)
             SSJGDM,
          (SELECT S.ID FROM AMBUL_OUTD_STAFF S WHERE S.LSH=B.LSH AND S.CCXH=C.CCXH AND S.LX=30) DRIVER,
          (SELECT S.ID FROM AMBUL_OUTD_STAFF S WHERE S.LSH=B.LSH AND S.CCXH=C.CCXH AND S.LX=50) NURSE,
          C.CLID
     FROM CALL_INFO A,
          AMBUL_OUTD_INFO C,
          MIS_EMR_BASICINFO B
          LEFT JOIN MIS_EMR_PREAID_VS D ON D.ID = B.ID
    WHERE     A.LSH = B.LSH
          AND B.LSH = C.LSH
          AND B.CCXH = C.CCXH;
