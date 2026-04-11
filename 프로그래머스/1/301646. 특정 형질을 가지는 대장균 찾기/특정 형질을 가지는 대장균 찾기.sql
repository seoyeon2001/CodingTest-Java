-- 코드를 작성해주세요
select count(*) AS COUNT from ECOLI_DATA
where genotype & b'0010' = 0 and (genotype & b'0100' or genotype & b'0001')