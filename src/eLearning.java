

public class eLearning {
	private String subject;
	private String teacher;
	private int chapter;
	private double timeTotal;
	
	public eLearning(String subject, String teacher, int chapter, double timeTotal) {
		this.subject = subject;
		this.teacher = teacher;
		this.chapter = chapter;
		this.timeTotal = timeTotal;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public int getChapter() {
		return chapter;
	}
	public void setChapter(int chapter) {
		this.chapter = chapter;
	}
	
	public double getTimeTotal() {
		return timeTotal;
	}

	public void setTimeTotal(double timeTotal) {
		this.timeTotal = timeTotal;
	}

	public String toString() {
		return "\n[E-Learning Information] \n\nSubject: " + subject + "\nTeacher: " + teacher +  "\nTotal Chapter: " + chapter + "\nTotal Hours: " + timeTotal;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		eLearning other = (eLearning) obj;
		if (chapter != other.chapter)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!teacher.equals(other.teacher))
			return false;
		if (Double.doubleToLongBits(timeTotal) != Double.doubleToLongBits(other.timeTotal))
			return false;
		return true;
	}
	
}
