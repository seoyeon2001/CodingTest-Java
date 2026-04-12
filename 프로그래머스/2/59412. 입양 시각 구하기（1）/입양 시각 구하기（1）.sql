-- 코드를 입력하세요
SELECT hour(datetime) AS HOUR, count(*) AS COUNT from ANIMAL_OUTS
where hour(datetime) between 9 and 19
group by HOUR
order by HOUR