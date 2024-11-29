-- Active: 1732689799045@@127.0.0.1@3306@sakila

-- 1. 배우가 출연한 영화의 제목을 조회
SELECT a.first_name, a.last_name, f.title
FROM actor a
JOIN film_actor fa ON a.actor_id = fa.actor_id
JOIN film f ON fa.film_id = f.film_id

-- 2. first_name이 `PENELOPE` 인 배우가 출연한 영화의 제목을 조회
SELECT a.first_name, a.last_name, f.title
FROM actor a
JOIN film_actor fa ON a.actor_id = fa.actor_id
JOIN film f ON fa.film_id = f.film_id
WHERE a.first_name = 'PENELOPE'

-- 3. 영화 별 출연 배우의 수를 조회
SELECT f.title, COUNT(fa.actor_id) AS actor_count
FROM film f
JOIN film_actor fa ON f.film_id = fa.film_id
GROUP BY f.film_id
ORDER BY actor_count DESC

-- 4. 영화 별 출연 배우의 수가 5가 넘는 데이터를 배우의 수가 큰순으로 조회
SELECT f.title, COUNT(fa.actor_id) AS actor_count
FROM film f
JOIN film_actor fa ON f.film_id = fa.film_id
GROUP BY f.film_id
HAVING actor_count > 5
ORDER BY actor_count DESC

-- 5. 고객의 대여 정보 조회
SELECT c.first_name, c.last_name, r.*
FROM customer c
JOIN rental r ON c.customer_id = r.customer_id

-- 6. 고객이 대여한 영화 정보 조회
SELECT c.first_name, c.last_name, f.*
FROM customer c
JOIN rental r ON c.customer_id = r.customer_id
JOIN inventory i ON r.inventory_id = i.inventory_id
JOIN film f ON i.film_id = f.film_id
ORDER BY c.first_name

-- 7. `YENTL IDAHO` 영화를 대여한 고객 정보 조회
SELECT f.title, c.*
FROM film f
JOIN inventory i ON i.film_id = f.film_id
JOIN rental r ON r.inventory_id = i.inventory_id
JOIN customer c ON c.customer_id = r.customer_id
WHERE f.title = 'YENTL IDAHO'
ORDER BY c.first_name

-- 8. 배우별로 출연한 영화의 등급(rating)을 조회
SELECT a.actor_id, a.first_name, a.last_name, f.title, f.rating
FROM actor a
JOIN film_actor fa ON a.actor_id = fa.actor_id
JOIN film f ON fa.film_id = f.film_id
GROUP BY a.actor_id, a.first_name, a.last_name, f.title, f.rating

-- 9. 1번 고객이 자주 대여한 영화의 카테고리를 찾으시오
SELECT ca.name AS category, COUNT(ca.category_id) AS category_cnt
FROM customer c
LEFT JOIN rental r on c.customer_id = r.customer_id
LEFT JOIN inventory i on r.inventory_id d= i.inventory_id
LEFT JOIN film f on i.film_id = f.film_i
LEFT JOIN film_category fc ON f.film_id = fc.film_id
LEFT JOIN category ca ON fc.category_id = ca.category_id
WHERE c.customer_id = 1
GROUP BY category
ORDER BY category_cnt DESC
LIMIT 1

-- 10. 각 직원이 일하는 매장의 주소와 도시를 조회
SELECT s.first_name, s.last_name, a.address, c.city
FROM staff s
JOIN store st ON s.store_id = st.store_id
JOIN address a ON st.address_id = a.address_id
JOIN city c ON a.city_id = c.city_id

-- 11. 고객별로 대여한 영화 제목과 지불한 금액, 날짜를 조회
SELECT c.first_name, c.last_name, f.title, p.amount, p.payment_date
FROM customer c
JOIN rental r ON c.customer_id = r.customer_id
JOIN payment p ON r.rental_id = p.rental_id
JOIN inventory i ON r.inventory_id = i.inventory_id
JOIN film f ON i.film_id = f.film_id
GROUP BY c.customer_id, c.first_name, c.last_name, f.title, p.amount, p.payment_date

-- 12. 국가별 고객 수를 조회
SELECT co.country, COUNT(c.customer_id) AS customer_cnt
FROM country co
JOIN city ci ON co.country_id = ci.country_id
JOIN address a ON ci.city_id = a.city_id
JOIN customer c ON a.address_id = c.address_id
GROUP BY co.country