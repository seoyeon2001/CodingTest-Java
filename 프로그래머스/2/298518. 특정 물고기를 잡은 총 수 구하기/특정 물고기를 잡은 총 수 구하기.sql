-- 코드를 작성해주세요
select count(*) as FISH_COUNT
from fish_info fi 
join fish_name_info fmi 
on fi.fish_type = fmi.fish_type
WHERE fmi.FISH_NAME IN ('BASS','SNAPPER');