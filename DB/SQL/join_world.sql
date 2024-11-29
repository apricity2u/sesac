-- Active: 1732689799045@@127.0.0.1@3306@world

-- 도시와 국가 정보 연결 world

-- 1. 도시의 입장에서 도시가 있는 국가를 함께 조회
SELECT city.Name as CityName, 
       country.Name as CountryName,
       country.Continent
FROM city
INNER JOIN country ON city.CountryCode = country.Code

-- 2. 국가의 입장에서 국가가 가지고 있는 도시를 함께 조회
SELECT country.`Name`, city.`Name` 
FROM country
INNER JOIN city ON country.`Code`  = city.`CountryCode`
WHERE country.`Code` = 'KOR'
ORDER BY city.`Name`




-- 도시와 국가 정보 연결 world
-- 한 도시는 여러 국가에 속할 수 없고, 한 국가에는 여러 도시들이 속할 수 있다. (1:N)
-- 도시가 가진 국가를 확인하려면?
SELECT ci.`Name`, ci.`CountryCode`
FROM city ci
INNER JOIN country co ON ci.`CountryCode` = co.`Code`

-- 모든 국가와 수도 정보 world
-- 한 국가에는 수도가 하나 뿐이고, 수도도 하나의 국가에만 속할 수 있다 (1:1)
-- 국가별 수도를 확인하려면?
SELECT co.`Name`, ci.`Name`
FROM country co
LEFT JOIN city ci ON co.`Capital` = ci.id

