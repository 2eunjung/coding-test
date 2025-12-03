-- 코드를 입력하세요
SELECT F.CATEGORY
    , F.PRICE
    , F.PRODUCT_NAME
FROM FOOD_PRODUCT F
    JOIN (SELECT CATEGORY, MAX(PRICE) AS PRICE
          FROM FOOD_PRODUCT
          GROUP BY CATEGORY        
         ) A
    ON F.CATEGORY = A.CATEGORY
    -- 가장 비싼 가격의 상품을 가져오기 위해 추가 조건
        AND F.PRICE = A.PRICE
WHERE F.CATEGORY IN ('과자', '국', '김치', '식용유')
ORDER BY F.PRICE DESC