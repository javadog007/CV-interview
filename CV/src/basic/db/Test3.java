package basic.db;
/**
 * Java中级：数据库  之  分组函数
 * @author 孟洛
 *
 * 一.常用的分组函数
 * 
 * 1.avg
 * 2.sum
 * 3.min
 * 4.max
 * 5.count + distinct(去掉重复记录) eg:SELECT COUNT(DISTINCT sal) FROM emp
 * 6.wm_concat ps concat:字符串拼接 、 wm_concat：行转列
 * 
 * 练习:
 * 
 * 1.求员工平均工资和总工资
 * 
 * SELECT AVG(sal),SUM(sal) FROM emp
 * 
 * 2.查询部门编号和员工姓名并根据部门编号分组
 * 
 * SELECT deptno 部门编号,wm_concat(ename) 员工姓名 FROM emp GROUP BY deptno
 * 
 * 3.分组函数中的空值问题
 * 
 * SELECT SUM(comm)/COUNT(*) 一,SUM(comm)/count(comm) 二,AVG(comm) FROM emp
 * 
 * 观察到：第一个值和后面两个值是不同的，因为COUNT(*) 和 count(comm)是不同的,count(comm)分组
 * 函数自动过滤掉空值。可以使用nvl屏蔽滤空功能
 * 
 * SELECT SUM(comm)/COUNT(*) 一,SUM(comm)/count(nvl(comm,0)) 二,AVG(nvl(comm,0)) FROM emp
 * 
 * 此时，三个值就一样了，都把空值也算上了
 * 
 * 二.group by 分组子句
 * 
 *  练习：
 *  
 *  1.求出各部门员工平均工资
 *  
 *  SELECT deptno,AVG(sal) FROM emp GROUP BY deptno
 *  
 *  语法规定：select 后面的必须在 group by 后面，在group by后面的不一定在select后面
 *  
 *  eg:SELECT AVG(sal) FROM emp GROUP BY deptno //也就是说：分组的元素不一定要显示出来
 *  
 *  2.按照部门号和职位统计员工的工资总额
 *  
 *  SELECT deptno,job,SUM(sal) FROM emp GROUP BY deptno,job ORDER BY deptno
 *  
 *  三.过滤 having 和 where
 *  
 *  练习：
 *  
 *  1.求平均工资大于2000的部门
 *  
 *  SELECT deptno,AVG(sal) FROM emp GROUP BY deptno HAVING AVG(sal)>2000
 *  
 *  解释：having 就是过滤分组数据
 *  
 *  问题：where和having都有过滤的功能，区别在哪？
 *  
 *  A.语法顺序 select ... from ... where ... group by ... having ... order by ...
 *  B.having可以跟分组函数,where不可以
 *  C.从sql优化的角度看，尽量用where
 *  
 *  解释C:因为where是先限定了小范围再从小范围中分组，而having是先分组，在限定
 *  
 *  在一些情况下，where和having都可以实现相同的功能
 *  
 *  2.查询10号部门的平均工资
 *  
 *  SELECT deptno,AVG(sal) FROM emp WHERE deptno=10 GROUP BY deptno
 *  SELECT deptno,AVG(sal) FROM emp GROUP BY deptno HAVING deptno=10
 *  
 *  3.求部门平均工资的最大值
 *  
 *  SELECT MAX(AVG(sal)) FROM emp GROUP BY deptno
 *  
 *  解释：分组函数是可以嵌套的
 *  
 *  四.group by rollup(a,b) 语句的增强[主要用作制作报表]  非面试涉及重点，了解即可
 *  
 *  语法：group by rollup(a,b) = group by a,b + group by a + group by null
 *  
 *  A> 按部门、职位统计工资总额 select deptno,job,sum(sal) from emp group by deptno,job
 *  B> 统计各个部门工资总额         select deptno,sum(sal) from emp group by deptno
 *  C> 统计所有部门员工工资总额  select sum(sal) from emp
 *  
 *  A+B+C = select deptno,job,sum(sal) from emp group by rollup(deptno,job)
 *  
 *  在命令行中： break on deptno skip 1 相同的部门编号显示一次，并且换一行[调整样式]
 *  
 *  五.命令行的报表功能  非面试涉及重点，略
 *  
 *  
 *  
 *  
 *  
 *
 *  
 *  
 *  
 *  
 *  
 *  
 * 
 * 
 */
public class Test3 {

}
