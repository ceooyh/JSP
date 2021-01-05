package obj;

public class Lotto {
	private int set;

	
	public Lotto(int set) {
		super();
		this.set = set;
	}

	public int getSet() {
		return set;
	}

	public void setSet(int set) {
		this.set = set;
	}

	@Override
	public String toString() {
		return "lotto [set=" + set + "]";
	}
	
	
}
