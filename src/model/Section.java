package model;

public class Section {
	@Column(name = "SECTION_NUMBER")
	private byte number;// short is chosen because it is likely that a class section number will be <
								// 127
	@Column(name = "SECTION_MAX_CAPACITY")
	private short maxCapacity;// short is chosen because a lecture hall class could be > 127(size of byte)

	public Section() {
	}

	public Section(byte number, short maxCapacity) {
	        this.number = number;
	        this.maxCapacity = maxCapacity;
	}

	@Override
	public String toString() {
		return "Section Number " + number + " (maxCapacity " + maxCapacity + ")";
	}

	public byte getSectionNumber() {
		return number;
	}

	public void setSectionNumber(byte number) {
		this.number = number;
	}

	public short getMaxCapacity() {
		return maxCapacity;
	}
	
	public void setMaxCapacity(byte maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
}
