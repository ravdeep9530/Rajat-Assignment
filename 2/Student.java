public class Student {
	
	private long id;
	private String name;
	private float marks;
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param age
	 */
	public Student(long id,String name,float marks) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the firstName
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	/**
	 * @return the age
	 */
	public float getMarks() {
		return marks;
	}
	/**
	 * @param age the age to set
	 */
	public void setMarks(float marks) {
		this.marks = marks;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", Name=" + name
				+ ", marks="
				+ marks + "]";
	}
}
