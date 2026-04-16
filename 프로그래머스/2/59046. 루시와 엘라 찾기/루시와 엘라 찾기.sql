-- 코드를 입력하세요
# SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE from animal_ins
# where name in ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
# order by ANIMAL_ID asc;














SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS 
WHERE NAME IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
ORDER BY ANIMAL_ID