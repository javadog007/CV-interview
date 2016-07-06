package basic.db;
/**
 * Java中级：Oracle数据库  之  多表连接
 * @author 孟洛
 * 
 * 目录：
 * 一.什么是多表查询
 * 二.笛卡尔集
 * ---------------------------->重点<----------------------------
 * 三.等值连接
 * 四.不等值连接
 * 五.外链接
 * 六.自连接
 * ---------------------------->重点<----------------------------
 * 七.层次查询[拓展：解决自连接的问题]
 * 
 * 一.什么是多表查询
 * 
 * 二.笛卡尔集
 * 
 * 笛卡尔集是一个数学概念，是多表查询的理论基础
 * 
 * 举例：有部门表dept 2行2列 / 雇员表 3行4列
 * 
 * 那么，笛卡尔集合 emp*dept 就是2*3=6行4+2=6列
 * 
 * 那么，就说这个大的表是两个小表的笛卡尔集
 * 
 * 笛卡尔集不一定是正确的， 多表查询的本质就是找出笛卡尔积中的错误行查出正确的
 * 
 * 关键点：连接条件
 * 
 * 连接条件至少有:(表-1)个
 * 
 * 三.等值连接
 * 
 *   练习：查询员工信息，要求显示：员工号、姓名、月薪、部门名称
 *   
 *   SELECT e.empno,e.ename,e.sal,d.dname FROM emp e,dept d WHERE 
	 e.deptno = d.deptno
	 
      四.不等值连接
      
             练习：查询员工信息，要求显示：员工号、姓名、月薪、薪水级别
             
     SELECT e.empno,e.ename,e.sal,s.grade FROM emp e,salgrade s WHERE 
	 e.sal BETWEEN s.losal AND s.hisal
	 
      五.外链接
      
           练习：按部门统计员工人数，要求显示：部门号、部门名称、员工人数
	 
	 第一反应：SELECT d.deptno,d.dname,COUNT(e.empno) FROM emp e,dept d 
			WHERE e.deptno = d.deptno GROUP BY d.deptno,d.dname 
			
   	 但是，会发现只查询到了三个部门，实际却又四个部门
   	 
   	  原因是：存在40号部门，但是40号部门没有员工，因此等值连接对于40号部门不成立
   	 SELECT * FROM emp WHERE deptno = 40 可以验证40号部门是没有数据的
   	 
   	 外链接：把对于连接条件不成立的记录，也包含在最后的结果中
   	 
   	 外链接分为：左外连接和右外链接
	
	  左外链接：当连接条件不成立时，等号左边的表仍然被包含[和右外同理]
	  右外连接：当连接条件不成立时，等号右边的表仍然被包含[右边是有东西的，左边没有数据不要影响右边，要把右边数据显示出来]
	 写法：在等号左边写个"(+)"
	 
	 用右外连接改进：[右边的部门是有数据的，在左边写个"(+)"显示出来右边应该被显示出来的数据]
	 SELECT d.deptno,d.dname,COUNT(e.empno) FROM emp e,dept d 
	 WHERE e.deptno(+)=d.deptno GROUP BY d.deptno,d.dname 
	 
	 如果是左外连接[重点看写法]：
	 SELECT d.deptno,d.dname,COUNT(e.empno) FROM emp e,dept d 
	 WHERE e.deptno=d.deptno(+) GROUP BY d.deptno,d.dname 
	 
	六.自连接[都在一张表中]
	
		练习：查询员工姓名和员工老板的姓名
		
		分析：虽然表面上只有一张表，但还是应该找到连接条件[员工老板号=老板员工号]
		
		自连接核心：通过给一张表起两个别名，把一张表视为两张表
		
		SELECT e.ename 员工姓名,m.ename 老板姓名 FROM emp e,emp m WHERE e.mgr = m.empno

	七.层次查询[拓展：解决自连接的问题]
	
		自连接问题：自连接把一张表看成多个表，笛卡尔全集很大
		解决：层次查询
		
		层次查询是单表查询，只有在一张表的前提下才不会产生笛卡尔集
		
		SELECT empno,ename,sal,mgr FROM emp CONNECT BY PRIOR empno=mgr
		START WITH empno=7839
		
		其中，PRIOR 表示上一级元素，START WITH 表示遍历的起始位置
		
		员工老板上下级关系可以理解为一棵树，在层次查询中可以用伪劣level表示
		用伪列改进层次查询：
		
		SELECT level,empno,ename,sal,mgr FROM emp CONNECT BY PRIOR empno=mgr
		START WITH empno=7839 ORDER BY 1
		
		比较层次查询和自连接查询：
		
		层次查询本质是单表查询，查询效率高，但是结果不够清晰；而自连接结果清晰，但笛卡尔集巨大，不适合
		操作大量数据
 * 
 */
public class Test4 {

}
