
--hien thi nhung ngay di lam
select e.eid,[name],office,w.wdate from Employee e inner join Working w
on w.eid = e.eid


--hien thi nhung ngay nghi
select e.eid,[name],office,l.ldate,reason,acceptleave from Employee e inner join Leave l
on l.eid= e.eid


--dem so ngay di lam
select COUNT(Working.eid) as countworking
from Working
where eid=?


--dem so ngay nghi
select COUNT(Leave.eid) as countleave
from Leave
where eid=?


--hien thi luong cua nhan vien bat ky
select e.eid,[name],office,s.salaryoffice from Employee e inner join SalaryOffice s 
on s.eid=e.eid
where e.eid=?


--hien thi so tien ung cua nhan vien bat ky
select e.eid,[name],office,sa.datesa,sa.howmuchsa,sa.reasonsa,sa.acceptsa from Employee e inner join SalaryAdvance sa
on sa.eid=e.eid
where e.eid=?


--hien thi nhung nguoi di lam trong 1 ngay bat ky
SELECT e.eid,[name], ISNULL(w.wid,-1) wid, w.wdate FROM Employee e 
LEFT JOIN (SELECT * FROM Working WHERE wdate >= ? AND wdate <= ? ) w 
ON e.eid = w.eid

--hien thi nhung nguoi nghi lam trong 1 ngay bat ky
SELECT e.eid,[name], ISNULL(l.lid,-1) lid, l.lfrom,lto FROM Employee e 
LEFT JOIN (SELECT * FROM Leave WHERE lfrom >= ? and lto <= ? ) l 
ON e.eid = l.eid
