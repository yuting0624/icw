package servlet;

import java.util.List;
import java.util.Optional;

public class QueryCondition {
	private String name;
	private List<String> categories;

	public QueryCondition(String name, List<String> categories) {
		this.name = name;
		this.categories = categories;
	}

	public Optional<String> getName() {
		return Optional.ofNullable(name);
	}

	public Optional<List<String>> getCategories() {
		return categories.isEmpty()
				? Optional.empty()
				: Optional.of(categories);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
}
