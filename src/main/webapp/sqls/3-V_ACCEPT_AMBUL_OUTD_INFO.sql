/* Formatted on 2017/6/27 17:03:57 (QP5 v5.252.13127.32847) */
CREATE OR REPLACE FORCE VIEW V_ACCEPT_AMBUL_OUTD_INFO
(
   LSH,
   JCDZ,
   SWYY,
   SWDD,
   DDYID,
   SLSJ,
   LXDH,
   HZXM,
   HZXB,
   NL,
   HJSJ,
   CLID,
   CCXH,
   SZFZ,
   PCSJ,
   CCSJ,
   DDXCSJ,
   DBRSBSJ,
   SCSJ,
   SWSJ,
   WCSJ,
   FZSJ,
   TSQK,
   HZRS,
   BZ,
   YSID,
   SSJGDM,
   XZBM,
   DOCTOR,
   DRIVER,
   NURSE
)
AS
   SELECT A.LSH,
          A.JCDZ,
          A.SWYY,
          A.SWDD,
          A.DDYID,
          A.SLSJ,
          A.LXDH,
          A.HZXM,
          A.HZXB,
          A.NL,
          C.HJSJ,
          O.CLID,
          O.CCXH,
          O.SZFZ,
          O.PCSJ,
          O.CCSJ,
          O.DDXCSJ,
          O.DBRSBSJ,
          O.SCSJ,
          O.SWSJ,
          O.WCSJ,
          O.FZSJ,
          O.TSQK,
          (SELECT COUNT (1)
             FROM MIS_EMR_BASICINFO B
            WHERE B.LSH = O.LSH AND B.CCXH = O.CCXH)
             HZRS,
          O.BZ,
          (SELECT ID
             FROM AMBUL_OUTD_STAFF S
            WHERE S.LSH = A.LSH AND S.CCXH = O.CCXH AND S.LX = 40)
             YSID,
          J.SSJGDM,
          O.XZBM,
          (SELECT M.NAME FROM SYS_MEMBER_INFO M,AMBUL_OUTD_STAFF S WHERE M.ID=S.ID AND S.LSH=O.LSH AND S.CCXH=O.CCXH AND S.LX=40) DOCTOR,
          (SELECT M.NAME FROM SYS_MEMBER_INFO M,AMBUL_OUTD_STAFF S WHERE M.ID=S.ID AND S.LSH=O.LSH AND S.CCXH=O.CCXH AND S.LX=30) DRIVER,
          (SELECT M.NAME FROM SYS_MEMBER_INFO M,AMBUL_OUTD_STAFF S WHERE M.ID=S.ID AND S.LSH=O.LSH AND S.CCXH=O.CCXH AND S.LX=50) NURSE       
     FROM ACCEPT_INFO A,
          AMBUL_OUTD_INFO O,
          CALL_INFO C,
          SYS_ORG_INFO J
    WHERE     A.LSH = O.LSH
          AND A.LSH = C.LSH
          AND O.SFQXPC = 0
          AND A.SJH > 0
          AND O.SZFZ = J.ORG_ID;
