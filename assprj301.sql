--hien thi nhung ngay di lam
select e.eid,[name],office,wfrom,wto from Employee e inner join Working w
on w.eid = e.eid


--hien thi nhung ngay nghi
select e.eid,[name],office,lfrom,lto,reason from Employee e inner join Leave l
on l.eid= e.eid


--dem so ngay di lam
select COUNT(Working.eid) as allworking
from Working
where eid=?


--dem so ngay nghi
select COUNT(Leave.eid) as allleave
from Leave
where eid=?


--hien thi luong cua nhan vien bat ky
select e.eid,[name],office,s.salary from Employee e inner join SalaryOffice s 
on s.eid=e.eid
where e.eid=?