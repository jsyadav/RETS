package ui.irets.service.unifiedsr;

public class Filter {
    String[] keywords;
    FilterItem[] filters;
    FilterItem[] exactFilters;
    SimpleRange[] ranges;
    FilterItem[] searchForFieldItems;

    public FilterItem[] getExactFilters() {
		return exactFilters;
	}

	public void setExactFilters(FilterItem[] exactFilters) {
		this.exactFilters = exactFilters;
	}

	public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public FilterItem[] getFilters() {
        return filters;
    }

    public void setFilters(FilterItem[] filters) {
        this.filters = filters;
    }

	public SimpleRange[] getRanges() {
		return ranges;
	}

	public void setRanges(SimpleRange[] ranges) {
		this.ranges = ranges;
	}

	public FilterItem[] getSearchForFieldItems() {
		return searchForFieldItems;
	}

	public void setSearchForFieldItems(FilterItem[] searchForFieldItems) {
		this.searchForFieldItems = searchForFieldItems;
	}

	

}
