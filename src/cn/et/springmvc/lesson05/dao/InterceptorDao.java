package cn.et.springmvc.lesson05.dao;


public interface InterceptorDao {
	/**
	 * 修改余额
	 * @param money
	 */
	public void updateMoney(Integer money);
	
	/**
	 * 查询余额
	 * @return
	 */
	public Integer selectMoney();
}
