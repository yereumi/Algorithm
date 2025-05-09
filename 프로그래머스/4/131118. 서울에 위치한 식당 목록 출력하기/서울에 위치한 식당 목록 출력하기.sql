-- 코드를 입력하세요
SELECT info.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, ROUND(AVG(REVIEW_SCORE), 2) AS SCORE
FROM REST_INFO info
JOIN REST_REVIEW review ON info.REST_ID = review.REST_ID
WHERE info.ADDRESS LIKE '서울%'
GROUP BY info.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS
ORDER BY SCORE DESC, FAVORITES DESC;