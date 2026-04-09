-- 코드를 작성해주세요
select 
child.id AS ID, 
child.genotype AS GENOTYPE,
parent.genotype AS PARENT_GENOTYPE
from ECOLI_DATA child
join ecoli_data parent
on child.parent_id = parent.id
where parent.genotype = (parent.genotype & child.genotype)
# where conv(parent.genotype, 10, 2) = conv(parent.genotype & child.genotype, 10, 2)
order by ID;