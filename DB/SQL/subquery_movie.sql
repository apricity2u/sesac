-- Active: 1732689799045@@127.0.0.1@3306@sakila
-- 적어도 한 번이라도 대여된 적이 있는 영화들 찾기

-- 영화는 영화인데
SELECT * 
FROM film f 
WHERE

-- 적어도 한 번이라도 대여된 적이 있는
-- 영화에 출연한 배우의 수처럼 inventory id까지만 있으면 됨
SELECT i.film_id
FROM rental r
JOIN inventory i ON r.inventory_id = r.inventory_id

-- 적어도 한 번이라도 대여된 적이 있는 영화들 찾기
-- distinct로 중복제거 => 몇 개 대여되었는지는 중요하지 않음 (한 번이라도 대여된 적 있는~)
SELECT f.title
FROM film f 
WHERE f.film_id IN (
  SELECT DISTINCT i.film_id
  FROM rental r
  JOIN inventory i ON r.inventory_id = r.inventory_id
)

SELECT f.title
FROM film f
WHERE EXISTS (
  -- 존재성을 나타내는 숫자 1 (있으면 1)
    SELECT 1 
    FROM rental r 
    JOIN inventory i ON r.inventory_id = i.inventory_id
    WHERE i.film_id = f.film_id
);

SELECT DISTINCT f.title
FROM film f
JOIN inventory i ON f.film_id = i.film_id
JOIN rental r ON i.inventory_id = r.inventory_id
WHERE r.inventory_id IS NOT NULL


-- 평균 대여 금액(rental_rate)보다 비싼 영화를 조회하시오. - sakila
SELECT f.title, f.rental_rate
FROM film f
WHERE rental_rate > (
  SELECT AVG(rental_rate)
  FROM film f
)
ORDER BY f.rental_rate DESC

-- 대여 횟수가 40회 이상인 고객이 대여한 영화들을 조회하시오 - sakila

SELECT DISTINCT f.title
FROM film f
WHERE f.film_id IN (
  SELECT i.film_id
  FROM rental r
  JOIN inventory i ON r.inventory_id = i.inventory_id
  WHERE r.customer_id IN (
    SELECT customer_id
    FROM rental
    GROUP BY customer_id
    HAVING COUNT(rental_id) >= 40
  )
)

-- Action 카테고리 영화를 한번도 빌린적 없는 고객을 조회하시오
-- 고객을 조회하시오 - Action 카테고리 영화에 대한 대여 기록이 존재하지 않는

SELECT c.first_name, c.last_name
FROM customer c
WHERE NOT EXISTS (
    SELECT 1
    FROM rental r
    JOIN inventory i ON r.inventory_id = i.inventory_id
    JOIN film_category fc ON i.film_id = fc.film_id
    JOIN category cat ON fc.category_id = cat.category_id
    WHERE r.customer_id = c.customer_id
    AND cat.name = 'Action'
);

SHOW INDEX FROM film 