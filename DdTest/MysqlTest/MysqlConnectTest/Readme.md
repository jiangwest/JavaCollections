## 简单MySQL连接
- 测试时 **Error**: *The server time zone value is unrecognized or represents more than one time zone*
- solution:，
`url=jdbc:MySQL://localhost:3306/test?useUnicode=true$characterEncoding=utf8`
改为
`url=jdbc:mysql://localhost:3306/test?serverTimezone=UTC`


- this example use **World** database, which is a part of MySql Sample Database and along with **Sakila**, as the test database.
  - **city** is a table of **World** database
  
Table **city** field struct

```sql
CREATE TABLE city (
	`ID` INT(11) NOT NULL AUTO_INCREMENT,
	`Name` CHAR(35) NOT NULL DEFAULT '',
	`CountryCode` CHAR(3) NOT NULL DEFAULT '',
	`District` CHAR(20) NOT NULL DEFAULT '',
	`Population` INT(11) NOT NULL DEFAULT '0'
)
```
