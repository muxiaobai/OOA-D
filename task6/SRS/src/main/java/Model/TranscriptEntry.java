package Model;
// TranscriptEntry.java - Chapter 14, Java 5 version.

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

// Copyright 2005 by Jacquie Barker - all rights reserved.

// A MODEL class.

@Entity
public class TranscriptEntry {
	//------------
	// Attributes.
	//------------
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String grade;//成绩
	@OneToOne(targetEntity=Student.class)
	private Student student;//学生
	@ManyToOne(targetEntity=Section.class)
	@JoinColumn(name="section_id",referencedColumnName="id")
	private Section section;//课程
	private Transcript transcript;//归属哪一个成绩单

	//----------------
	// Constructor(s).
	//----------------
	public TranscriptEntry() {
		// TODO Auto-generated constructor stub
	}
	public TranscriptEntry(Student s, String grade, Section se) {
		this.setStudent(s);
		this.setSection(se);
		this.setGrade(grade);

		// Obtain the Student's transcript ...

		Transcript t = s.getTranscript();

		// ... and then link the Transcript and the TranscriptEntry
		// together bidirectionally.

		this.setTranscript(t);
		t.addTranscriptEntry(this);
	}

	//------------------
	// Accessor methods.
	//------------------
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	
	public void setStudent(Student s) {
		student = s;
	}

	public Student getStudent() {
		return student;
	}

	public void setSection(Section s) {
		section = s;
	}

	public Section getSection() {
		return section;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGrade() {
		return grade;
	}

	public void setTranscript(Transcript t) {
		transcript = t;
	}

	public Transcript getTranscript() {
		return transcript;
	}
	
	@Override
	public String toString() {
		return "TranscriptEntry [id=" + id + ", grade=" + grade + ", student=" + student + ", section=" + section
				+ ", transcript=" + transcript + "]";
	}
	//-----------------------------
	// Miscellaneous other methods.
	//-----------------------------

	
	// These next two methods are declared to be static, so that they
	// may be used as utility methods.
	/**
	 * 判定成绩是否有效
	 * @param grade
	 * @return
	 */
	public static boolean validateGrade(String grade) {
		boolean outcome = false;

		if (grade.equals("F") ||
		    grade.equals("I")) {
			outcome = true;
		}

		if (grade.startsWith("A") ||
		    grade.startsWith("B") ||
		    grade.startsWith("C") ||
		    grade.startsWith("D")) {
			if (grade.length() == 1) outcome = true;
			else if (grade.length() == 2) {
				if (grade.endsWith("+") ||
				    grade.endsWith("-")) {
					outcome = true;
				}
			}
		}

		return outcome;
	}
	/**
	 * 数否通过
	 * @param grade
	 * @return ABCD为通过，其他，不通过
	 */
	public static boolean passingGrade(String grade) {
		boolean outcome = false;

		// First, make sure it is a valid grade.

		if (validateGrade(grade)) {
			// Next, make sure that the grade is a D or better.

			if (grade.startsWith("A") ||
			    grade.startsWith("B") ||
			    grade.startsWith("C") ||
			    grade.startsWith("D")) {
				outcome = true;
			}
		}

		return outcome;
	}
}
