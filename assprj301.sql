--hien thi nhung ngay di lam
select e.eid,[name],office,wfrom,wto from Employee e inner join Working w
on w.eid = e.eid


--hien thi nhung ngay nghi
select e.eid,[name],office,lfrom,lto,reason from Employee e inner join Leave l
on l.eid= e.eid


--tong so ngay di lam
select COUNT(Working.eid) as allworking
from Working
where eid=?


--tinh tong ngay nghi
select COUNT(Leave.eid) as allleave
from Leave
where eid=?