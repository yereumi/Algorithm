-- 코드를 작성해주세요
SELECT COUNT(*) AS FISH_COUNT
FROM FISH_INFO info
JOIN FISH_NAME_INFO name ON info.FISH_TYPE = name.FISH_TYPE
WHERE name.FISH_NAME = 'SNAPPER' OR name.FISH_NAME = 'BASS';
