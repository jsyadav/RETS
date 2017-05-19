package ui.irets.service.unifiedsr;

import java.util.ArrayList;
import java.util.List;

public class SearchParam {
    /*
    * Search string.
    * If searchString is empty, there will be no filtering,
    * just load full list from database.
    */
	private String searchString;

	/* the start index for supporting pagination. */
	private long startIndex = 0;

	/* the maximum number of records per page for supporting pagination. */
	private int pageSize = -1; //Value of -1 can be used to return all items list

   /* List of properties that are subject to search */
   private List<SortingParameter> sortingOrder = new ArrayList<SortingParameter>();
   
   /*List of fields and their values for performing multiple column searches
    * Each Field/Value is using LIKE Operator with Value
    * Multiple columns/fields are using operator AND, "search"
    * */
   private List<SearchParameter> exactSearchParameters = new ArrayList<SearchParameter>();
   
   /*List of fields and their values for performing multiple column searches
    * Each Field/Value is using LIKE Operator with %Value%
    * Multiple columns/fields are using operator AND, "search"
    * */
   private List<SearchParameter> searchParameters = new ArrayList<SearchParameter>();
   
   /*List of fields and their values for performing multiple column searches
    * Each Field/Value is using LIKE Operator with %Value%
    * Multiple columns/fields are using operator OR, "orSearch" 
    * */
   private List<SearchParameter> keywordSearchParameters = new ArrayList<SearchParameter>();
   
   private List<SimpleRange> rangeSearchParameters = new ArrayList<SimpleRange>();
   
   /*List of fields and their values for performing multiple column searches
    * Each Field/Value is using IN Operator with Value
    * Multiple columns/fields are using operator AND, "search"
    * */
   private List<SearchParameter> searchForFieldItemsParameters = new ArrayList<SearchParameter>();
   
   private GeoParameter geoSearchParameter;
   
   public SearchParam() {
   }

   public SearchParam(long start, int limit, final String sortField, String sortDirection) {
   	startIndex = start;
   	pageSize = limit;
   	sortingOrder.add(new SortingParameter(sortField, sortDirection!=null&&sortDirection.equals("ascending")));
   }

   
   
   public List<SearchParameter> getExactSearchParameters() {
	return exactSearchParameters;
}

public void setExactSearchParameters(List<SearchParameter> exactSearchParameters) {
	this.exactSearchParameters = exactSearchParameters;
}

public GeoParameter getGeoSearchParameter() {
	return geoSearchParameter;
   }

public void setGeoSearchParameter(GeoParameter geoSearchParameter) {
	this.geoSearchParameter = geoSearchParameter;
}

public String getSearchString() {
		return this.searchString;
	}

	public void setSearchString(String searchStr) {
		this.searchString = searchStr;
	}

   public long getStartIndex() {
		return this.startIndex;
	}

	public void setStartIndex(long startIdx) {
		this.startIndex = startIdx;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSz) {
		this.pageSize = pageSz;
	}

	public List<SortingParameter> getSortingOrder() {
		return this.sortingOrder;
	}

	public void setSortingOrder(List<SortingParameter> params) {
		this.sortingOrder = params;
	}

   public List<SearchParameter> getSearchParameters() {
		return searchParameters;
	}

	public void setSearchParameters(List<SearchParameter> searchParameters) {
		this.searchParameters = searchParameters;
	}

	public List<SearchParameter> getKeywordSearchParameters() {
		return keywordSearchParameters;
	}

	public void setKeywordSearchParameters(
			List<SearchParameter> keywordSearchParameters) {
		this.keywordSearchParameters = keywordSearchParameters;
	}

	/* Clear the filter list */
   public void clearSortProperties(String propName, Boolean ascending) {
   	sortingOrder.clear();
   }

   /* Add a property and search order to the filter list */
   public void addSortProperty(SortingParameter sortParam) {
   	sortingOrder.add(sortParam);
   }

	public List<SimpleRange> getRangeSearchParameters() {
		return rangeSearchParameters;
	}
	
	public void setRangeSearchParameters(List<SimpleRange> rangeSearchParameters) {
		this.rangeSearchParameters = rangeSearchParameters;
	}
   
	public List<SearchParameter> getSearchForFieldItemsParameters() {
		return searchForFieldItemsParameters;
	}
	
	public void setSearchForFieldItemsParameters(List<SearchParameter> SearchParameters) {
		this.searchForFieldItemsParameters = SearchParameters;
	}
   
}
