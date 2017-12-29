package cn.et.springmvc.lesson01.dao.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.et.springmvc.lesson01.dao.FoodDao;
@Repository
public class FoodDaoImpl implements FoodDao {

	@Autowired
	JdbcTemplate template;
	
	 public Integer getTableListCount(String name) throws Exception{
	        if(name==null){
	            name="";
	        }
	        String sql="select count(*) as cr from food where foodname like '%"+name+"%'";
	        List<Map<String, Object>> result=template.queryForList(sql);
	        return Integer.parseInt(result.get(0).get("cr").toString());
	    }
	
    /* (non-Javadoc)
	 * @see cn.et.springmvc.lesson01.dao.impl.FoodDao#getTableListPager(java.lang.String)
	 */
   public List<Map<String, Object>> getTableListPager(String name,int startIndex,int length) throws Exception{
       StringBuffer sb=new StringBuffer();
       String sql="select * from food t  where t.foodname like '%"+name+"%' limit  "+startIndex+","+length;
       List<Map<String, Object>> result=template.queryForList(sql);
       return result;
   }
   
   
   /* (non-Javadoc)
 * @see cn.et.springmvc.lesson01.dao.impl.FoodDao#saveFood(java.lang.String, java.lang.String, java.lang.String)
 */
public void saveFood(String foodName,String price,String imagePath) throws Exception{
       String sql="insert into food values((select nvl(max(foodid),0)+1 from food),'"+foodName+"','"+price+"','"+imagePath+"')";
       template.execute(sql);
   }
    
   
   /* (non-Javadoc)
 * @see cn.et.springmvc.lesson01.dao.impl.FoodDao#updateFood(java.lang.String, java.lang.String, java.lang.String)
 */
public void updateFood(String foodid,String foodName,String price,String path) throws Exception{
       String sql="update food set foodname='"+foodName+"',price='"+price+"',imagepath='"+path+"' where foodid="+foodid;
       template.execute(sql);
   }
   /* (non-Javadoc)
 * @see cn.et.springmvc.lesson01.dao.impl.FoodDao#deleteFoodType(java.lang.String)
 */
public void deleteFoodType(String foodid) throws Exception{
       String sql="delete from  food  where foodid="+foodid;
       template.execute(sql);
   }
public Map<String, Object> findById(String foodid) {
	 StringBuffer sb=new StringBuffer();
     String sql="select * from food t  where t.foodid = "+foodid;
     List<Map<String, Object>> result=template.queryForList(sql);
     return result.get(0);
	}

public List<Map<String, Object>> getTableListPager(String name)
		throws Exception {
	// TODO Auto-generated method stub
	return null;
}
}
