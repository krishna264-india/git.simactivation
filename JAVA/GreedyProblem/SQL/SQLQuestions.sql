1.find second second highest salary from employee table;
select max(salary) 
   from employee 
       where salary < (select max(salary) from employee);

2.find nth highest salary from employee table;
select salary from (
   select salary, dense_rank() over (order by salary desc) as rnk
   from employee
) where rnk = n;

3.find lowest salary from employee table;
select min(salary) from employee;

4.find average salary from employee table;
select avg(salary) from employee;

5.find total salary from employee table;
select sum(salary) from employee;

6.find number of employees from employee table;
select count(*) from employee;

7.find second lowest salary from employee table;
select min(salary) 
   from employee 
       where salary > (select min(salary) from employee);

8.find second highest avarage salary from employee table;
select avg(salary) 
from employee group by department 
order by avg(salary) desc limit 1 offset 1

/*joints*/
1.find all employees with their department names;
select e.name, d.name
from employee e
join department d on e.department_id = d.id;

2.find all employees with their manager names;
select e.name, m.name
from employee e
join employee m on e.manager_id = m.id;

3.left join to find all employees and their department names (including those without a department);
select e.name, d.name
from employee e
left join department d on e.department_id = d.id;

4.right join to find all departments and their employee names (including those without employees);
select e.name, d.name
from employee e
right join department d on e.department_id = d.id;

5.full outer join to find all employees and their department names (including those without a department and those without employees);
select e.name, d.name
from employee e
full outer join department d on e.department_id = d.id;

