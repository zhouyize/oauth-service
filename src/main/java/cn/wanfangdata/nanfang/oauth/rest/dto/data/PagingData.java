package cn.wanfangdata.nanfang.oauth.rest.dto.data;

import java.util.List;



public class PagingData<T> {
	
	/**
	 * 
	 */
	public PagingData() {
		super();
	}
	/**
	 * @param paging
	 * @param list
	 */
	public PagingData(Paging paging, List<T> list) {
		super();
		this.paging = paging;
		this.list = list;
	}
	/**
	 * paging
	 */
	private Paging paging ;
	/**
	 * list
	 */
	private List<T>   list ;
	/**
	 * Get paging
	 * @return the paging
	 */
	public Paging getPaging() {
		return paging;
	}
	/**
	 * Set paging to the paging
	 * @param paging the paging to set
	 */
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	/**
	 * Get list
	 * @return the list
	 */
	public List<T> getList() {
		return list;
	}
	/**
	 * Set list to the list
	 * @param list the list to set
	 */
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
	
}
