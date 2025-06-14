SELECT U.USER_ID
     , U.NICKNAME
     , U.CITY || ' ' || U.STREET_ADDRESS1 || ' ' || U.STREET_ADDRESS2 AS 전체주소
     , REGEXP_REPLACE(U.TLNO, '([0-9]{3})([0-9]{3,4})([0-9]{4})', '\1-\2-\3') AS 전화번호
FROM USED_GOODS_USER U
JOIN (
    SELECT WRITER_ID
    FROM USED_GOODS_BOARD
    GROUP BY WRITER_ID
    HAVING COUNT(*) >= 3
) B
ON U.USER_ID = B.WRITER_ID
ORDER BY U.USER_ID DESC;
