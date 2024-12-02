-- Active: 1732689799045@@127.0.0.1@3306@world
-- 평균 인구수보다 인구가 많은 도시들 조회
SELECT c.`Name`
FROM city c
WHERE c.`Population` > (
  SELECT AVG(c.`Population`)
  FROM city c
)

-- 가장 많은 인구를 가진 도시의 국가 정보

-- 어떤 국가의 정보를 보여줘
SELECT co.Name
FROM country co
WHERE ~

-- 가장 많은 인구를 가진 도시의 국가코드
SELECT ci.`CountryCode`
FROM city ci
ORDER BY ci.`Population` DESC
LIMIT 1

-- 가장 많은 인구를 가진 도시의 국가 정보
SELECT co.Name
FROM country co
WHERE co.`Code` = (
  SELECT ci.`CountryCode`
  FROM city ci
  ORDER BY ci.`Population` DESC
  LIMIT 1
)

SELECT ci.`Name`, co.`Name`
FROM country co
JOIN city ci ON co.`Code` = ci.`CountryCode`
ORDER BY ci.`Population` DESC
LIMIT 1

-- 인구 500만 이상인 도시가 있는 국가 찾기

-- 국가는 국가인데
SELECT * 
FROM country co;

-- 인구 500만 이상인 도시가 있는
-- 전체에 대해서는 국가코드가 여러개 있음
SELECT * 
FROM city ci
WHERE ci.`Population` >= 5000000

-- 인구 500만 이상인 도시가 있는 국가 찾기
SELECT co.`Name`
FROM country co
WHERE co.`Code` IN (
  SELECT ci.`CountryCode`
  FROM city ci
  WHERE ci.`Population` >= 5000000
)

-- 위 select문과 동일하지만
-- 500만 이상의 인구를 가진 도시에 대한 정보 + 국가 정보
-- join을 하면 중복된 국가 코드가 계속 남아있음. => distinct로 해결
SELECT DISTINCT co.`Name`
FROM country co
JOIN city ci ON co.`Code` = ci.`CountryCode`
WHERE ci.`Population` >= 5000000