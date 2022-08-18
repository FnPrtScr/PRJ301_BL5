
select e.eid,[name],office,wfrom,wto from Employee e inner join Working w
on w.eid = e.eid

select e.eid,[name],office,lfrom,lto,reason from Employee e inner join Leave l
on l.eid= e.eid