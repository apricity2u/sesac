-- Active: 1732689799045@@127.0.0.1@3306@sakila

-- 배우와 출연 영화 목록
-- 한 배우는 여러 영화에 출연할 수 있고, 한 영화에는 여러 배우들이 참여할 수 있다.

-- 배우가 출연한 영화 조회
SELECT a.first_name,
       a.last_name, 
       f.title
FROM actor a
LEFT JOIN film_actor fa ON a.actor_id = fa.actor_id
LEFT JOIN film f ON fa.film_id = f.film_id

SELECT a.first_name, a.last_name, f.title
FROM film f
LEFT JOIN film_actor fa ON f.film_id = fa.film_id
LEFT JOIN actor a ON a.actor_id = fa.actor_id
WHERE a.actor_id IS NULL
-- 배우가 없는 다큐멘터리가 있을 때, 영화 상세정보 조회에서 출연한 배우 목록을 확인하고 싶다
-- 다큐멘터리 영화도 영화 상세정보 페이지에서 보여주고 싶을 때, Left Join 사용

-- 배우별 출연 영화 수
-- 영화 수니까 영화 데이터는 필요가 없음 (배우-영화의 중계테이블 수만 세어주면 됨)
SELECT a.actor_id, a.first_name, a.last_name, COUNT(fa.film_id) as film_cnt
FROM actor a
LEFT JOIN film_actor fa ON a.actor_id = fa.actor_id
-- LEFT JOIN film f ON fa.film_id = f.film_id
GROUP BY a.actor_id, a.first_name, a.last_name

-- 영화 별 출연 배우 수
SELECT f.title, COUNT(fa.actor_id) as actor_cnt
FROM film f
LEFT JOIN film_actor fa ON f.film_id = fa.film_id
-- LEFT JOIN actor a ON fa.actor_id = a.actor_id
GROUP BY f.title

-- 영화의 카테고리 정보
SELECT f.title, c.name
FROM film f
INNER JOIN film_category fc ON f.film_id = fc.film_id
LEFT JOIN category c ON fc.category_id = c.category_id

-- 영화가 가지는 카테고리의 개수
SELECT f.title, COUNT(fc.category_id) as category_cnt
FROM film f
INNER JOIN film_category fc ON f.film_id = fc.film_id
-- LEFT JOIN category c ON fc.category_id = c.category_id
GROUP BY f.film_id
ORDER BY category_cnt DESC

-- 카테고리 별 영화 수
SELECT c.name, COUNT(f.film_id) as film_cnt
FROM film f
INNER JOIN film_category fc ON f.film_id = fc.film_id
LEFT JOIN category c ON fc.category_id = c.category_id
GROUP BY c.category_id

SELECT c.name, COUNT(f.film_id)
FROM category c
INNER JOIN film_category fc ON c.category_id = fc.category_id
INNER JOIN film f ON fc.film_id = f.film_id
GROUP BY c.name

-- 배우가 출연한 영화를 카테고리 포함 조회
SELECT a.first_name,
       a.last_name, 
       f.title,
       c.name AS category
FROM actor a
INNER JOIN film_actor fa ON a.actor_id = fa.actor_id
INNER JOIN film f ON fa.film_id = f.film_id
INNER JOIN film_category fc ON f.film_id = fc.film_id
LEFT JOIN category c ON fc.category_id = c.category_id


-- 고객의 기본 정보, 주소 조회
SELECT c.first_name, c.last_name, a.address
FROM customer c
LEFT JOIN address a ON c.address_id = a.address_id

-- 고객의 기본 정보, 주소, 도시 조회
SELECT c.first_name, c.last_name, a.address, ci.city
FROM customer c
LEFT JOIN address a ON c.address_id = a.address_id
LEFT JOIN city ci ON a.city_id = ci.city_id
ORDER BY ci.city

-- 고객의 기본 정보, 주소, 도시, 국가 조회
SELECT c.first_name, c.last_name, a.address, ci.city, co.country
FROM customer c
LEFT JOIN address a ON c.address_id = a.address_id
LEFT JOIN city ci ON a.city_id = ci.city_id
LEFT JOIN country co ON ci.country_id = co.country_id
ORDER BY co.country

-- London(city)에 사는 고객의 기본 정보, 주소, 도시 조회
SELECT c.first_name, c.last_name, a.address, ci.city, co.country
FROM customer c
LEFT JOIN address a ON c.address_id = a.address_id
LEFT JOIN city ci ON a.city_id = ci.city_id
LEFT JOIN country co ON ci.country_id = co.country_id
WHERE ci.city = 'London'
ORDER BY co.country

-- 도시별 고객 수 조회
SELECT ci.city, COUNT(c.customer_id) as customer_cnt
FROM customer c
LEFT JOIN address a ON c.address_id = a.address_id
LEFT JOIN city ci ON a.city_id = ci.city_id
GROUP BY ci.city
ORDER BY customer_cnt DESC