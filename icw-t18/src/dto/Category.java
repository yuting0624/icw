package dto;

public class Category {
	/** カテゴリーID */
	private final Integer id;

	/** カテゴリー */
	private final String name;

	public Category(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
