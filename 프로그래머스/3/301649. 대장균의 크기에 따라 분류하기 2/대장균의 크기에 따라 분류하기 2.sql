SELECT ID
    -- NTILE : 특정한 컬럼의 값을 기준으로 N개의 등급으로 분류해주는 함수
    -- NTILE(그룹으로 나눌 정수) OVER (PARTITION BY [컬럼1] ORDER BY [컬럼2])
    -- PARTITION BY를 지정하면 해당 파티션 내에서 그룹화를 진행하여 행번호 부여
    -- PARTITION BY를 생략하면 전체 행에 대해서 그룹화가 수행됨
    , CASE NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) 
        WHEN 1 THEN 'CRITICAL'
        WHEN 2 THEN 'HIGH'
        WHEN 3 THEN 'MEDIUM'
        WHEN 4 THEN 'LOW'
        END AS COLONY_NAME
FROM ECOLI_DATA
ORDER BY ID